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

import io.renren.chick.chicken.entity.FeedstockinEntity;
import io.renren.chick.chicken.service.FeedstockinService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 饲料入库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/feedstockin")
public class FeedstockinController {
    @Autowired
    private FeedstockinService feedstockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedstockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inDate}")
    public R info(@PathVariable("inDate") Date inDate){
		FeedstockinEntity feedstockin = feedstockinService.getById(inDate);

        return R.ok().put("feedstockin", feedstockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeedstockinEntity feedstockin){
		feedstockinService.save(feedstockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FeedstockinEntity feedstockin){
		feedstockinService.updateById(feedstockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] inDates){
		feedstockinService.removeByIds(Arrays.asList(inDates));

        return R.ok();
    }

}
