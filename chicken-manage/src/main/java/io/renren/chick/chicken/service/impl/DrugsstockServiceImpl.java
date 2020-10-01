package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsstockDao;
import io.renren.chick.chicken.entity.DrugsstockEntity;
import io.renren.chick.chicken.service.DrugsstockService;


@Service("drugsstockService")
public class DrugsstockServiceImpl extends ServiceImpl<DrugsstockDao, DrugsstockEntity> implements DrugsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsstockEntity> page = this.page(
                new Query<DrugsstockEntity>().getPage(params),
                new QueryWrapper<DrugsstockEntity>()
        );

        return new PageUtils(page);
    }

}