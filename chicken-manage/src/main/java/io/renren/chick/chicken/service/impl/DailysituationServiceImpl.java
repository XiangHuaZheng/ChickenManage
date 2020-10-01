package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DailysituationDao;
import io.renren.chick.chicken.entity.DailysituationEntity;
import io.renren.chick.chicken.service.DailysituationService;


@Service("dailysituationService")
public class DailysituationServiceImpl extends ServiceImpl<DailysituationDao, DailysituationEntity> implements DailysituationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DailysituationEntity> page = this.page(
                new Query<DailysituationEntity>().getPage(params),
                new QueryWrapper<DailysituationEntity>()
        );

        return new PageUtils(page);
    }

}