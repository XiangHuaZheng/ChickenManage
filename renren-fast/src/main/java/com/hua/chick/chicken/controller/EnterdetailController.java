package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.EnterdetailEntity;
import com.hua.chick.chicken.service.EnterdetailService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 进鸡登记明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:12
 */
@RestController
@RequestMapping("chicken/enterdetail")
public class EnterdetailController {
    @Autowired
    private EnterdetailService enterdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EnterdetailEntity enterdetail = enterdetailService.getById(id);

        return R.ok().put("enterdetail", enterdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EnterdetailEntity enterdetail){
		enterdetailService.save(enterdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EnterdetailEntity enterdetail){
		enterdetailService.updateById(enterdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		enterdetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
