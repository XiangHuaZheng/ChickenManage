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

import com.hua.chick.chicken.entity.EggsstockinEntity;
import com.hua.chick.chicken.service.EggsstockinService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 鸡蛋入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/eggsstockin")
public class EggsstockinController {
    @Autowired
    private EggsstockinService eggsstockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eggsstockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inDate}")
    public R info(@PathVariable("inDate") Date inDate){
		EggsstockinEntity eggsstockin = eggsstockinService.getById(inDate);

        return R.ok().put("eggsstockin", eggsstockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EggsstockinEntity eggsstockin){
		eggsstockinService.save(eggsstockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EggsstockinEntity eggsstockin){
		eggsstockinService.updateById(eggsstockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] inDates){
		eggsstockinService.removeByIds(Arrays.asList(inDates));

        return R.ok();
    }

}
