package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.ExpendDao;
import com.hua.chick.chicken.entity.ExpendEntity;
import com.hua.chick.chicken.service.ExpendService;


@Service("expendService")
public class ExpendServiceImpl extends ServiceImpl<ExpendDao, ExpendEntity> implements ExpendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExpendEntity> page = this.page(
                new Query<ExpendEntity>().getPage(params),
                new QueryWrapper<ExpendEntity>()
        );

        return new PageUtils(page);
    }

}