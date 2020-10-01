package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.CustomerdebtsummaryEntity;
import io.renren.chick.chicken.service.CustomerdebtsummaryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 客户欠款汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/customerdebtsummary")
public class CustomerdebtsummaryController {
    @Autowired
    private CustomerdebtsummaryService customerdebtsummaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerdebtsummaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{supplierNo}")
    public R info(@PathVariable("supplierNo") Long supplierNo){
		CustomerdebtsummaryEntity customerdebtsummary = customerdebtsummaryService.getById(supplierNo);

        return R.ok().put("customerdebtsummary", customerdebtsummary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerdebtsummaryEntity customerdebtsummary){
		customerdebtsummaryService.save(customerdebtsummary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerdebtsummaryEntity customerdebtsummary){
		customerdebtsummaryService.updateById(customerdebtsummary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] supplierNos){
		customerdebtsummaryService.removeByIds(Arrays.asList(supplierNos));

        return R.ok();
    }

}
