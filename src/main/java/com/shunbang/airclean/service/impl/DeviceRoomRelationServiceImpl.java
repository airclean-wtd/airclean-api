package com.shunbang.airclean.service.impl;

import com.shunbang.airclean.mapper.DeviceRoomRelationMapper;
import com.shunbang.airclean.mapper.RoomMapper;
import com.shunbang.airclean.model.filter.DeviceBindFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shunbang.airclean.service.IDeviceRoomRelationService;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "deviceRoomRelationService")
public class DeviceRoomRelationServiceImpl implements IDeviceRoomRelationService {

    @Autowired
    private DeviceRoomRelationMapper deviceRoomRelationMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(DeviceBindFilter filter) {
        this.deviceRoomRelationMapper.delete(filter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DeviceBindFilter filter) {
        this.deviceRoomRelationMapper.insert(filter);
    }
}
