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

import com.hua.chick.chicken.entity.MaterialstockinEntity;
import com.hua.chick.chicken.service.MaterialstockinService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 原料入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/materialstockin")
public class MaterialstockinController {
    @Autowired
    private MaterialstockinService materialstockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialstockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inDate}")
    public R info(@PathVariable("inDate") Date inDate){
		MaterialstockinEntity materialstockin = materialstockinService.getById(inDate);

        return R.ok().put("materialstockin", materialstockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialstockinEntity materialstockin){
		materialstockinService.save(materialstockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialstockinEntity materialstockin){
		materialstockinService.updateById(materialstockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] inDates){
		materialstockinService.removeByIds(Arrays.asList(inDates));

        return R.ok();
    }

}
