package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.SellDao;
import io.renren.chick.chicken.entity.SellEntity;
import io.renren.chick.chicken.service.SellService;


@Service("sellService")
public class SellServiceImpl extends ServiceImpl<SellDao, SellEntity> implements SellService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellEntity> page = this.page(
                new Query<SellEntity>().getPage(params),
                new QueryWrapper<SellEntity>()
        );

        return new PageUtils(page);
    }

}