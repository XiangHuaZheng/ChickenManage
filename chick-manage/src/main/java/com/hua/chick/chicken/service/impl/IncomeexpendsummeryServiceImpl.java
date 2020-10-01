package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.IncomeexpendsummeryDao;
import com.hua.chick.chicken.entity.IncomeexpendsummeryEntity;
import com.hua.chick.chicken.service.IncomeexpendsummeryService;


@Service("incomeexpendsummeryService")
public class IncomeexpendsummeryServiceImpl extends ServiceImpl<IncomeexpendsummeryDao, IncomeexpendsummeryEntity> implements IncomeexpendsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IncomeexpendsummeryEntity> page = this.page(
                new Query<IncomeexpendsummeryEntity>().getPage(params),
                new QueryWrapper<IncomeexpendsummeryEntity>()
        );

        return new PageUtils(page);
    }

}