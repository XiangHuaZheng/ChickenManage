package io.renren.chick.chicken.service.impl;

import io.renren.chick.chicken.entity.EnterdetailEntity;
import io.renren.chick.chicken.entity.ShouldpayEntity;
import io.renren.chick.chicken.service.EnterdetailService;
import io.renren.chick.chicken.service.ShouldpayService;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.EnterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.chick.chicken.dao.EnterDao;
import io.renren.chick.chicken.entity.EnterEntity;
import io.renren.chick.chicken.service.EnterService;


@Service("enterService")
public class EnterServiceImpl extends ServiceImpl<EnterDao, EnterEntity> implements EnterService {

    @Autowired
    EnterService enterService;

    @Autowired
    EnterdetailService enterdetailService;

    @Autowired
    ShouldpayService shouldpayService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils certainList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils todayList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("enter_date",format);
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PassNumTo todayCertainList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("enter_date",format);
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );
        List<EnterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<EnterEntity>().eq("certain", 1).eq("pass", 0));
        int size = enterEntities.size();
        PassNumTo passNumTo = new PassNumTo();
        passNumTo.setPageUtils(new PageUtils(page));
        passNumTo.setPassSize(size);
        return passNumTo;
    }

    @Override
    public PageUtils monthList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<EnterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<EnterEntity>());
        List<EnterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils monthCertainList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<EnterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<EnterEntity>().eq("certain",1));
        List<EnterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils yearCertainList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<EnterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<EnterEntity>().eq("certain",1));
        List<EnterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public EnterdetailEntity getDetailById(Map<String, Object> params) {
        String id = (String) params.get("id");
        EnterEntity enterEntity = baseMapper.selectById(id);
        Long batchNo = enterEntity.getBatchNo();
        List<EnterdetailEntity> list = enterdetailService.list(new QueryWrapper<EnterdetailEntity>().eq("batch_no", batchNo));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageUtils yearList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<EnterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<EnterEntity>());
        List<EnterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils passList(Map<String, Object> params) {
        QueryWrapper<EnterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1).eq("pass",0);
        IPage<EnterEntity> page = this.page(
                new Query<EnterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void passById(Long id) {
        EnterEntity entity = enterService.getById(id);
        //审核通过
        entity.setPass(1);
        enterService.updateById(entity);
        //应付系统
        ShouldpayEntity shouldpayEntity = new ShouldpayEntity();
        shouldpayEntity.setCategory(1);
        shouldpayEntity.setName("进鸡应付");
        shouldpayEntity.setIncomePrice(entity.getPrice().multiply(new BigDecimal(entity.getNum())));
        shouldpayEntity.setTime(entity.getEnterDate());
        shouldpayService.save(shouldpayEntity);
    }

    @Override
    public void saveEnterVo(EnterVo enter) {
        EnterEntity enterEntity = new EnterEntity();
        BeanUtils.copyProperties(enter,enterEntity);
        enterService.save(enterEntity);
        EnterdetailEntity enterdetailEntity = new EnterdetailEntity();
        enterdetailEntity.setBatchNo(enter.getBatchNo());
        enterdetailEntity.setChickenNo(enter.getChickenNo());
        enterdetailEntity.setStoreNum(enter.getStoreNum());
        enterdetailEntity.setCategory(enter.getCategory());
        enterdetailEntity.setRemarks(enter.getRemarks2());
        enterdetailService.save(enterdetailEntity);
    }

    @Override
    public void updateEnterVoById(EnterVo enter) {
        EnterEntity enterEntity = new EnterEntity();
        BeanUtils.copyProperties(enter,enterEntity);
        enterService.updateById(enterEntity);
    }

    @Override
    public void certainById(Long id) {
        EnterEntity entity = enterService.getById(id);
        entity.setCertain(1);
        enterService.updateById(entity);
    }



}