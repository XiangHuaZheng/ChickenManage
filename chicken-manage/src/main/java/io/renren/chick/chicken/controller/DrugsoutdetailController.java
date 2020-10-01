package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DrugsoutdetailEntity;
import io.renren.chick.chicken.service.DrugsoutdetailService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 药品出库明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugsoutdetail")
public class DrugsoutdetailController {
    @Autowired
    private DrugsoutdetailService drugsoutdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsoutdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DrugsoutdetailEntity drugsoutdetail = drugsoutdetailService.getById(id);

        return R.ok().put("drugsoutdetail", drugsoutdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsoutdetailEntity drugsoutdetail){
		drugsoutdetailService.save(drugsoutdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsoutdetailEntity drugsoutdetail){
		drugsoutdetailService.updateById(drugsoutdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		drugsoutdetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
