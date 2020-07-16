package com.shunbang.airclean.rest;

import com.shunbang.airclean.common.CommonRest;
import com.shunbang.airclean.common.Pager;
import com.shunbang.airclean.common.SimpleMessage;
import com.shunbang.airclean.common.SimplePageMessage;
import com.shunbang.airclean.model.bean.DataConfig;
import com.shunbang.airclean.model.filter.DataConfigFilter;
import com.shunbang.airclean.model.vo.DataConfigVO;
import com.shunbang.airclean.service.IDataConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dataConfig")
@Api("DataConfig接口")
public class DataConfigRest extends CommonRest<Object> {

    @Resource
    private IDataConfigService dataConfigService;

    @PostMapping("/save")
    @ApiOperation("save新增修改接口")
    public SimpleMessage<DataConfig> save(@RequestBody DataConfig dataConfig) {

        SimpleMessage<DataConfig> sm = new SimpleMessage<DataConfig>();
        this.dataConfigService.save(dataConfig);
        sm.setMessage("保存成功");
        return sm;
    }

    @GetMapping("/queryPage")
    @ApiOperation("queryPage分页查询接口")
    public SimpleMessage<?> queryPage(DataConfigFilter filter) {

        SimplePageMessage<DataConfigVO> sm = new SimplePageMessage<DataConfigVO>();

        try {
            Pager<DataConfigVO> pager = new Pager<DataConfigVO>();
            Integer pageIndex = filter.getPageIndex();
            if (pageIndex != null) {
                pager.setPageIndex(pageIndex);
            }
            // 保存入库
            sm.setPager(this.dataConfigService.queryPage(pager, filter));

        } catch (Exception e) {
            return error(e);
        }
        return sm;
    }

    @GetMapping("/delete")
    @ApiOperation("delete删除接口")
    public SimpleMessage<String> delete(String key) {

        SimpleMessage<String> sm = new SimpleMessage<String>();
        this.dataConfigService.delete(key);
        sm.setMessage("删除成功");
        return sm;
    }
}
