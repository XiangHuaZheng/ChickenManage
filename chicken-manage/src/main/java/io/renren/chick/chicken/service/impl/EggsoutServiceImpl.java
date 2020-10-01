package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EggsoutDao;
import io.renren.chick.chicken.entity.EggsoutEntity;
import io.renren.chick.chicken.service.EggsoutService;


@Service("eggsoutService")
public class EggsoutServiceImpl extends ServiceImpl<EggsoutDao, EggsoutEntity> implements EggsoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsoutEntity> page = this.page(
                new Query<EggsoutEntity>().getPage(params),
                new QueryWrapper<EggsoutEntity>()
        );

        return new PageUtils(page);
    }

}