package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.MaterialstockoutDao;
import io.renren.chick.chicken.entity.MaterialstockoutEntity;
import io.renren.chick.chicken.service.MaterialstockoutService;


@Service("materialstockoutService")
public class MaterialstockoutServiceImpl extends ServiceImpl<MaterialstockoutDao, MaterialstockoutEntity> implements MaterialstockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialstockoutEntity> page = this.page(
                new Query<MaterialstockoutEntity>().getPage(params),
                new QueryWrapper<MaterialstockoutEntity>()
        );

        return new PageUtils(page);
    }

}