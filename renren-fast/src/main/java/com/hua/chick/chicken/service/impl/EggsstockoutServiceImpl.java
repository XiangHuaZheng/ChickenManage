package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.EggsstockoutDao;
import com.hua.chick.chicken.entity.EggsstockoutEntity;
import com.hua.chick.chicken.service.EggsstockoutService;


@Service("eggsstockoutService")
public class EggsstockoutServiceImpl extends ServiceImpl<EggsstockoutDao, EggsstockoutEntity> implements EggsstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsstockoutEntity> page = this.page(
                new Query<EggsstockoutEntity>().getPage(params),
                new QueryWrapper<EggsstockoutEntity>()
        );

        return new PageUtils(page);
    }

}