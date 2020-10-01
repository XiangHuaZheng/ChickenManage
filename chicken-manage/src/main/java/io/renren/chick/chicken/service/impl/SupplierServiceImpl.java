package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.SupplierDao;
import io.renren.chick.chicken.entity.SupplierEntity;
import io.renren.chick.chicken.service.SupplierService;


@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, SupplierEntity> implements SupplierService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SupplierEntity> page = this.page(
                new Query<SupplierEntity>().getPage(params),
                new QueryWrapper<SupplierEntity>()
        );

        return new PageUtils(page);
    }

}