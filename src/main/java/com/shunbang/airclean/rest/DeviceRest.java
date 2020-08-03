package com.shunbang.airclean.rest;

import com.shunbang.airclean.common.CommonRest;
import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.common.SimplePageMessage;
import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.bean.Device;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.filter.DeviceBindFilter;
import com.shunbang.airclean.model.filter.DeviceFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.DeviceVO;
import com.shunbang.airclean.service.IDeviceRoomRelationService;
import com.shunbang.airclean.service.IDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/device")
@Api(value = "device接口")
public class DeviceRest  extends CommonRest<Object> {


    @Resource
    private IDeviceService deviceService;
    @Resource
    private IDeviceRoomRelationService deviceRoomRelationService;

    @PostMapping("/save")
    @ApiOperation("save新增修改接口")
    public SimpleMessage<Device> save(@RequestBody DeviceFilter device) {

        SimpleMessage<Device> sm = new SimpleMessage<Device>();
        this.deviceService.save(device);
        sm.setMessage("保存成功");
        return sm;
    }

    @GetMapping("/queryPage")
    @ApiOperation("queryPage分页查询接口")
    public SimpleMessage<?> queryPage(DeviceFilter filter) {

        SimplePageMessage<DeviceVO> sm = new SimplePageMessage<DeviceVO>();

        try {
            Pager<DeviceVO> pager = new Pager<DeviceVO>();
            Integer pageIndex = filter.getPageIndex();
            if (pageIndex != null) {
                pager.setPageIndex(pageIndex);
            }
            // 保存入库
            sm.setPager(this.deviceService.queryPage(pager, filter));

        } catch (Exception e) {
            return error(e);
        }
        return sm;
    }

    @GetMapping("/delete")
    @ApiOperation("delete删除接口")
    public SimpleMessage<String> delete(String no) {

        SimpleMessage<String> sm = new SimpleMessage<String>();
        //关系解绑
        DeviceBindFilter filter = new DeviceBindFilter();
        filter.setDeviceNo(no);
        this.deviceRoomRelationService.delete(filter);
        this.deviceService.delete(no);
        sm.setMessage("删除成功");
        return sm;
    }

    @GetMapping("/queryList")
    @ApiOperation("queryList查询接口")
    public SimpleMessage<?> queryList(String tp) {

        SimplePageMessage<DeviceVO> sm = new SimplePageMessage<DeviceVO>();

        try {

            sm.setDataList(this.deviceService.queryList(tp));

        } catch (Exception e) {
            return error(e);
        }
        return sm;
    }

}
