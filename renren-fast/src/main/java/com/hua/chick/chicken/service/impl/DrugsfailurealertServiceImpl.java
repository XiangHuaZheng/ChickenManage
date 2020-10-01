package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.DrugsfailurealertDao;
import com.hua.chick.chicken.entity.DrugsfailurealertEntity;
import com.hua.chick.chicken.service.DrugsfailurealertService;


@Service("drugsfailurealertService")
public class DrugsfailurealertServiceImpl extends ServiceImpl<DrugsfailurealertDao, DrugsfailurealertEntity> implements DrugsfailurealertService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsfailurealertEntity> page = this.page(
                new Query<DrugsfailurealertEntity>().getPage(params),
                new QueryWrapper<DrugsfailurealertEntity>()
        );

        return new PageUtils(page);
    }

}