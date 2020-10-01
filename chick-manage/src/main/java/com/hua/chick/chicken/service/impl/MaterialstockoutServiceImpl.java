package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialstockoutDao;
import com.hua.chick.chicken.entity.MaterialstockoutEntity;
import com.hua.chick.chicken.service.MaterialstockoutService;


@Service("materialstockoutService")
public class MaterialstockoutServiceImpl extends ServiceImpl<MaterialstockoutDao, MaterialstockoutEntity> implements MaterialstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialstockoutEntity> page = this.page(
                new Query<MaterialstockoutEntity>().getPage(params),
                new QueryWrapper<MaterialstockoutEntity>()
        );

        return new PageUtils(page);
    }

}