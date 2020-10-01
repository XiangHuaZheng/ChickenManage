package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.SellsummeryDao;
import com.hua.chick.chicken.entity.SellsummeryEntity;
import com.hua.chick.chicken.service.SellsummeryService;


@Service("sellsummeryService")
public class SellsummeryServiceImpl extends ServiceImpl<SellsummeryDao, SellsummeryEntity> implements SellsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellsummeryEntity> page = this.page(
                new Query<SellsummeryEntity>().getPage(params),
                new QueryWrapper<SellsummeryEntity>()
        );

        return new PageUtils(page);
    }

}