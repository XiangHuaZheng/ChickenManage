package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.ExpendDao;
import io.renren.chick.chicken.entity.ExpendEntity;
import io.renren.chick.chicken.service.ExpendService;


@Service("expendService")
public class ExpendServiceImpl extends ServiceImpl<ExpendDao, ExpendEntity> implements ExpendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExpendEntity> page = this.page(
                new Query<ExpendEntity>().getPage(params),
                new QueryWrapper<ExpendEntity>()
        );

        return new PageUtils(page);
    }

}