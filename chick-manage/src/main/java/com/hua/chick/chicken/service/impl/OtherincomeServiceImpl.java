package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.OtherincomeDao;
import com.hua.chick.chicken.entity.OtherincomeEntity;
import com.hua.chick.chicken.service.OtherincomeService;


@Service("otherincomeService")
public class OtherincomeServiceImpl extends ServiceImpl<OtherincomeDao, OtherincomeEntity> implements OtherincomeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OtherincomeEntity> page = this.page(
                new Query<OtherincomeEntity>().getPage(params),
                new QueryWrapper<OtherincomeEntity>()
        );

        return new PageUtils(page);
    }

}