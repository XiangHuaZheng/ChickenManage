package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.HatchEntity;
import io.renren.chick.chicken.service.HatchService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 孵化报表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/hatch")
public class HatchController {
    @Autowired
    private HatchService hatchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hatchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		HatchEntity hatch = hatchService.getById(id);

        return R.ok().put("hatch", hatch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HatchEntity hatch){
		hatchService.save(hatch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HatchEntity hatch){
		hatchService.updateById(hatch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		hatchService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
