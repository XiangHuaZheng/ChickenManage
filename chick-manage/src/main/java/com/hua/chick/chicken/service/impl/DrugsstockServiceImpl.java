package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsstockDao;
import com.hua.chick.chicken.entity.DrugsstockEntity;
import com.hua.chick.chicken.service.DrugsstockService;


@Service("drugsstockService")
public class DrugsstockServiceImpl extends ServiceImpl<DrugsstockDao, DrugsstockEntity> implements DrugsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsstockEntity> page = this.page(
                new Query<DrugsstockEntity>().getPage(params),
                new QueryWrapper<DrugsstockEntity>()
        );

        return new PageUtils(page);
    }

}