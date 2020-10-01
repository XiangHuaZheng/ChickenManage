package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.FeedoutdetailDao;
import io.renren.chick.chicken.entity.FeedoutdetailEntity;
import io.renren.chick.chicken.service.FeedoutdetailService;


@Service("feedoutdetailService")
public class FeedoutdetailServiceImpl extends ServiceImpl<FeedoutdetailDao, FeedoutdetailEntity> implements FeedoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedoutdetailEntity> page = this.page(
                new Query<FeedoutdetailEntity>().getPage(params),
                new QueryWrapper<FeedoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}