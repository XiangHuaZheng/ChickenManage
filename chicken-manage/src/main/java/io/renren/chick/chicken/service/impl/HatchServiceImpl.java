package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.HatchDao;
import io.renren.chick.chicken.entity.HatchEntity;
import io.renren.chick.chicken.service.HatchService;


@Service("hatchService")
public class HatchServiceImpl extends ServiceImpl<HatchDao, HatchEntity> implements HatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchEntity> page = this.page(
                new Query<HatchEntity>().getPage(params),
                new QueryWrapper<HatchEntity>()
        );

        return new PageUtils(page);
    }

}