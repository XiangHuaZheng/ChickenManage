package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsrecordsummaryDao;
import io.renren.chick.chicken.entity.DrugsrecordsummaryEntity;
import io.renren.chick.chicken.service.DrugsrecordsummaryService;


@Service("drugsrecordsummaryService")
public class DrugsrecordsummaryServiceImpl extends ServiceImpl<DrugsrecordsummaryDao, DrugsrecordsummaryEntity> implements DrugsrecordsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsrecordsummaryEntity> page = this.page(
                new Query<DrugsrecordsummaryEntity>().getPage(params),
                new QueryWrapper<DrugsrecordsummaryEntity>()
        );

        return new PageUtils(page);
    }

}