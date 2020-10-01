package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DierecordDao;
import io.renren.chick.chicken.entity.DierecordEntity;
import io.renren.chick.chicken.service.DierecordService;


@Service("dierecordService")
public class DierecordServiceImpl extends ServiceImpl<DierecordDao, DierecordEntity> implements DierecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DierecordEntity> page = this.page(
                new Query<DierecordEntity>().getPage(params),
                new QueryWrapper<DierecordEntity>()
        );

        return new PageUtils(page);
    }

}