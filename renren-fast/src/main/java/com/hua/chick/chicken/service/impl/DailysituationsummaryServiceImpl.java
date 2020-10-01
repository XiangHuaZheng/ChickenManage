package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DailysituationsummaryDao;
import com.hua.chick.chicken.entity.DailysituationsummaryEntity;
import com.hua.chick.chicken.service.DailysituationsummaryService;


@Service("dailysituationsummaryService")
public class DailysituationsummaryServiceImpl extends ServiceImpl<DailysituationsummaryDao, DailysituationsummaryEntity> implements DailysituationsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DailysituationsummaryEntity> page = this.page(
                new Query<DailysituationsummaryEntity>().getPage(params),
                new QueryWrapper<DailysituationsummaryEntity>()
        );

        return new PageUtils(page);
    }

}