package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EnterDao;
import io.renren.chick.chicken.entity.EnterEntity;
import io.renren.chick.chicken.service.EnterService;


@Service("enterService")
public class EnterServiceImpl extends ServiceImpl<EnterDao, EnterEntity> implements EnterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                new QueryWrapper<EnterEntity>()
        );

        return new PageUtils(page);
    }

}