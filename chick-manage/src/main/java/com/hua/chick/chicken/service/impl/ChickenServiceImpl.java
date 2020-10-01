package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.ChickenDao;
import com.hua.chick.chicken.entity.ChickenEntity;
import com.hua.chick.chicken.service.ChickenService;


@Service("chickenService")
public class ChickenServiceImpl extends ServiceImpl<ChickenDao, ChickenEntity> implements ChickenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChickenEntity> page = this.page(
                new Query<ChickenEntity>().getPage(params),
                new QueryWrapper<ChickenEntity>()
        );

        return new PageUtils(page);
    }

}