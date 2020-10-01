package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.MaterialstockinDao;
import com.hua.chick.chicken.entity.MaterialstockinEntity;
import com.hua.chick.chicken.service.MaterialstockinService;


@Service("materialstockinService")
public class MaterialstockinServiceImpl extends ServiceImpl<MaterialstockinDao, MaterialstockinEntity> implements MaterialstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialstockinEntity> page = this.page(
                new Query<MaterialstockinEntity>().getPage(params),
                new QueryWrapper<MaterialstockinEntity>()
        );

        return new PageUtils(page);
    }

}