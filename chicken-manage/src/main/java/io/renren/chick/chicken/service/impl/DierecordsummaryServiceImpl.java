package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DierecordsummaryDao;
import io.renren.chick.chicken.entity.DierecordsummaryEntity;
import io.renren.chick.chicken.service.DierecordsummaryService;


@Service("dierecordsummaryService")
public class DierecordsummaryServiceImpl extends ServiceImpl<DierecordsummaryDao, DierecordsummaryEntity> implements DierecordsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DierecordsummaryEntity> page = this.page(
                new Query<DierecordsummaryEntity>().getPage(params),
                new QueryWrapper<DierecordsummaryEntity>()
        );

        return new PageUtils(page);
    }

}