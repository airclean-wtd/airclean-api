package com.shunbang.airclean.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.exception.NoneException;
import com.shunbang.airclean.mapper.RoomMapper;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.vo.RoomVO;
import com.shunbang.airclean.service.IRoomService;

@Service(value = "roomService")
public class RoomServiceImpl implements IRoomService{
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
	private RoomMapper roomMapper;
	

	@Override
	public void add(Room room) {
		 System.out.println(" 我要保存啦");
		 LOGGER.info("我真的要保存啦！！！");
		 roomMapper.insert(room);
		
	}


	/*
	 * @Override public List<Room> query() { 
	 *     return roomMapper.query();
	 * }
	 */

	@Override
	public Pager<RoomVO> queryPage(Pager<RoomVO> pager, RoomFilter filter) {
		// 获取总条数
		pager.setDataCount(roomMapper.getTotalCount(filter));
		if (pager.getPageIndex() > pager.getPageCount()) {
			throw new NoneException("没有分页数据");
		}

		List<RoomVO> list = roomMapper.queryPage(filter, pager.getFrom() - 1, pager.getPageSize());

		pager.setList(list) ;

		return pager;
	}


	@Override
	public void save(Room room) {
		RoomVO roomVO = this.roomMapper.getByNo(room.getNo());
		if(roomVO==null) {
			this.roomMapper.insert(room);
		}else {
			this.roomMapper.update(room);
		}
		
	}

}
