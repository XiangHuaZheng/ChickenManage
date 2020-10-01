package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.EggsstockDao;
import com.hua.chick.chicken.entity.EggsstockEntity;
import com.hua.chick.chicken.service.EggsstockService;


@Service("eggsstockService")
public class EggsstockServiceImpl extends ServiceImpl<EggsstockDao, EggsstockEntity> implements EggsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsstockEntity> page = this.page(
                new Query<EggsstockEntity>().getPage(params),
                new QueryWrapper<EggsstockEntity>()
        );

        return new PageUtils(page);
    }

}