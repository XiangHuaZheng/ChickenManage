package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsenterDao;
import io.renren.chick.chicken.entity.DrugsenterEntity;
import io.renren.chick.chicken.service.DrugsenterService;


@Service("drugsenterService")
public class DrugsenterServiceImpl extends ServiceImpl<DrugsenterDao, DrugsenterEntity> implements DrugsenterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsenterEntity> page = this.page(
                new Query<DrugsenterEntity>().getPage(params),
                new QueryWrapper<DrugsenterEntity>()
        );

        return new PageUtils(page);
    }

}