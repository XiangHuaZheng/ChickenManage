package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.OhterincomeexpendsummeryDao;
import io.renren.chick.chicken.entity.OhterincomeexpendsummeryEntity;
import io.renren.chick.chicken.service.OhterincomeexpendsummeryService;


@Service("ohterincomeexpendsummeryService")
public class OhterincomeexpendsummeryServiceImpl extends ServiceImpl<OhterincomeexpendsummeryDao, OhterincomeexpendsummeryEntity> implements OhterincomeexpendsummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OhterincomeexpendsummeryEntity> page = this.page(
                new Query<OhterincomeexpendsummeryEntity>().getPage(params),
                new QueryWrapper<OhterincomeexpendsummeryEntity>()
        );

        return new PageUtils(page);
    }

}