package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.RaiserecordEntity;
import com.hua.chick.chicken.service.RaiserecordService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 饲养记录
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/raiserecord")
public class RaiserecordController {
    @Autowired
    private RaiserecordService raiserecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = raiserecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		RaiserecordEntity raiserecord = raiserecordService.getById(id);

        return R.ok().put("raiserecord", raiserecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RaiserecordEntity raiserecord){
		raiserecordService.save(raiserecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RaiserecordEntity raiserecord){
		raiserecordService.updateById(raiserecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		raiserecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
