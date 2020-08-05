package com.shunbang.airclean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shunbang.airclean.model.bean.Room;
import com.shunbang.airclean.model.filter.RoomFilter;
import com.shunbang.airclean.model.vo.RoomVO;

@Mapper
public interface RoomMapper {
	
	@Insert(" insert into room (no,tp,name,mt_tm,del) values(#{no},#{type},#{name},CURRENT_TIMESTAMP,'0')")
	int insert(Room room);

	@Update(" update room set tp = #{type},name = #{name},mt_tm = CURRENT_TIMESTAMP where no = #{no} ")
	int update(Room room);
	
	@Delete(" update room set del = '1'  where no = #{no}")
	int delete(String no);
	
	@Select(" select no,tp,sid,mt_tm from room where no = #{no}")
	@Results(value = {
			@Result(property = "type", column = "tp"),
			@Result(property = "maintainTime", column = "mt_tm")})
	Room get(String no);
	
	@Select(" select no,tp,sid,mt_tm  from room ")
	@Results(value = {
	        @Result(property = "type", column = "tp"),
	        @Result(property = "maintainTime", column = "mt_tm")})
	List<RoomVO> query();

	@Select(" <script> " +
			"select r.no,r.tp ,r.name,r.mt_tm,r.del,d.no as device_no, " +
			"d.tp as device_tp,d.mac as device_mac,d.st as device_st " +
			"from room r " +
			"left join device_room_rlt dr " +
			"on r.no= dr.ROOM_NO " +
			"and dr.end_tm is null "+
			"left join device d " +
			"on d.no=dr.DEVICE_NO  " +
			" and d.del='0' " +
			"where 1=1 and r.del='0'  " +
			"<if test='filter.no != null and !filter.no.isEmpty() ' > and r.no = #{filter.no} </if> "+
			"<if test='filter.type != null and !filter.type.isEmpty() ' > and r.tp = #{filter.type} </if> "+
			"<if test='filter.name != null and !filter.name.isEmpty() ' > and r.name = #{filter.name} </if> "+
			"<if test='filter.deviceNo != null and !filter.deviceNo.isEmpty() ' > and d.no = #{filter.deviceNo} </if> "+
			"<if test='filter.deviceMac != null and !filter.deviceMac.isEmpty() ' > and d.mac = #{filter.deviceMac} </if> "+
			" order by r.no "+
			"limit #{from},#{count} " +
			" </script> ")
	@Results(value = {
			@Result(property = "type", column = "tp"),
			@Result(property = "maintainTime", column = "mt_tm"),
			@Result(property = "deviceNo", column = "device_no"),
			@Result(property = "deviceTp", column = "device_tp"),
			@Result(property = "deviceMac", column = "device_mac"),
			@Result(property = "deviceSt", column = "device_st")
	})
	List<RoomVO> queryPage(RoomFilter filter, int from, int count);

	@Select(" select count(1)  from room  ") //TODO TL添加条件
	int getTotalCount(RoomFilter filter);

	@Select(" select no,tp ,name,mt_tm from room where del = '0' and no=#{no}   ")
	@Results(value = {
			@Result(property = "type", column = "tp"),
			@Result(property = "maintainTime", column = "mt_tm"),
			@Result(property = "del", column = "delete")})
	RoomVO getByNo(String no);


	@Select(" select no,name  from room  where del = '0' ")
	List<RoomVO> queryRoomList();
}
