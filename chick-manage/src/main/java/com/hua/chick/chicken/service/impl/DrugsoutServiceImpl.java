package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsoutDao;
import com.hua.chick.chicken.entity.DrugsoutEntity;
import com.hua.chick.chicken.service.DrugsoutService;


@Service("drugsoutService")
public class DrugsoutServiceImpl extends ServiceImpl<DrugsoutDao, DrugsoutEntity> implements DrugsoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsoutEntity> page = this.page(
                new Query<DrugsoutEntity>().getPage(params),
                new QueryWrapper<DrugsoutEntity>()
        );

        return new PageUtils(page);
    }

}