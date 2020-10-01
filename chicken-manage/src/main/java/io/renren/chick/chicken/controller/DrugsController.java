package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DrugsEntity;
import io.renren.chick.chicken.service.DrugsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 药品信息
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugs")
public class DrugsController {
    @Autowired
    private DrugsService drugsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DrugsEntity drugs = drugsService.getById(id);

        return R.ok().put("drugs", drugs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsEntity drugs){
		drugsService.save(drugs);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsEntity drugs){
		drugsService.updateById(drugs);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		drugsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
