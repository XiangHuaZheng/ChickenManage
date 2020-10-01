package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.SelldetailDao;
import io.renren.chick.chicken.entity.SelldetailEntity;
import io.renren.chick.chicken.service.SelldetailService;


@Service("selldetailService")
public class SelldetailServiceImpl extends ServiceImpl<SelldetailDao, SelldetailEntity> implements SelldetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SelldetailEntity> page = this.page(
                new Query<SelldetailEntity>().getPage(params),
                new QueryWrapper<SelldetailEntity>()
        );

        return new PageUtils(page);
    }

}