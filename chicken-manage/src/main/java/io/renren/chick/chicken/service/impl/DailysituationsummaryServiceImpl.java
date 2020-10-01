package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DailysituationsummaryDao;
import io.renren.chick.chicken.entity.DailysituationsummaryEntity;
import io.renren.chick.chicken.service.DailysituationsummaryService;


@Service("dailysituationsummaryService")
public class DailysituationsummaryServiceImpl extends ServiceImpl<DailysituationsummaryDao, DailysituationsummaryEntity> implements DailysituationsummaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DailysituationsummaryEntity> page = this.page(
                new Query<DailysituationsummaryEntity>().getPage(params),
                new QueryWrapper<DailysituationsummaryEntity>()
        );

        return new PageUtils(page);
    }

}