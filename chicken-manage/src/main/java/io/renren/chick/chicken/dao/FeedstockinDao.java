package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.FeedstockinEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 饲料入库汇总
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:45
 */
@Mapper
public interface FeedstockinDao extends BaseMapper<FeedstockinEntity> {
	
}
