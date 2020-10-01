package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FeedenterdetailDao;
import com.hua.chick.chicken.entity.FeedenterdetailEntity;
import com.hua.chick.chicken.service.FeedenterdetailService;


@Service("feedenterdetailService")
public class FeedenterdetailServiceImpl extends ServiceImpl<FeedenterdetailDao, FeedenterdetailEntity> implements FeedenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedenterdetailEntity> page = this.page(
                new Query<FeedenterdetailEntity>().getPage(params),
                new QueryWrapper<FeedenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}