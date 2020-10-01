package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.EggsoutEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 鸡蛋销售出库
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Mapper
public interface EggsoutDao extends BaseMapper<EggsoutEntity> {
	
}
