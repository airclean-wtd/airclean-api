package com.shunbang.airclean.rest;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shunbang.airclean.common.CommonRest;
import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.common.SimplePageMessage;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.vo.RoomVO;
import com.shunbang.airclean.service.IRoomService;
 


@RestController
@RequestMapping("/room")
public class RoomRest extends CommonRest<Object> {
	
	@Resource
	private IRoomService roomService;
	
	@GetMapping("/save")
	public SimpleMessage<Room> save(Room room) {
		 
		SimpleMessage<Room> sm = new SimpleMessage<Room>();
		this.roomService.save(room);
		sm.setMessage("保存成功");
	    return sm;
	}
	
	//@GetMapping(value="/queryPage", produces = "application/json; charset=utf-8")
	@GetMapping("/queryPage")
	public SimpleMessage<?> query(Integer pageIndex,RoomFilter filter) {
		 
		SimplePageMessage<RoomVO> sm = new SimplePageMessage<RoomVO>();

		try {
			//LOGGER.debug("你要查询user");
			Pager<RoomVO> pager = new Pager<RoomVO>();
			if (pageIndex != null) {
				pager.setPageIndex(pageIndex);
			}
			// 保存入库
			sm.setPager(this.roomService.queryPage(pager, filter));

		} catch (Exception e) {
			return error(e);
		}
		return sm;
	}
}
