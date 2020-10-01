package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.FormulaEntity;
import io.renren.chick.chicken.service.FormulaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 配方信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/formula")
public class FormulaController {
    @Autowired
    private FormulaService formulaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = formulaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FormulaEntity formula = formulaService.getById(id);

        return R.ok().put("formula", formula);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FormulaEntity formula){
		formulaService.save(formula);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FormulaEntity formula){
		formulaService.updateById(formula);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		formulaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
