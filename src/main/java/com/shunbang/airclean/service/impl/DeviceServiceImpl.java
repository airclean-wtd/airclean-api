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
    public void save(Device device) {
        DeviceVO deviceVO = this.deviceMapper.queryById(device.getNo());
        if(deviceVO==null) {
            this.deviceMapper.insert(device);
        }else {
            this.deviceMapper.update(device);
        }
    }

    @Override
    public void delete(String no) {

    }
}
