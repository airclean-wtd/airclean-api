package com.shunbang.airclean.service;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.filter.StatFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.StatVO;

import java.math.BigInteger;
import java.util.List;

/**
 * @author dxy
 * @date 20200804
 * @description 统计查询service接口
 */
public interface IStatService {


    List<StatVO> queryStatList(StatFilter filter);
}
