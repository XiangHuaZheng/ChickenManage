package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsenterDao;
import io.renren.chick.chicken.entity.GoodsenterEntity;
import io.renren.chick.chicken.service.GoodsenterService;


@Service("goodsenterService")
public class GoodsenterServiceImpl extends ServiceImpl<GoodsenterDao, GoodsenterEntity> implements GoodsenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsenterEntity> page = this.page(
                new Query<GoodsenterEntity>().getPage(params),
                new QueryWrapper<GoodsenterEntity>()
        );

        return new PageUtils(page);
    }

}