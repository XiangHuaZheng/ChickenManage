package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.DrugsstockinEntity;
import io.renren.chick.chicken.service.DrugsstockinService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 药品入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugsstockin")
public class DrugsstockinController {
    @Autowired
    private DrugsstockinService drugsstockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsstockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inDate}")
    public R info(@PathVariable("inDate") Date inDate){
		DrugsstockinEntity drugsstockin = drugsstockinService.getById(inDate);

        return R.ok().put("drugsstockin", drugsstockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsstockinEntity drugsstockin){
		drugsstockinService.save(drugsstockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsstockinEntity drugsstockin){
		drugsstockinService.updateById(drugsstockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] inDates){
		drugsstockinService.removeByIds(Arrays.asList(inDates));

        return R.ok();
    }

}
