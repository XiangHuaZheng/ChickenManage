package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.SellDao;
import com.hua.chick.chicken.entity.SellEntity;
import com.hua.chick.chicken.service.SellService;


@Service("sellService")
public class SellServiceImpl extends ServiceImpl<SellDao, SellEntity> implements SellService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellEntity> page = this.page(
                new Query<SellEntity>().getPage(params),
                new QueryWrapper<SellEntity>()
        );

        return new PageUtils(page);
    }

}