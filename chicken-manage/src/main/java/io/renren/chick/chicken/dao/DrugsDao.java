package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.DrugsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Mapper
public interface DrugsDao extends BaseMapper<DrugsEntity> {
	
}
