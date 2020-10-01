package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.GoodsstockinDao;
import com.hua.chick.chicken.entity.GoodsstockinEntity;
import com.hua.chick.chicken.service.GoodsstockinService;


@Service("goodsstockinService")
public class GoodsstockinServiceImpl extends ServiceImpl<GoodsstockinDao, GoodsstockinEntity> implements GoodsstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsstockinEntity> page = this.page(
                new Query<GoodsstockinEntity>().getPage(params),
                new QueryWrapper<GoodsstockinEntity>()
        );

        return new PageUtils(page);
    }

}