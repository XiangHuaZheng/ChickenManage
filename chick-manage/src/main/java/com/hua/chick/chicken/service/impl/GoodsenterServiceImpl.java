package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.GoodsenterDao;
import com.hua.chick.chicken.entity.GoodsenterEntity;
import com.hua.chick.chicken.service.GoodsenterService;


@Service("goodsenterService")
public class GoodsenterServiceImpl extends ServiceImpl<GoodsenterDao, GoodsenterEntity> implements GoodsenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsenterEntity> page = this.page(
                new Query<GoodsenterEntity>().getPage(params),
                new QueryWrapper<GoodsenterEntity>()
        );

        return new PageUtils(page);
    }

}