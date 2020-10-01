package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsoutdetailDao;
import io.renren.chick.chicken.entity.DrugsoutdetailEntity;
import io.renren.chick.chicken.service.DrugsoutdetailService;


@Service("drugsoutdetailService")
public class DrugsoutdetailServiceImpl extends ServiceImpl<DrugsoutdetailDao, DrugsoutdetailEntity> implements DrugsoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsoutdetailEntity> page = this.page(
                new Query<DrugsoutdetailEntity>().getPage(params),
                new QueryWrapper<DrugsoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}