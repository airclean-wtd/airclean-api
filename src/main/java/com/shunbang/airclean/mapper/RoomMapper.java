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
	
	@Insert(" insert into room (no,tp,name,mt_tm) values(#{no},#{type},#{name},#{maintainTime})")
	int insert(Room room);

	@Update(" update room set tp = #{type},name = #{name},mt_tm = #{maintainTime} where no = #{no} ")
	int update(Room room);
	
	@Delete(" delete from room  where no = #{no}")
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

	@Select(" select count(1)  from room  ") //TODO TL添加条件
	int getTotalCount(RoomFilter filter);
	
	@Select(" select no,tp ,name,mt_tm,del from room limit #{from},#{count}   ") //TODO TL添加条件
	@Results(value = {
			@Result(property = "type", column = "tp"),
			@Result(property = "maintainTime", column = "mt_tm"),
			@Result(property = "del", column = "delete")})
	List<RoomVO> queryPage(RoomFilter filter, int from, int count);

	@Select(" select no,tp ,name,mt_tm from room where no=#{no}   ")
	@Results(value = {
			@Result(property = "type", column = "tp"),
			@Result(property = "maintainTime", column = "mt_tm"),
			@Result(property = "del", column = "delete")})
	RoomVO getByNo(String no);
	
	
}
