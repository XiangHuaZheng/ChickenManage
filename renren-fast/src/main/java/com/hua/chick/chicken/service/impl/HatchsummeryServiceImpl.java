package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.HatchsummeryDao;
import com.hua.chick.chicken.entity.HatchsummeryEntity;
import com.hua.chick.chicken.service.HatchsummeryService;


@Service("hatchsummeryService")
public class HatchsummeryServiceImpl extends ServiceImpl<HatchsummeryDao, HatchsummeryEntity> implements HatchsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchsummeryEntity> page = this.page(
                new Query<HatchsummeryEntity>().getPage(params),
                new QueryWrapper<HatchsummeryEntity>()
        );

        return new PageUtils(page);
    }

}