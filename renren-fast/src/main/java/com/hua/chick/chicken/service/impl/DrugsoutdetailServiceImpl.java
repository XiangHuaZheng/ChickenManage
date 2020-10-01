package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsoutdetailDao;
import com.hua.chick.chicken.entity.DrugsoutdetailEntity;
import com.hua.chick.chicken.service.DrugsoutdetailService;


@Service("drugsoutdetailService")
public class DrugsoutdetailServiceImpl extends ServiceImpl<DrugsoutdetailDao, DrugsoutdetailEntity> implements DrugsoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsoutdetailEntity> page = this.page(
                new Query<DrugsoutdetailEntity>().getPage(params),
                new QueryWrapper<DrugsoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}