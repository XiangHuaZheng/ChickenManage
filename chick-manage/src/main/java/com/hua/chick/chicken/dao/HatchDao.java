package com.hua.chick.chicken.dao;

import com.hua.chick.chicken.entity.HatchEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 孵化报表
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Mapper
public interface HatchDao extends BaseMapper<HatchEntity> {
	
}
