package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EggsenterdetailDao;
import io.renren.chick.chicken.entity.EggsenterdetailEntity;
import io.renren.chick.chicken.service.EggsenterdetailService;


@Service("eggsenterdetailService")
public class EggsenterdetailServiceImpl extends ServiceImpl<EggsenterdetailDao, EggsenterdetailEntity> implements EggsenterdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EggsenterdetailEntity> page = this.page(
                new Query<EggsenterdetailEntity>().getPage(params),
                new QueryWrapper<EggsenterdetailEntity>()
        );

        return new PageUtils(page);
    }

}