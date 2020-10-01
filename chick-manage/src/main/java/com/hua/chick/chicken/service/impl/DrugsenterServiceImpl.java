package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsenterDao;
import com.hua.chick.chicken.entity.DrugsenterEntity;
import com.hua.chick.chicken.service.DrugsenterService;


@Service("drugsenterService")
public class DrugsenterServiceImpl extends ServiceImpl<DrugsenterDao, DrugsenterEntity> implements DrugsenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsenterEntity> page = this.page(
                new Query<DrugsenterEntity>().getPage(params),
                new QueryWrapper<DrugsenterEntity>()
        );

        return new PageUtils(page);
    }

}