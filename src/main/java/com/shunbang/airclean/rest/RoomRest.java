package com.shunbang.airclean.rest;

import com.shunbang.airclean.common.CommonRest;
import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.common.SimplePageMessage;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.DeviceBindFilter;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.vo.RoomVO;
import com.shunbang.airclean.service.IDeviceRoomRelationService;
import com.shunbang.airclean.service.IRoomService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
 


@RestController
@RequestMapping("/room")
@Api("room接口")
public class RoomRest extends CommonRest<Object> {
	
	@Resource
	private IRoomService roomService;
	@Resource
	private IDeviceRoomRelationService deviceRoomRelationService;
	
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
		//关系解绑
		DeviceBindFilter filter = new DeviceBindFilter();
		filter.setNo(no);
		this.deviceRoomRelationService.delete(filter);
		this.roomService.delete(no);
		sm.setMessage("删除成功");
		return sm;
	}

	@GetMapping("/bind")
	public SimpleMessage<String> bind(DeviceBindFilter filter) {

		SimpleMessage<String> sm = new SimpleMessage<String>();
		//解绑,根据房间号解绑，设备置null
		DeviceBindFilter filter1 = new DeviceBindFilter();
		filter1.setNo(filter.getNo());
		this.deviceRoomRelationService.delete(filter1);
		//绑定
		this.deviceRoomRelationService.save(filter);

		sm.setMessage("设备绑定成功");
		return sm;
	}
}
