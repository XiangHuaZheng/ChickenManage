package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialenterDao;
import com.hua.chick.chicken.entity.MaterialenterEntity;
import com.hua.chick.chicken.service.MaterialenterService;


@Service("materialenterService")
public class MaterialenterServiceImpl extends ServiceImpl<MaterialenterDao, MaterialenterEntity> implements MaterialenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialenterEntity> page = this.page(
                new Query<MaterialenterEntity>().getPage(params),
                new QueryWrapper<MaterialenterEntity>()
        );

        return new PageUtils(page);
    }

}