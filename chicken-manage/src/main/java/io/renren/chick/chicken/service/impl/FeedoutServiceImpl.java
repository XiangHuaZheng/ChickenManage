package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.FeedoutDao;
import io.renren.chick.chicken.entity.FeedoutEntity;
import io.renren.chick.chicken.service.FeedoutService;


@Service("feedoutService")
public class FeedoutServiceImpl extends ServiceImpl<FeedoutDao, FeedoutEntity> implements FeedoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                new QueryWrapper<FeedoutEntity>()
        );

        return new PageUtils(page);
    }

}