package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.GoodsenterdetailDao;
import com.hua.chick.chicken.entity.GoodsenterdetailEntity;
import com.hua.chick.chicken.service.GoodsenterdetailService;


@Service("goodsenterdetailService")
public class GoodsenterdetailServiceImpl extends ServiceImpl<GoodsenterdetailDao, GoodsenterdetailEntity> implements GoodsenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsenterdetailEntity> page = this.page(
                new Query<GoodsenterdetailEntity>().getPage(params),
                new QueryWrapper<GoodsenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}