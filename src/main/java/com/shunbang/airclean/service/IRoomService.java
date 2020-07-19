package com.shunbang.airclean.service;


import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.DeviceBindFilter;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.vo.RoomVO;

public interface IRoomService {
	void add(Room room);

	Pager<RoomVO> queryPage(Pager<RoomVO> pager,RoomFilter filter);

	void save(Room room);

	void delete(String no);
}
