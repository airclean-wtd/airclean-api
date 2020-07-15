package com.shunbang.airclean.rest;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/save")
	public SimpleMessage<Room> save(@RequestBody Room room) {
		 
		SimpleMessage<Room> sm = new SimpleMessage<Room>();
		this.roomService.save(room);
		sm.setMessage("保存成功");
	    return sm;
	}
	
	@GetMapping("/queryPage")
	public SimpleMessage<?> query( RoomFilter filter) {
		 
		SimplePageMessage<RoomVO> sm = new SimplePageMessage<RoomVO>();

		try {
			//LOGGER.debug("你要查询user");
			Pager<RoomVO> pager = new Pager<RoomVO>();
			Integer pageIndex = filter.getPageIndex();
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

	@GetMapping("/delete")
	public SimpleMessage<String> delete(String no) {

		SimpleMessage<String> sm = new SimpleMessage<String>();
		this.roomService.delete(no);
		sm.setMessage("删除成功");
		return sm;
	}
}
