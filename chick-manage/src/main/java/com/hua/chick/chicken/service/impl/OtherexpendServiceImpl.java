package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.OtherexpendDao;
import com.hua.chick.chicken.entity.OtherexpendEntity;
import com.hua.chick.chicken.service.OtherexpendService;


@Service("otherexpendService")
public class OtherexpendServiceImpl extends ServiceImpl<OtherexpendDao, OtherexpendEntity> implements OtherexpendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OtherexpendEntity> page = this.page(
                new Query<OtherexpendEntity>().getPage(params),
                new QueryWrapper<OtherexpendEntity>()
        );

        return new PageUtils(page);
    }

}