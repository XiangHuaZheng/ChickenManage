package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.HatchrecordsummeryDao;
import io.renren.chick.chicken.entity.HatchrecordsummeryEntity;
import io.renren.chick.chicken.service.HatchrecordsummeryService;


@Service("hatchrecordsummeryService")
public class HatchrecordsummeryServiceImpl extends ServiceImpl<HatchrecordsummeryDao, HatchrecordsummeryEntity> implements HatchrecordsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchrecordsummeryEntity> page = this.page(
                new Query<HatchrecordsummeryEntity>().getPage(params),
                new QueryWrapper<HatchrecordsummeryEntity>()
        );

        return new PageUtils(page);
    }

}