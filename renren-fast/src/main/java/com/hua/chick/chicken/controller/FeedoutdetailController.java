package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.FeedoutdetailEntity;
import com.hua.chick.chicken.service.FeedoutdetailService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 饲料出库明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/feedoutdetail")
public class FeedoutdetailController {
    @Autowired
    private FeedoutdetailService feedoutdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedoutdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FeedoutdetailEntity feedoutdetail = feedoutdetailService.getById(id);

        return R.ok().put("feedoutdetail", feedoutdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeedoutdetailEntity feedoutdetail){
		feedoutdetailService.save(feedoutdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FeedoutdetailEntity feedoutdetail){
		feedoutdetailService.updateById(feedoutdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		feedoutdetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
