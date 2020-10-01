package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialstockDao;
import com.hua.chick.chicken.entity.MaterialstockEntity;
import com.hua.chick.chicken.service.MaterialstockService;


@Service("materialstockService")
public class MaterialstockServiceImpl extends ServiceImpl<MaterialstockDao, MaterialstockEntity> implements MaterialstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialstockEntity> page = this.page(
                new Query<MaterialstockEntity>().getPage(params),
                new QueryWrapper<MaterialstockEntity>()
        );

        return new PageUtils(page);
    }

}