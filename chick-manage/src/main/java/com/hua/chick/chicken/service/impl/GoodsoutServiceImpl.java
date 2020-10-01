package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.GoodsoutDao;
import com.hua.chick.chicken.entity.GoodsoutEntity;
import com.hua.chick.chicken.service.GoodsoutService;


@Service("goodsoutService")
public class GoodsoutServiceImpl extends ServiceImpl<GoodsoutDao, GoodsoutEntity> implements GoodsoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsoutEntity> page = this.page(
                new Query<GoodsoutEntity>().getPage(params),
                new QueryWrapper<GoodsoutEntity>()
        );

        return new PageUtils(page);
    }

}