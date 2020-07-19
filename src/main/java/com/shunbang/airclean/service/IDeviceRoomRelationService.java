package com.shunbang.airclean.service;

import com.shunbang.airclean.model.filter.DeviceBindFilter;

public interface IDeviceRoomRelationService {

    void delete(DeviceBindFilter filter);

    void save(DeviceBindFilter filter);
}
