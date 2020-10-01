package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.OhterincomeexpendsummeryEntity;
import com.hua.chick.chicken.service.OhterincomeexpendsummeryService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 其他收支汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/ohterincomeexpendsummery")
public class OhterincomeexpendsummeryController {
    @Autowired
    private OhterincomeexpendsummeryService ohterincomeexpendsummeryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ohterincomeexpendsummeryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{category}")
    public R info(@PathVariable("category") String category){
		OhterincomeexpendsummeryEntity ohterincomeexpendsummery = ohterincomeexpendsummeryService.getById(category);

        return R.ok().put("ohterincomeexpendsummery", ohterincomeexpendsummery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OhterincomeexpendsummeryEntity ohterincomeexpendsummery){
		ohterincomeexpendsummeryService.save(ohterincomeexpendsummery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OhterincomeexpendsummeryEntity ohterincomeexpendsummery){
		ohterincomeexpendsummeryService.updateById(ohterincomeexpendsummery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] categorys){
		ohterincomeexpendsummeryService.removeByIds(Arrays.asList(categorys));

        return R.ok();
    }

}
