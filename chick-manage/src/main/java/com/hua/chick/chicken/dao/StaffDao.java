package com.hua.chick.chicken.dao;

import com.hua.chick.chicken.entity.StaffEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工信息
 * 
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 02:43:12
 */
@Mapper
public interface StaffDao extends BaseMapper<StaffEntity> {
	
}
