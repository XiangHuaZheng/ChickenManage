package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialenterdetailDao;
import com.hua.chick.chicken.entity.MaterialenterdetailEntity;
import com.hua.chick.chicken.service.MaterialenterdetailService;


@Service("materialenterdetailService")
public class MaterialenterdetailServiceImpl extends ServiceImpl<MaterialenterdetailDao, MaterialenterdetailEntity> implements MaterialenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialenterdetailEntity> page = this.page(
                new Query<MaterialenterdetailEntity>().getPage(params),
                new QueryWrapper<MaterialenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}