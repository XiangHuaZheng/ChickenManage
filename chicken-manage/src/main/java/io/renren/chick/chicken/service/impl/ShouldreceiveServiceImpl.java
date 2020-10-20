package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.ShouldreceiveDao;
import io.renren.chick.chicken.entity.ShouldreceiveEntity;
import io.renren.chick.chicken.service.ShouldreceiveService;


@Service("shouldreceiveService")
public class ShouldreceiveServiceImpl extends ServiceImpl<ShouldreceiveDao, ShouldreceiveEntity> implements ShouldreceiveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShouldreceiveEntity> page = this.page(
                new Query<ShouldreceiveEntity>().getPage(params),
                new QueryWrapper<ShouldreceiveEntity>()
        );

        return new PageUtils(page);
    }

}