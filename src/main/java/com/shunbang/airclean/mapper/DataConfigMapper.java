package com.shunbang.airclean.mapper;

import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DataConfigMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param key 主键
     * @return 实例对象
     */
    @Select(" select d.CFG_NO, d.KY, d.VAL, d.NAME, d.ODR, d.OPT_TM " +
            "        from airclean.data_config d " +
            "        where d.KY = #{key}   ")
    DataConfigVO queryById(String key);

    /**
     * 查询指定行数据
     *
     * @param from  查询起始位置
     * @param count  查询条数
     * @return 对象列表
     */
    @Select("<script> "+
            "  select CAST((@rownum :=@rownum + 1) as SIGNED) as rownum,d.CFG_NO, d.KY, d.VAL, d.NAME, d.ODR, d.OPT_TM " +
            "from airclean.data_config d, (SELECT @rownum := 0) r " +
            "where 1=1   " +
            "<if test='filter.key != null and !filter.key.isEmpty() ' > and KY = #{filter.key} </if> "+
            "<if test='filter.value != null and !filter.value.isEmpty() ' > and VAL = #{filter.value} </if> "+
            "<if test='filter.name != null and !filter.name.isEmpty() ' > and NAME = #{filter.name} </if> "+
            "limit #{from},#{count}  " +
            "</script> ") //TODO 添加条件
    @Results(value = {
            @Result(property = "key", column = "KY"),
            @Result(property = "value", column = "VAL"),
            @Result(property = "index", column = "rownum"),
            @Result(property = "order", column = "odr")})
    List<DataConfigVO> queryPage(DataConfigFilter filter, int from, int count);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dataConfig 实例对象
     * @return 对象列表
     */
    @Select("select " +
            "   d.CFG_NO, d.KY, d.VAL, d.NAME, d.ODR, d.OPT_TM " +
            "   from airclean.data_config ")
    List<DataConfigVO> queryAll(DataConfig dataConfig);

    /**
     * 新增数据
     *
     * @param dataConfig 实例对象
     * @return 影响行数
     */
    @Insert(" insert into airclean.data_config (KY, VAL, NAME, ODR, OPT_TM) " +
            " values (#{key}, #{value}, #{name}, #{order}, #{optTm}) ")
    int insert(DataConfig dataConfig);

    /**
     * 修改数据
     *
     * @param dataConfig 实例对象
     * @return 影响行数
     */
    @Update(" update airclean.data_config set VAL = #{value} where KY = #{key} ")
    int update(DataConfig dataConfig);

    /**
     * 通过主键删除数据
     *
     * @param key 主键
     * @return 影响行数
     */
    @Delete(" delete " +
            "        from airclean.data_config d" +
            "        where d.KY = #{key} ")
    int deleteById(String key);

    /**
     * 查询条数
     * @param filter
     * @return
     */
    @Select(" select count(1)  from airclean.data_config  ") //TODO 添加条件
    int getTotalCount(DataConfigFilter filter);
}
