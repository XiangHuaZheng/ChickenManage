package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.EggsstockinEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 鸡蛋入库汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Mapper
public interface EggsstockinDao extends BaseMapper<EggsstockinEntity> {
	
}
