package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.FormuladetailEntity;
import io.renren.chick.chicken.service.FormuladetailService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 配方信息明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/formuladetail")
public class FormuladetailController {
    @Autowired
    private FormuladetailService formuladetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = formuladetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FormuladetailEntity formuladetail = formuladetailService.getById(id);

        return R.ok().put("formuladetail", formuladetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FormuladetailEntity formuladetail){
		formuladetailService.save(formuladetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FormuladetailEntity formuladetail){
		formuladetailService.updateById(formuladetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		formuladetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
