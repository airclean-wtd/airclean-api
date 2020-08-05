package com.shunbang.airclean.rest;

import com.shunbang.airclean.common.CommonRest;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.common.SimplePageMessage;
import com.shunbang.airclean.model.filter.StatFilter;
import com.shunbang.airclean.model.vo.StatVO;
import com.shunbang.airclean.service.IStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stat")
@Api("Stat接口")
public class StatRest extends CommonRest<Object> {

    @Resource
    private IStatService statService;

    @GetMapping("/queryStatList")
    @ApiOperation("queryStatList查询接口")
    public SimpleMessage<?> queryStatList(StatFilter filter) {

        SimplePageMessage<StatVO> sm = new SimplePageMessage<StatVO>();

        try {

            //保存list
            sm.setDataList(this.statService.queryStatList(filter));

        } catch (Exception e) {
            return error(e);
        }
        return sm;
    }

}
