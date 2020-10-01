package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsoutDao;
import io.renren.chick.chicken.entity.DrugsoutEntity;
import io.renren.chick.chicken.service.DrugsoutService;


@Service("drugsoutService")
public class DrugsoutServiceImpl extends ServiceImpl<DrugsoutDao, DrugsoutEntity> implements DrugsoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsoutEntity> page = this.page(
                new Query<DrugsoutEntity>().getPage(params),
                new QueryWrapper<DrugsoutEntity>()
        );

        return new PageUtils(page);
    }

}