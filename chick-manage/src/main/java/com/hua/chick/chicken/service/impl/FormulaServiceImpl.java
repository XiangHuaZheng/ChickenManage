package com.hua.chick.chicken.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.Query;

import com.hua.chick.chicken.dao.FormulaDao;
import com.hua.chick.chicken.entity.FormulaEntity;
import com.hua.chick.chicken.service.FormulaService;


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