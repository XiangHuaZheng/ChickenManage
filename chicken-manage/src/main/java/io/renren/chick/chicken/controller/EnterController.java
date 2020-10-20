package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.chick.chicken.entity.EnterdetailEntity;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.EnterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.chick.chicken.entity.EnterEntity;
import io.renren.chick.chicken.service.EnterService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 进鸡登记
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/enter")
public class EnterController {
    @Autowired
    private EnterService enterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 待审核列表
     */
    @RequestMapping("/certainList")
    public R certainList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.certainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当天数据
     */
    @RequestMapping("/todayList")
    public R todayList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.todayList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当天待审核数据
     */
    @RequestMapping("/todayCertainList")
    public R todayCertainList(@RequestParam Map<String, Object> params){
        PassNumTo to = enterService.todayCertainList(params);

        return R.ok().put("page", to.getPageUtils()).put("size",to.getPassSize());
    }

    /**
     * 当月数据
     */
    @RequestMapping("/monthList")
    public R monthList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.monthList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当月待审核数据
     */
    @RequestMapping("/monthCertainList")
    public R monthCertainList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.monthCertainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当年数据
     */
    @RequestMapping("/yearList")
    public R yearList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.yearList(params);

        return R.ok().put("page", page);
    }

    /**
     * 当年待审核数据
     */
    @RequestMapping("/yearCertainList")
    public R yearCertainList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.yearCertainList(params);

        return R.ok().put("page", page);
    }

    /**
     * 待审核数据
     */
    @RequestMapping("/passList")
    public R passList(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.passList(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EnterEntity enter = enterService.getById(id);

        return R.ok().put("enter", enter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EnterVo enter){
		enterService.saveEnterVo(enter);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EnterVo enter){
		enterService.updateEnterVoById(enter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		enterService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/pass")
    public R passById(@RequestBody Long[] ids){
        enterService.passById(ids[0]);
        return R.ok();
    }

    /**
     * 确认
     */
    @RequestMapping("/certain")
    public R certain(@RequestBody Long[] ids){
        enterService.certainById(ids[0]);
        return R.ok();
    }

    /**
     * 获取进鸡详情
     */
    @GetMapping("/detail")
    public R detail(@RequestParam Map<String, Object> params){
        EnterdetailEntity enterdetailEntity = enterService.getDetailById(params);
        return R.ok().put("detail",enterdetailEntity);
    }
}
