package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.GoodsenterdetailDao;
import io.renren.chick.chicken.entity.GoodsenterdetailEntity;
import io.renren.chick.chicken.service.GoodsenterdetailService;


@Service("goodsenterdetailService")
public class GoodsenterdetailServiceImpl extends ServiceImpl<GoodsenterdetailDao, GoodsenterdetailEntity> implements GoodsenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsenterdetailEntity> page = this.page(
                new Query<GoodsenterdetailEntity>().getPage(params),
                new QueryWrapper<GoodsenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}