package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.chick.chicken.entity.FeedenterdetailEntity;
import io.renren.chick.chicken.entity.FeedoutdetailEntity;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.FeedEnterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.chick.chicken.entity.FeedenterEntity;
import io.renren.chick.chicken.service.FeedenterService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 饲料入库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/feedenter")
public class FeedenterController {
    @Autowired
    private FeedenterService feedenterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		FeedenterEntity feedenter = feedenterService.getById(id);

        return R.ok().put("feedenter", feedenter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeedEnterVo feedenter){
		feedenterService.saveFeedEnterVo(feedenter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FeedEnterVo feedenter){
		feedenterService.updateFeedEnterVoById(feedenter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		feedenterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 待审核列表
     */
    @RequestMapping("/certainList")
    public R certainList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.certainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当天数据
     */
    @RequestMapping("/todayList")
    public R todayList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.todayList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当天待审核数据
     */
    @RequestMapping("/todayCertainList")
    public R todayCertainList(@RequestParam Map<String, Object> params){
        PassNumTo to = feedenterService.todayCertainList(params);

        return R.ok().put("page", to.getPageUtils()).put("size",to.getPassSize());
    }

    /**
     * 当月数据
     */
    @RequestMapping("/monthList")
    public R monthList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.monthList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当月待审核数据
     */
    @RequestMapping("/monthCertainList")
    public R monthCertainList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.monthCertainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当年数据
     */
    @RequestMapping("/yearList")
    public R yearList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.yearList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当年待审核数据
     */
    @RequestMapping("/yearCertainList")
    public R yearCertainList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.yearCertainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 待审核数据
     */
    @RequestMapping("/passList")
    public R passList(@RequestParam Map<String, Object> params){
        PageUtils page = feedenterService.passList(params);

        return R.ok().put("page", page);
    }

    /**
     * 审核
     */
    @RequestMapping("/pass")
    public R passById(@RequestBody Long[] ids){
        feedenterService.passById(ids[0]);
        return R.ok();
    }

    /**
     * 确认
     */
    @RequestMapping("/certain")
    public R certain(@RequestBody Long[] ids){
        feedenterService.certainById(ids[0]);
        return R.ok();
    }

    /**
     * 获取出库详情
     */
    @GetMapping("/detail")
    public R detail(@RequestParam Map<String, Object> params){
        FeedenterdetailEntity feedEnterdetailEntity = feedenterService.getDetailById(params);
        return R.ok().put("detail",feedEnterdetailEntity);
    }
}
