package com.shunbang.airclean.mapper;

import com.shunbang.airclean.model.filter.StatFilter;
import com.shunbang.airclean.model.vo.StatVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceSamplingDataHistoryMapper {

    @Select("<script> "+
            "select h.smpl_tm,h.val " +
            "from  device_smpl_data_history h  " +
            "left join device_room_rlt rl  " +
            "on h.DEVICE_NO = rl.DEVICE_NO " +
            "and rl.END_TM is null " +
            "left join room r " +
            "on r.no = rl.room_no " +
            "and r.del='0' " +
            "where 1=1  " +
            "and h.io='I' " +
            "<if test='roomNo != null and !roomNo.isEmpty() ' > and r.no=#{roomNo} </if> "+
            "<if test='dataTp != null and !dataTp.isEmpty() ' > and h.data_tp=#{dataTp} </if> "+
            "<if test='deviceTp != null and !deviceTp.isEmpty() ' > and h.DEVICE_TP=#{deviceTp} </if> "+
            "order by h.smpl_tm " +
            "</script> ")
    List<StatVO> queryStatList(StatFilter filter);
}
