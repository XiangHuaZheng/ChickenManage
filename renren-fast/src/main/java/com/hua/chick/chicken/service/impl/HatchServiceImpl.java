package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.HatchDao;
import com.hua.chick.chicken.entity.HatchEntity;
import com.hua.chick.chicken.service.HatchService;


@Service("hatchService")
public class HatchServiceImpl extends ServiceImpl<HatchDao, HatchEntity> implements HatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchEntity> page = this.page(
                new Query<HatchEntity>().getPage(params),
                new QueryWrapper<HatchEntity>()
        );

        return new PageUtils(page);
    }

}