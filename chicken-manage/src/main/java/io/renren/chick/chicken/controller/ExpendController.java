package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.ExpendEntity;
import io.renren.chick.chicken.service.ExpendService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 各项支出
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/expend")
public class ExpendController {
    @Autowired
    private ExpendService expendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{expendCategory}")
    public R info(@PathVariable("expendCategory") String expendCategory){
		ExpendEntity expend = expendService.getById(expendCategory);

        return R.ok().put("expend", expend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExpendEntity expend){
		expendService.save(expend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExpendEntity expend){
		expendService.updateById(expend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] expendCategorys){
		expendService.removeByIds(Arrays.asList(expendCategorys));

        return R.ok();
    }

}
