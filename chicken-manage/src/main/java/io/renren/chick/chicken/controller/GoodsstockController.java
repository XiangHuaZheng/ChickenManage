package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.GoodsstockEntity;
import io.renren.chick.chicken.service.GoodsstockService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 货品当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@RestController
@RequestMapping("chicken/goodsstock")
public class GoodsstockController {
    @Autowired
    private GoodsstockService goodsstockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsstockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GoodsstockEntity goodsstock = goodsstockService.getById(id);

        return R.ok().put("goodsstock", goodsstock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoodsstockEntity goodsstock){
		goodsstockService.save(goodsstock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsstockEntity goodsstock){
		goodsstockService.updateById(goodsstock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		goodsstockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
