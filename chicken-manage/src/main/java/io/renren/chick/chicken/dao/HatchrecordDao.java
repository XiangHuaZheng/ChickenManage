package io.renren.chick.chicken.dao;

import io.renren.chick.chicken.entity.HatchrecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 孵化记录表
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@Mapper
public interface HatchrecordDao extends BaseMapper<HatchrecordEntity> {
	
}
