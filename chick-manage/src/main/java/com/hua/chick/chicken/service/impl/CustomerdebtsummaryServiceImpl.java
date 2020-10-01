package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.CustomerdebtsummaryDao;
import com.hua.chick.chicken.entity.CustomerdebtsummaryEntity;
import com.hua.chick.chicken.service.CustomerdebtsummaryService;


@Service("customerdebtsummaryService")
public class CustomerdebtsummaryServiceImpl extends ServiceImpl<CustomerdebtsummaryDao, CustomerdebtsummaryEntity> implements CustomerdebtsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerdebtsummaryEntity> page = this.page(
                new Query<CustomerdebtsummaryEntity>().getPage(params),
                new QueryWrapper<CustomerdebtsummaryEntity>()
        );

        return new PageUtils(page);
    }

}