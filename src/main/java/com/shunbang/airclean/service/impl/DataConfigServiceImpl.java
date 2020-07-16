package com.shunbang.airclean.service.impl;

import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.exception.NoneException;
import com.shunbang.airclean.mapper.DataConfigMapper;
import com.shunbang.airclean.mapper.RoomMapper;
import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.model.vo.RoomVO;
import com.shunbang.airclean.service.IDataConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "dataConfigService")
public class DataConfigServiceImpl implements IDataConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataConfigServiceImpl.class);

    @Autowired
    private DataConfigMapper dataConfigMapper;

    @Override
    public Pager<DataConfigVO> queryPage(Pager<DataConfigVO> pager, DataConfigFilter filter) {
        // 获取总条数
        pager.setDataCount(dataConfigMapper.getTotalCount(filter));
        if (pager.getPageIndex() > pager.getPageCount()) {
            throw new NoneException("没有分页数据");
        }

        List<DataConfigVO> list = dataConfigMapper.queryPage(filter, pager.getFrom() - 1, pager.getPageSize());

        pager.setList(list) ;

        return pager;
    }

    @Override
    public void save(DataConfig dataConfig) {
        DataConfigVO dataConfigVO = this.dataConfigMapper.queryById(dataConfig.getKey());
        if(dataConfigVO==null) {
            this.dataConfigMapper.insert(dataConfig);
        }else {
            this.dataConfigMapper.update(dataConfig);
        }
    }

    @Override
    public void delete(String key) {
        this.dataConfigMapper.deleteById(key);
    }
}
