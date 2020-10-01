package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsstockinDao;
import io.renren.chick.chicken.entity.GoodsstockinEntity;
import io.renren.chick.chicken.service.GoodsstockinService;


@Service("goodsstockinService")
public class GoodsstockinServiceImpl extends ServiceImpl<GoodsstockinDao, GoodsstockinEntity> implements GoodsstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsstockinEntity> page = this.page(
                new Query<GoodsstockinEntity>().getPage(params),
                new QueryWrapper<GoodsstockinEntity>()
        );

        return new PageUtils(page);
    }

}