package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.MaterialDao;
import io.renren.chick.chicken.entity.MaterialEntity;
import io.renren.chick.chicken.service.MaterialService;


@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialEntity> page = this.page(
                new Query<MaterialEntity>().getPage(params),
                new QueryWrapper<MaterialEntity>()
        );

        return new PageUtils(page);
    }

}