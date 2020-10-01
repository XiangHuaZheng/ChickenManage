package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsstockDao;
import io.renren.chick.chicken.entity.GoodsstockEntity;
import io.renren.chick.chicken.service.GoodsstockService;


@Service("goodsstockService")
public class GoodsstockServiceImpl extends ServiceImpl<GoodsstockDao, GoodsstockEntity> implements GoodsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsstockEntity> page = this.page(
                new Query<GoodsstockEntity>().getPage(params),
                new QueryWrapper<GoodsstockEntity>()
        );

        return new PageUtils(page);
    }

}