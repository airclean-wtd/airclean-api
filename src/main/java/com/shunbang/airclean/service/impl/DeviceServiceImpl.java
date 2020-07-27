package com.shunbang.airclean.service.impl;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.exception.NoneException;
import com.shunbang.airclean.mapper.DataConfigMapper;
import com.shunbang.airclean.mapper.DeviceMapper;
import com.shunbang.airclean.model.bean.Device;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.filter.DeviceFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.DeviceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shunbang.airclean.service.IDeviceService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "deviceService")
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Pager<DeviceVO> queryPage(Pager<DeviceVO> pager, DeviceFilter filter) {
        // 获取总条数
        pager.setDataCount(deviceMapper.getTotalCount(filter));
        if (pager.getPageIndex() > pager.getPageCount()) {
            throw new NoneException("没有分页数据");
        }

        List<DeviceVO> list = deviceMapper.queryPage(filter, pager.getFrom() - 1, pager.getPageSize());

        pager.setList(list) ;

        return pager;
    }

    @Override
    public List<DeviceVO> queryList(String tp) {

        List<DeviceVO> list = deviceMapper.queryAll(tp);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Device device) {
        DeviceVO deviceVO = this.deviceMapper.queryById(device.getNo());
        if(deviceVO==null) {
            //新增，根据设备类型自动生成设备编号

            //查询当前最大设备编号
            //类型
            String deviceTp = device.getTp();
            String curremtMaxNo=this.deviceMapper.queryMaxNoByTp(deviceTp);
            String newDeviceNo = "";
            if(curremtMaxNo==null||curremtMaxNo==""){
                //命名规则：类型+no
                newDeviceNo = deviceTp+"001";
            }else{
                String mxNo = curremtMaxNo.substring(curremtMaxNo.length()-3,curremtMaxNo.length());
                String nwNo = String.format("%0" + curremtMaxNo.length() + "d", Integer.parseInt(mxNo) + 1);
                newDeviceNo = deviceTp + nwNo;
            }
            //新编号=max+1
            device.setNo(newDeviceNo);

            this.deviceMapper.insert(device);
        }else {
            this.deviceMapper.update(device);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String no) {
        this.deviceMapper.deleteById(no);
    }


}
