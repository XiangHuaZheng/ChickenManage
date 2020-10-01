package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.FeedstockDao;
import io.renren.chick.chicken.entity.FeedstockEntity;
import io.renren.chick.chicken.service.FeedstockService;


@Service("feedstockService")
public class FeedstockServiceImpl extends ServiceImpl<FeedstockDao, FeedstockEntity> implements FeedstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedstockEntity> page = this.page(
                new Query<FeedstockEntity>().getPage(params),
                new QueryWrapper<FeedstockEntity>()
        );

        return new PageUtils(page);
    }

}