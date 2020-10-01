package io.renren.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.FormulaDao;
import io.renren.chick.chicken.entity.FormulaEntity;
import io.renren.chick.chicken.service.FormulaService;


@Service("formulaService")
public class FormulaServiceImpl extends ServiceImpl<FormulaDao, FormulaEntity> implements FormulaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FormulaEntity> page = this.page(
                new Query<FormulaEntity>().getPage(params),
                new QueryWrapper<FormulaEntity>()
        );

        return new PageUtils(page);
    }

}