package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;
import com.hua.chick.chicken.entity.ChickenEntity;
import com.hua.chick.chicken.service.ChickenService;


/**
 * 鸡舍信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:12
 */
@RestController
@RequestMapping("chicken/chicken")
public class ChickenController {
    @Autowired
    private ChickenService chickenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chickenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChickenEntity chicken = chickenService.getById(id);

        return R.ok().put("chicken", chicken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChickenEntity chicken){
		chickenService.save(chicken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChickenEntity chicken){
		chickenService.updateById(chicken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chickenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
