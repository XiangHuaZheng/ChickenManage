package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.SellsummeryDao;
import io.renren.chick.chicken.entity.SellsummeryEntity;
import io.renren.chick.chicken.service.SellsummeryService;


@Service("sellsummeryService")
public class SellsummeryServiceImpl extends ServiceImpl<SellsummeryDao, SellsummeryEntity> implements SellsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellsummeryEntity> page = this.page(
                new Query<SellsummeryEntity>().getPage(params),
                new QueryWrapper<SellsummeryEntity>()
        );

        return new PageUtils(page);
    }

}