package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.MaterialstockEntity;
import com.hua.chick.chicken.service.MaterialstockService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 原料当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/materialstock")
public class MaterialstockController {
    @Autowired
    private MaterialstockService materialstockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialstockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MaterialstockEntity materialstock = materialstockService.getById(id);

        return R.ok().put("materialstock", materialstock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialstockEntity materialstock){
		materialstockService.save(materialstock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialstockEntity materialstock){
		materialstockService.updateById(materialstock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		materialstockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
