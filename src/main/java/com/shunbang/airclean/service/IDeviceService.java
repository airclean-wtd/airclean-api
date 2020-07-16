package com.shunbang.airclean.service;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.model.bean.Device;
import com.shunbang.airclean.model.filter.DeviceFilter;
import com.shunbang.airclean.model.vo.DeviceVO;

/**
 * @author dxy
 * @date 20200716
 * @description 设备service接口
 */
public interface IDeviceService {

    Pager<DeviceVO> queryPage(Pager<DeviceVO> pager, DeviceFilter filter);

    void save(Device device);

    void delete(String no);

}
