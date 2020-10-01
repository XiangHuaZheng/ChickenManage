package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.StaffDao;
import com.hua.chick.chicken.entity.StaffEntity;
import com.hua.chick.chicken.service.StaffService;


@Service("staffService")
public class StaffServiceImpl extends ServiceImpl<StaffDao, StaffEntity> implements StaffService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StaffEntity> page = this.page(
                new Query<StaffEntity>().getPage(params),
                new QueryWrapper<StaffEntity>()
        );

        return new PageUtils(page);
    }

}