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

import io.renren.chick.chicken.entity.DrugsfailurealertEntity;
import io.renren.chick.chicken.service.DrugsfailurealertService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 药品失效提醒
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/drugsfailurealert")
public class DrugsfailurealertController {
    @Autowired
    private DrugsfailurealertService drugsfailurealertService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = drugsfailurealertService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{failureDate}")
    public R info(@PathVariable("failureDate") Date failureDate){
		DrugsfailurealertEntity drugsfailurealert = drugsfailurealertService.getById(failureDate);

        return R.ok().put("drugsfailurealert", drugsfailurealert);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DrugsfailurealertEntity drugsfailurealert){
		drugsfailurealertService.save(drugsfailurealert);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DrugsfailurealertEntity drugsfailurealert){
		drugsfailurealertService.updateById(drugsfailurealert);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] failureDates){
		drugsfailurealertService.removeByIds(Arrays.asList(failureDates));

        return R.ok();
    }

}
