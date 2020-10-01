package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.IncomeEntity;
import com.hua.chick.chicken.service.IncomeService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 各项收入
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = incomeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{incomeCategory}")
    public R info(@PathVariable("incomeCategory") String incomeCategory){
		IncomeEntity income = incomeService.getById(incomeCategory);

        return R.ok().put("income", income);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody IncomeEntity income){
		incomeService.save(income);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody IncomeEntity income){
		incomeService.updateById(income);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] incomeCategorys){
		incomeService.removeByIds(Arrays.asList(incomeCategorys));

        return R.ok();
    }

}
