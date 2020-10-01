package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EntercostDao;
import io.renren.chick.chicken.entity.EntercostEntity;
import io.renren.chick.chicken.service.EntercostService;


@Service("entercostService")
public class EntercostServiceImpl extends ServiceImpl<EntercostDao, EntercostEntity> implements EntercostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EntercostEntity> page = this.page(
                new Query<EntercostEntity>().getPage(params),
                new QueryWrapper<EntercostEntity>()
        );

        return new PageUtils(page);
    }

}