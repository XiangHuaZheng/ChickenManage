package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.DrugsfailurealertDao;
import io.renren.chick.chicken.entity.DrugsfailurealertEntity;
import io.renren.chick.chicken.service.DrugsfailurealertService;


@Service("drugsfailurealertService")
public class DrugsfailurealertServiceImpl extends ServiceImpl<DrugsfailurealertDao, DrugsfailurealertEntity> implements DrugsfailurealertService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrugsfailurealertEntity> page = this.page(
                new Query<DrugsfailurealertEntity>().getPage(params),
                new QueryWrapper<DrugsfailurealertEntity>()
        );

        return new PageUtils(page);
    }

}