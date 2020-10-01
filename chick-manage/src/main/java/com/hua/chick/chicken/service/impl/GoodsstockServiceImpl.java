package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.GoodsstockDao;
import com.hua.chick.chicken.entity.GoodsstockEntity;
import com.hua.chick.chicken.service.GoodsstockService;


@Service("goodsstockService")
public class GoodsstockServiceImpl extends ServiceImpl<GoodsstockDao, GoodsstockEntity> implements GoodsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsstockEntity> page = this.page(
                new Query<GoodsstockEntity>().getPage(params),
                new QueryWrapper<GoodsstockEntity>()
        );

        return new PageUtils(page);
    }

}