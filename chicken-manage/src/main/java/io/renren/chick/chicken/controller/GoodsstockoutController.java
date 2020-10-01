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

import io.renren.chick.chicken.entity.GoodsstockoutEntity;
import io.renren.chick.chicken.service.GoodsstockoutService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 货品出库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/goodsstockout")
public class GoodsstockoutController {
    @Autowired
    private GoodsstockoutService goodsstockoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsstockoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outDate}")
    public R info(@PathVariable("outDate") Date outDate){
		GoodsstockoutEntity goodsstockout = goodsstockoutService.getById(outDate);

        return R.ok().put("goodsstockout", goodsstockout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsstockoutEntity goodsstockout){
		goodsstockoutService.save(goodsstockout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsstockoutEntity goodsstockout){
		goodsstockoutService.updateById(goodsstockout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] outDates){
		goodsstockoutService.removeByIds(Arrays.asList(outDates));

        return R.ok();
    }

}
