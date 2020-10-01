package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.OhterincomeexpendsummeryDao;
import com.hua.chick.chicken.entity.OhterincomeexpendsummeryEntity;
import com.hua.chick.chicken.service.OhterincomeexpendsummeryService;


@Service("ohterincomeexpendsummeryService")
public class OhterincomeexpendsummeryServiceImpl extends ServiceImpl<OhterincomeexpendsummeryDao, OhterincomeexpendsummeryEntity> implements OhterincomeexpendsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OhterincomeexpendsummeryEntity> page = this.page(
                new Query<OhterincomeexpendsummeryEntity>().getPage(params),
                new QueryWrapper<OhterincomeexpendsummeryEntity>()
        );

        return new PageUtils(page);
    }

}