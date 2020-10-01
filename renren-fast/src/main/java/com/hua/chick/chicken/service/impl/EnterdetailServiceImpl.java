package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.EnterdetailDao;
import com.hua.chick.chicken.entity.EnterdetailEntity;
import com.hua.chick.chicken.service.EnterdetailService;


@Service("enterdetailService")
public class EnterdetailServiceImpl extends ServiceImpl<EnterdetailDao, EnterdetailEntity> implements EnterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EnterdetailEntity> page = this.page(
                new Query<EnterdetailEntity>().getPage(params),
                new QueryWrapper<EnterdetailEntity>()
        );

        return new PageUtils(page);
    }

}