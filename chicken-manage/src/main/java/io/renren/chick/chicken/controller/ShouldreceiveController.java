package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.ShouldreceiveEntity;
import io.renren.chick.chicken.service.ShouldreceiveService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 应收表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-16 15:05:11
 */
@RestController
@RequestMapping("chicken/shouldreceive")
public class ShouldreceiveController {
    @Autowired
    private ShouldreceiveService shouldreceiveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shouldreceiveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{name}")
    public R info(@PathVariable("name") String name){
		ShouldreceiveEntity shouldreceive = shouldreceiveService.getById(name);

        return R.ok().put("shouldreceive", shouldreceive);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShouldreceiveEntity shouldreceive){
		shouldreceiveService.save(shouldreceive);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShouldreceiveEntity shouldreceive){
		shouldreceiveService.updateById(shouldreceive);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] names){
		shouldreceiveService.removeByIds(Arrays.asList(names));

        return R.ok();
    }

}
