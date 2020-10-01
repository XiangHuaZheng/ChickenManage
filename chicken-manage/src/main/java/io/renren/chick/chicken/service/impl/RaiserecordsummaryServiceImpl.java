package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.RaiserecordsummaryDao;
import io.renren.chick.chicken.entity.RaiserecordsummaryEntity;
import io.renren.chick.chicken.service.RaiserecordsummaryService;


@Service("raiserecordsummaryService")
public class RaiserecordsummaryServiceImpl extends ServiceImpl<RaiserecordsummaryDao, RaiserecordsummaryEntity> implements RaiserecordsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RaiserecordsummaryEntity> page = this.page(
                new Query<RaiserecordsummaryEntity>().getPage(params),
                new QueryWrapper<RaiserecordsummaryEntity>()
        );

        return new PageUtils(page);
    }

}