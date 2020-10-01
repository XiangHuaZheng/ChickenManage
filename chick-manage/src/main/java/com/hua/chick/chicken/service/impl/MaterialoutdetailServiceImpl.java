package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialoutdetailDao;
import com.hua.chick.chicken.entity.MaterialoutdetailEntity;
import com.hua.chick.chicken.service.MaterialoutdetailService;


@Service("materialoutdetailService")
public class MaterialoutdetailServiceImpl extends ServiceImpl<MaterialoutdetailDao, MaterialoutdetailEntity> implements MaterialoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialoutdetailEntity> page = this.page(
                new Query<MaterialoutdetailEntity>().getPage(params),
                new QueryWrapper<MaterialoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}