package com.shunbang.airclean.mapper;

import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.bean.Device;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.filter.DeviceFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.DeviceVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param no 主键
     * @return 实例对象
     */
    @Select(" select no,tp,sid,ip,port,mac,st,mt_tm,del " +
            "        from airclean.device d " +
            "        where d.no = #{no}   ")
    DeviceVO queryById(String no);

    /**
     * 通过tp查询最大编号
     *
     * @param tp 类型
     * @return 当前最大编号
     */
    @Select(" select max(no) " +
            "        from airclean.device d " +
            "        where d.tp = #{tp}   ")
    String queryMaxNoByTp(String tp);

    /**
     * 查询指定行数据
     *
     * @param from  查询起始位置
     * @param count  查询条数
     * @return 对象列表
     */
    @Select("<script> "+
            " select  CAST((@rownum :=@rownum + 1) as SIGNED) as rownum, " +
            "no,tp,sid,ip,port,mac,st,mt_tm,del,name as roomName  " +
            "from ( " +
            "select  " +
            "d.no,d.tp,d.sid,d.ip,d.port,d.mac,d.st,d.mt_tm,d.del,r.name " +
            "from device d " +
            "left join device_room_rlt dr " +
            "on dr.device_no=d.no " +
            "left join room r " +
            "on dr.room_no=r.no " +
            "where 1=1 " +
            "<if test='filter.no != null and !filter.no.isEmpty() ' > and d.no = #{filter.no} </if> "+
            "<if test='filter.tp != null and !filter.tp.isEmpty() ' > and d.tp = #{filter.tp} </if> "+
            "<if test='filter.mac != null and !filter.mac.isEmpty() ' > and d.mac = #{filter.mac} </if> "+
            "<if test='filter.sid != null and !filter.sid.isEmpty() ' > and d.sid = #{filter.sid} </if> "+
            "<if test='filter.st != null and !filter.st.isEmpty() ' > and d.st = #{filter.st} </if> "+
            "<if test='filter.ip != null and !filter.ip.isEmpty() ' > and d.ip = #{filter.ip} </if> "+
            "limit 0,10  " +
            ") data, " +
            "(SELECT @rownum := 0) rw  "+
            "</script> ") //TODO 添加条件
    @Results(value = {
            @Result(property = "index", column = "rownum")})
    List<DeviceVO> queryPage(DeviceFilter filter, int from, int count);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select " +
            "   no,no as label,tp,sid,ip,port,mac,st,mt_tm,del " +
            "   from airclean.device where tp=#{tp} ")
    List<DeviceVO> queryAll(String tp);

    /**
     * 新增数据
     *
     * @param device 实例对象
     * @return 影响行数
     */
    @Insert(" insert into airclean.device (no,tp,sid,ip,port,mac,st,mt_tm,del) " +
            " values (#{no}, #{tp}, #{sid}, #{ip}, #{port}, #{mac}, #{st}, #{mtTm}, #{del}) ")
    int insert(Device device);

    /**
     * 修改数据
     *
     * @param device 实例对象
     * @return 影响行数
     */
    @Update(" update airclean.device set no=#{no},tp=#{tp},sid=#{sid},ip=#{ip},port=#{port},mac=#{mac},st=#{st}" +
            " where no = #{no} ")
    int update(Device device);

    /**
     * 通过主键删除数据
     *
     * @param no 主键
     * @return 影响行数
     */
    @Delete(" delete " +
            "        from airclean.device d" +
            "        where d.no = #{no} ")
    int deleteById(String no);

    /**
     * 查询条数
     * @param filter
     * @return
     */
    @Select(" select count(1)  from airclean.device  ") //TODO 添加条件
    int getTotalCount(DeviceFilter filter);
}
