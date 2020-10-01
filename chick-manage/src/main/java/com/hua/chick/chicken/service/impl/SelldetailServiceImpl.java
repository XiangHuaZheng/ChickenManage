package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.SelldetailDao;
import com.hua.chick.chicken.entity.SelldetailEntity;
import com.hua.chick.chicken.service.SelldetailService;


@Service("selldetailService")
public class SelldetailServiceImpl extends ServiceImpl<SelldetailDao, SelldetailEntity> implements SelldetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SelldetailEntity> page = this.page(
                new Query<SelldetailEntity>().getPage(params),
                new QueryWrapper<SelldetailEntity>()
        );

        return new PageUtils(page);
    }

}