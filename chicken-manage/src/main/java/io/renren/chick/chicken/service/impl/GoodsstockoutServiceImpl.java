package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsstockoutDao;
import io.renren.chick.chicken.entity.GoodsstockoutEntity;
import io.renren.chick.chicken.service.GoodsstockoutService;


@Service("goodsstockoutService")
public class GoodsstockoutServiceImpl extends ServiceImpl<GoodsstockoutDao, GoodsstockoutEntity> implements GoodsstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsstockoutEntity> page = this.page(
                new Query<GoodsstockoutEntity>().getPage(params),
                new QueryWrapper<GoodsstockoutEntity>()
        );

        return new PageUtils(page);
    }

}