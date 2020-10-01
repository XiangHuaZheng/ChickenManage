package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.IncomeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 各项收入
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Mapper
public interface IncomeDao extends BaseMapper<IncomeEntity> {
	
}
