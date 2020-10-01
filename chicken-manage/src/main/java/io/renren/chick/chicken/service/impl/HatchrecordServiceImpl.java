package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.HatchrecordDao;
import io.renren.chick.chicken.entity.HatchrecordEntity;
import io.renren.chick.chicken.service.HatchrecordService;


@Service("hatchrecordService")
public class HatchrecordServiceImpl extends ServiceImpl<HatchrecordDao, HatchrecordEntity> implements HatchrecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HatchrecordEntity> page = this.page(
                new Query<HatchrecordEntity>().getPage(params),
                new QueryWrapper<HatchrecordEntity>()
        );

        return new PageUtils(page);
    }

}