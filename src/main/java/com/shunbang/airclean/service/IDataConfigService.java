package com.shunbang.airclean.service;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;

import java.math.BigInteger;
import java.util.List;

/**
 * @author dxy
 * @date 20200716
 * @description 常量配置service接口
 */
public interface IDataConfigService {

    Pager<DataConfigVO> queryPage(Pager<DataConfigVO> pager, DataConfigFilter filter);

    void save(DataConfig dataConfig);

    void delete(BigInteger cfgNo);

    List<DataConfigVO> queryByKey(String key);
}
