package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsrecordDao;
import com.hua.chick.chicken.entity.DrugsrecordEntity;
import com.hua.chick.chicken.service.DrugsrecordService;


@Service("drugsrecordService")
public class DrugsrecordServiceImpl extends ServiceImpl<DrugsrecordDao, DrugsrecordEntity> implements DrugsrecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsrecordEntity> page = this.page(
                new Query<DrugsrecordEntity>().getPage(params),
                new QueryWrapper<DrugsrecordEntity>()
        );

        return new PageUtils(page);
    }

}