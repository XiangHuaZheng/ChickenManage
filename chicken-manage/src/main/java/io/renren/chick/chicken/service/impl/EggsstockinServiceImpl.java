package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EggsstockinDao;
import io.renren.chick.chicken.entity.EggsstockinEntity;
import io.renren.chick.chicken.service.EggsstockinService;


@Service("eggsstockinService")
public class EggsstockinServiceImpl extends ServiceImpl<EggsstockinDao, EggsstockinEntity> implements EggsstockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsstockinEntity> page = this.page(
                new Query<EggsstockinEntity>().getPage(params),
                new QueryWrapper<EggsstockinEntity>()
        );

        return new PageUtils(page);
    }

}