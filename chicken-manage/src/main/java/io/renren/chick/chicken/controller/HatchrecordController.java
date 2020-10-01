package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.HatchrecordEntity;
import io.renren.chick.chicken.service.HatchrecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 孵化记录表
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/hatchrecord")
public class HatchrecordController {
    @Autowired
    private HatchrecordService hatchrecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hatchrecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		HatchrecordEntity hatchrecord = hatchrecordService.getById(id);

        return R.ok().put("hatchrecord", hatchrecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HatchrecordEntity hatchrecord){
		hatchrecordService.save(hatchrecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HatchrecordEntity hatchrecord){
		hatchrecordService.updateById(hatchrecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		hatchrecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
