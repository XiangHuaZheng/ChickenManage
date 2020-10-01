package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsoutdetailDao;
import io.renren.chick.chicken.entity.GoodsoutdetailEntity;
import io.renren.chick.chicken.service.GoodsoutdetailService;


@Service("goodsoutdetailService")
public class GoodsoutdetailServiceImpl extends ServiceImpl<GoodsoutdetailDao, GoodsoutdetailEntity> implements GoodsoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsoutdetailEntity> page = this.page(
                new Query<GoodsoutdetailEntity>().getPage(params),
                new QueryWrapper<GoodsoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}