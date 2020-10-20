package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.ReceivepaysummeryDao;
import io.renren.chick.chicken.entity.ReceivepaysummeryEntity;
import io.renren.chick.chicken.service.ReceivepaysummeryService;


@Service("receivepaysummeryService")
public class ReceivepaysummeryServiceImpl extends ServiceImpl<ReceivepaysummeryDao, ReceivepaysummeryEntity> implements ReceivepaysummeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReceivepaysummeryEntity> page = this.page(
                new Query<ReceivepaysummeryEntity>().getPage(params),
                new QueryWrapper<ReceivepaysummeryEntity>()
        );

        return new PageUtils(page);
    }

}