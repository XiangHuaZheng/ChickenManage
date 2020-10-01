package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsenterdetailDao;
import com.hua.chick.chicken.entity.DrugsenterdetailEntity;
import com.hua.chick.chicken.service.DrugsenterdetailService;


@Service("drugsenterdetailService")
public class DrugsenterdetailServiceImpl extends ServiceImpl<DrugsenterdetailDao, DrugsenterdetailEntity> implements DrugsenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsenterdetailEntity> page = this.page(
                new Query<DrugsenterdetailEntity>().getPage(params),
                new QueryWrapper<DrugsenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}