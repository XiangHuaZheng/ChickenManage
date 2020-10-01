package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.CustomerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
	
}
