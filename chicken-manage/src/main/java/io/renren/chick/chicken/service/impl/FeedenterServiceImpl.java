package io.renren.chick.chicken.service.impl;

import io.renren.chick.chicken.entity.*;
import io.renren.chick.chicken.service.*;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.FeedEnterVo;
import io.renren.chick.chicken.vo.FeedOutVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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

import io.renren.chick.chicken.dao.FeedenterDao;

@Service("feedenterService")
public class FeedenterServiceImpl extends ServiceImpl<FeedenterDao, FeedenterEntity> implements FeedenterService {
    @Autowired
    ShouldpayService shouldpayService;

    @Autowired
    FeedenterService feedenterService;

    @Autowired
    FeedenterdetailService feedenterdetailService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                new QueryWrapper<FeedenterEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils certainList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils todayList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("enter_date",format);
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PassNumTo todayCertainList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("enter_date",format);
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );
        List<FeedenterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedenterEntity>().eq("certain", 1).eq("pass", 0));
        int size = enterEntities.size();
        PassNumTo passNumTo = new PassNumTo();
        passNumTo.setPageUtils(new PageUtils(page));
        passNumTo.setPassSize(size);
        return passNumTo;
    }

    @Override
    public PageUtils monthList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedenterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedenterEntity>());
        List<FeedenterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils monthCertainList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedenterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedenterEntity>().eq("certain",1));
        List<FeedenterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils yearCertainList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedenterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedenterEntity>().eq("certain",1));
        List<FeedenterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public FeedenterdetailEntity getDetailById(Map<String, Object> params) {
        String id = (String) params.get("id");
        FeedenterEntity enterEntity = baseMapper.selectById(id);
        Long batchNo = enterEntity.getEnterNo();
        List<FeedenterdetailEntity> list = feedenterdetailService.list(new QueryWrapper<FeedenterdetailEntity>().eq("enter_no", batchNo));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageUtils yearList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedenterEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedenterEntity>());
        List<FeedenterEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getEnterDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils passList(Map<String, Object> params) {
        QueryWrapper<FeedenterEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1).eq("pass",0);
        IPage<FeedenterEntity> page = this.page(
                new Query<FeedenterEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void passById(Long id) {
        FeedenterEntity entity = feedenterService.getById(id);
        Long outNo = entity.getEnterNo();
        List<FeedenterdetailEntity> feedoutdetailEntities = feedenterdetailService.list(new QueryWrapper<FeedenterdetailEntity>().eq("enter_no", outNo));
        if(feedoutdetailEntities!=null && feedoutdetailEntities.size()>0){
            //应付系统
            ShouldpayEntity shouldreceiveEntity = new ShouldpayEntity();
            FeedenterdetailEntity detail = feedoutdetailEntities.get(0);
            shouldreceiveEntity.setCategory(3);
            shouldreceiveEntity.setName("饲料入库应付");
            shouldreceiveEntity.setIncomePrice(detail.getUnitNum().multiply(detail.getUnitPrice()));
            shouldreceiveEntity.setTime(entity.getEnterDate());
            shouldpayService.save(shouldreceiveEntity);
        }
        //审核通过
        entity.setPass(1);
        feedenterService.updateById(entity);
    }

    @Override
    public void saveFeedEnterVo(FeedEnterVo feedOut) {
        FeedenterEntity enterEntity = new FeedenterEntity();
        BeanUtils.copyProperties(feedOut,enterEntity);
        feedenterService.save(enterEntity);
        FeedenterdetailEntity detail = new FeedenterdetailEntity();
        detail.setCategory(feedOut.getCategory());
        detail.setDetailNo(feedOut.getDetailNo());
        detail.setName(feedOut.getName());
        detail.setEnterNo(feedOut.getEnterNo());
        detail.setSpecifications(feedOut.getSpecifications());
        detail.setUnit(feedOut.getUnit());
        detail.setUnitNum(feedOut.getUnitNum());
        detail.setUnitPrice(feedOut.getUnitPrice());
        feedenterdetailService.save(detail);
    }

    @Override
    public void updateFeedEnterVoById(FeedEnterVo enter) {
        FeedenterEntity entity = new FeedenterEntity();
        BeanUtils.copyProperties(enter,entity);
        feedenterService.updateById(entity);
    }

    @Override
    public void certainById(Long id) {
        FeedenterEntity entity = feedenterService.getById(id);
        entity.setCertain(1);
        feedenterService.updateById(entity);
    }

}