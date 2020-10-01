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

import com.hua.chick.chicken.entity.GoodsstockinEntity;
import com.hua.chick.chicken.service.GoodsstockinService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 货品入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/goodsstockin")
public class GoodsstockinController {
    @Autowired
    private GoodsstockinService goodsstockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsstockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inDate}")
    public R info(@PathVariable("inDate") Date inDate){
		GoodsstockinEntity goodsstockin = goodsstockinService.getById(inDate);

        return R.ok().put("goodsstockin", goodsstockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsstockinEntity goodsstockin){
		goodsstockinService.save(goodsstockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsstockinEntity goodsstockin){
		goodsstockinService.updateById(goodsstockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] inDates){
		goodsstockinService.removeByIds(Arrays.asList(inDates));

        return R.ok();
    }

}
