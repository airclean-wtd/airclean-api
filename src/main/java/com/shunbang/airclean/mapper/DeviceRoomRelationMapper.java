package com.shunbang.airclean.mapper;

import com.shunbang.airclean.model.bean.DeviceRoomRelation;
import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.DeviceBindFilter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceRoomRelationMapper {

    @Delete(" delete from device_room_rlt  where room_no=#{no} and device_no=#{deviceNo}")
    int delete(DeviceBindFilter filter);

    @Insert(" insert into device_room_rlt (room_no,device_no,strt_tm,end_tm,mt_tm) values(#{no},#{deviceNo},CURRENT_TIMESTAMP,null,CURRENT_TIMESTAMP)")
    int insert(DeviceBindFilter filter);
}
