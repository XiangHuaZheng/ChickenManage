package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DierecordEntity;
import io.renren.chick.chicken.service.DierecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 死亡记录
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/dierecord")
public class DierecordController {
    @Autowired
    private DierecordService dierecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dierecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DierecordEntity dierecord = dierecordService.getById(id);

        return R.ok().put("dierecord", dierecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DierecordEntity dierecord){
		dierecordService.save(dierecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DierecordEntity dierecord){
		dierecordService.updateById(dierecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		dierecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
