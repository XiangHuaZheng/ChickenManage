package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.HatchrecordDao;
import com.hua.chick.chicken.entity.HatchrecordEntity;
import com.hua.chick.chicken.service.HatchrecordService;


@Service("hatchrecordService")
public class HatchrecordServiceImpl extends ServiceImpl<HatchrecordDao, HatchrecordEntity> implements HatchrecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchrecordEntity> page = this.page(
                new Query<HatchrecordEntity>().getPage(params),
                new QueryWrapper<HatchrecordEntity>()
        );

        return new PageUtils(page);
    }

}