package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.RaiserecordDao;
import io.renren.chick.chicken.entity.RaiserecordEntity;
import io.renren.chick.chicken.service.RaiserecordService;


@Service("raiserecordService")
public class RaiserecordServiceImpl extends ServiceImpl<RaiserecordDao, RaiserecordEntity> implements RaiserecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RaiserecordEntity> page = this.page(
                new Query<RaiserecordEntity>().getPage(params),
                new QueryWrapper<RaiserecordEntity>()
        );

        return new PageUtils(page);
    }

}