package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.HatchrecordsummeryDao;
import com.hua.chick.chicken.entity.HatchrecordsummeryEntity;
import com.hua.chick.chicken.service.HatchrecordsummeryService;


@Service("hatchrecordsummeryService")
public class HatchrecordsummeryServiceImpl extends ServiceImpl<HatchrecordsummeryDao, HatchrecordsummeryEntity> implements HatchrecordsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchrecordsummeryEntity> page = this.page(
                new Query<HatchrecordsummeryEntity>().getPage(params),
                new QueryWrapper<HatchrecordsummeryEntity>()
        );

        return new PageUtils(page);
    }

}