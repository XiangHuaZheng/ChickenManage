package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EggsstockDao;
import io.renren.chick.chicken.entity.EggsstockEntity;
import io.renren.chick.chicken.service.EggsstockService;


@Service("eggsstockService")
public class EggsstockServiceImpl extends ServiceImpl<EggsstockDao, EggsstockEntity> implements EggsstockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsstockEntity> page = this.page(
                new Query<EggsstockEntity>().getPage(params),
                new QueryWrapper<EggsstockEntity>()
        );

        return new PageUtils(page);
    }

}