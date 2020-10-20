package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.ShouldpayDao;
import io.renren.chick.chicken.entity.ShouldpayEntity;
import io.renren.chick.chicken.service.ShouldpayService;


@Service("shouldpayService")
public class ShouldpayServiceImpl extends ServiceImpl<ShouldpayDao, ShouldpayEntity> implements ShouldpayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShouldpayEntity> page = this.page(
                new Query<ShouldpayEntity>().getPage(params),
                new QueryWrapper<ShouldpayEntity>()
        );

        return new PageUtils(page);
    }

}