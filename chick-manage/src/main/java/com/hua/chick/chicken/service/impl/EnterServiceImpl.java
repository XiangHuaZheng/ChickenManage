package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.EnterDao;
import com.hua.chick.chicken.entity.EnterEntity;
import com.hua.chick.chicken.service.EnterService;


@Service("enterService")
public class EnterServiceImpl extends ServiceImpl<EnterDao, EnterEntity> implements EnterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                new QueryWrapper<EnterEntity>()
        );

        return new PageUtils(page);
    }

}