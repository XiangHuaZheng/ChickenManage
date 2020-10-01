package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.FeedDao;
import io.renren.chick.chicken.entity.FeedEntity;
import io.renren.chick.chicken.service.FeedService;


@Service("feedService")
public class FeedServiceImpl extends ServiceImpl<FeedDao, FeedEntity> implements FeedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedEntity> page = this.page(
                new Query<FeedEntity>().getPage(params),
                new QueryWrapper<FeedEntity>()
        );

        return new PageUtils(page);
    }

}