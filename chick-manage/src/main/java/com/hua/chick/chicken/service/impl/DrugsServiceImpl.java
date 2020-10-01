package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsDao;
import com.hua.chick.chicken.entity.DrugsEntity;
import com.hua.chick.chicken.service.DrugsService;


@Service("drugsService")
public class DrugsServiceImpl extends ServiceImpl<DrugsDao, DrugsEntity> implements DrugsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsEntity> page = this.page(
                new Query<DrugsEntity>().getPage(params),
                new QueryWrapper<DrugsEntity>()
        );

        return new PageUtils(page);
    }

}