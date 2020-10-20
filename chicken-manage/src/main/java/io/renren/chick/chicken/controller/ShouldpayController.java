package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.ShouldpayEntity;
import io.renren.chick.chicken.service.ShouldpayService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 应付表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
@RestController
@RequestMapping("chicken/shouldpay")
public class ShouldpayController {
    @Autowired
    private ShouldpayService shouldpayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shouldpayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{name}")
    public R info(@PathVariable("name") String name){
		ShouldpayEntity shouldpay = shouldpayService.getById(name);

        return R.ok().put("shouldpay", shouldpay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShouldpayEntity shouldpay){
		shouldpayService.save(shouldpay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShouldpayEntity shouldpay){
		shouldpayService.updateById(shouldpay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] names){
		shouldpayService.removeByIds(Arrays.asList(names));

        return R.ok();
    }

}
