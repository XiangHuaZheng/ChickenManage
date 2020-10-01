package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.FeedenterdetailEntity;
import com.hua.chick.chicken.service.FeedenterdetailService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 饲料入库明细
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/feedenterdetail")
public class FeedenterdetailController {
    @Autowired
    private FeedenterdetailService feedenterdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FeedenterdetailEntity feedenterdetail = feedenterdetailService.getById(id);

        return R.ok().put("feedenterdetail", feedenterdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeedenterdetailEntity feedenterdetail){
		feedenterdetailService.save(feedenterdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FeedenterdetailEntity feedenterdetail){
		feedenterdetailService.updateById(feedenterdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		feedenterdetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
