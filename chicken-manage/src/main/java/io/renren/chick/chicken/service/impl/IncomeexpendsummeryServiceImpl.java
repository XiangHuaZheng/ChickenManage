package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.IncomeexpendsummeryDao;
import io.renren.chick.chicken.entity.IncomeexpendsummeryEntity;
import io.renren.chick.chicken.service.IncomeexpendsummeryService;


@Service("incomeexpendsummeryService")
public class IncomeexpendsummeryServiceImpl extends ServiceImpl<IncomeexpendsummeryDao, IncomeexpendsummeryEntity> implements IncomeexpendsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IncomeexpendsummeryEntity> page = this.page(
                new Query<IncomeexpendsummeryEntity>().getPage(params),
                new QueryWrapper<IncomeexpendsummeryEntity>()
        );

        return new PageUtils(page);
    }

}