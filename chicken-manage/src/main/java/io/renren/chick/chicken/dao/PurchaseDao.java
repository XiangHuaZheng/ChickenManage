package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 期间采购查询
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
