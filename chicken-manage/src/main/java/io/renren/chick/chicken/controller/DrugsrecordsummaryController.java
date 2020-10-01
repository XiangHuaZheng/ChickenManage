package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DrugsrecordsummaryEntity;
import io.renren.chick.chicken.service.DrugsrecordsummaryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 喂药记录汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugsrecordsummary")
public class DrugsrecordsummaryController {
    @Autowired
    private DrugsrecordsummaryService drugsrecordsummaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsrecordsummaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DrugsrecordsummaryEntity drugsrecordsummary = drugsrecordsummaryService.getById(id);

        return R.ok().put("drugsrecordsummary", drugsrecordsummary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsrecordsummaryEntity drugsrecordsummary){
		drugsrecordsummaryService.save(drugsrecordsummary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsrecordsummaryEntity drugsrecordsummary){
		drugsrecordsummaryService.updateById(drugsrecordsummary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		drugsrecordsummaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
