package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsstockinDao;
import com.hua.chick.chicken.entity.DrugsstockinEntity;
import com.hua.chick.chicken.service.DrugsstockinService;


@Service("drugsstockinService")
public class DrugsstockinServiceImpl extends ServiceImpl<DrugsstockinDao, DrugsstockinEntity> implements DrugsstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsstockinEntity> page = this.page(
                new Query<DrugsstockinEntity>().getPage(params),
                new QueryWrapper<DrugsstockinEntity>()
        );

        return new PageUtils(page);
    }

}