package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.IncomeDao;
import com.hua.chick.chicken.entity.IncomeEntity;
import com.hua.chick.chicken.service.IncomeService;


@Service("incomeService")
public class IncomeServiceImpl extends ServiceImpl<IncomeDao, IncomeEntity> implements IncomeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IncomeEntity> page = this.page(
                new Query<IncomeEntity>().getPage(params),
                new QueryWrapper<IncomeEntity>()
        );

        return new PageUtils(page);
    }

}