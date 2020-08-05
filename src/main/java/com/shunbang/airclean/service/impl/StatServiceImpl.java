package com.shunbang.airclean.service.impl;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.exception.NoneException;
import com.shunbang.airclean.mapper.DeviceSamplingDataHistoryMapper;
import com.shunbang.airclean.mapper.RoomMapper;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.filter.StatFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.RoomVO;
import com.shunbang.airclean.model.vo.StatVO;
import com.shunbang.airclean.service.IRoomService;
import com.shunbang.airclean.service.IStatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "statService")
public class StatServiceImpl implements IStatService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StatServiceImpl.class);

	@Autowired
	private DeviceSamplingDataHistoryMapper deviceSamplingDataHistoryMapper;

	@Override
	public List<StatVO> queryStatList(StatFilter filter) {
		return deviceSamplingDataHistoryMapper.queryStatList(filter);
	}
}
