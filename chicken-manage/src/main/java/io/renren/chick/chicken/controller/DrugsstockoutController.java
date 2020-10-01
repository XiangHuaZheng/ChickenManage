package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DrugsstockoutEntity;
import io.renren.chick.chicken.service.DrugsstockoutService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 药品出库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugsstockout")
public class DrugsstockoutController {
    @Autowired
    private DrugsstockoutService drugsstockoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsstockoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outDate}")
    public R info(@PathVariable("outDate") Date outDate){
		DrugsstockoutEntity drugsstockout = drugsstockoutService.getById(outDate);

        return R.ok().put("drugsstockout", drugsstockout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsstockoutEntity drugsstockout){
		drugsstockoutService.save(drugsstockout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsstockoutEntity drugsstockout){
		drugsstockoutService.updateById(drugsstockout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] outDates){
		drugsstockoutService.removeByIds(Arrays.asList(outDates));

        return R.ok();
    }

}
