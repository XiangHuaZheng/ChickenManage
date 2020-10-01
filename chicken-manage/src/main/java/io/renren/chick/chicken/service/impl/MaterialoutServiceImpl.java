package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.MaterialoutDao;
import io.renren.chick.chicken.entity.MaterialoutEntity;
import io.renren.chick.chicken.service.MaterialoutService;


@Service("materialoutService")
public class MaterialoutServiceImpl extends ServiceImpl<MaterialoutDao, MaterialoutEntity> implements MaterialoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialoutEntity> page = this.page(
                new Query<MaterialoutEntity>().getPage(params),
                new QueryWrapper<MaterialoutEntity>()
        );

        return new PageUtils(page);
    }

}