package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.OtherincomeEntity;
import io.renren.chick.chicken.service.OtherincomeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 其他收入
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/otherincome")
public class OtherincomeController {
    @Autowired
    private OtherincomeService otherincomeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = otherincomeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OtherincomeEntity otherincome = otherincomeService.getById(id);

        return R.ok().put("otherincome", otherincome);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OtherincomeEntity otherincome){
		otherincomeService.save(otherincome);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OtherincomeEntity otherincome){
		otherincomeService.updateById(otherincome);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		otherincomeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
