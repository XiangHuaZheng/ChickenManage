package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.FeedstockoutEntity;
import com.hua.chick.chicken.service.FeedstockoutService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 饲料出库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/feedstockout")
public class FeedstockoutController {
    @Autowired
    private FeedstockoutService feedstockoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedstockoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outDate}")
    public R info(@PathVariable("outDate") Date outDate){
		FeedstockoutEntity feedstockout = feedstockoutService.getById(outDate);

        return R.ok().put("feedstockout", feedstockout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeedstockoutEntity feedstockout){
		feedstockoutService.save(feedstockout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FeedstockoutEntity feedstockout){
		feedstockoutService.updateById(feedstockout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] outDates){
		feedstockoutService.removeByIds(Arrays.asList(outDates));

        return R.ok();
    }

}
