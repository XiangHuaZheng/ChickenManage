package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsstockoutDao;
import com.hua.chick.chicken.entity.DrugsstockoutEntity;
import com.hua.chick.chicken.service.DrugsstockoutService;


@Service("drugsstockoutService")
public class DrugsstockoutServiceImpl extends ServiceImpl<DrugsstockoutDao, DrugsstockoutEntity> implements DrugsstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsstockoutEntity> page = this.page(
                new Query<DrugsstockoutEntity>().getPage(params),
                new QueryWrapper<DrugsstockoutEntity>()
        );

        return new PageUtils(page);
    }

}