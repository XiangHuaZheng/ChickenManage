package io.renren.chick.chicken.service.impl;

import io.renren.chick.chicken.entity.*;
import io.renren.chick.chicken.service.FeedoutdetailService;
import io.renren.chick.chicken.service.ShouldpayService;
import io.renren.chick.chicken.service.ShouldreceiveService;
import io.renren.chick.chicken.to.PassNumTo;
import io.renren.chick.chicken.vo.EnterVo;
import io.renren.chick.chicken.vo.FeedOutVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

import io.renren.chick.chicken.dao.FeedoutDao;
import io.renren.chick.chicken.service.FeedoutService;


@Service("feedoutService")
public class FeedoutServiceImpl extends ServiceImpl<FeedoutDao, FeedoutEntity> implements FeedoutService {
    @Autowired
    ShouldreceiveService shouldreceiveService;

    @Autowired
    FeedoutService feedoutService;

    @Autowired
    FeedoutdetailService feedoutdetailService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                new QueryWrapper<FeedoutEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils certainList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils todayList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("out_date",format);
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PassNumTo todayCertainList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1);
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        String format = df1.format(date);
        wrapper.eq("out_date",format);
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );
        List<FeedoutEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedoutEntity>().eq("certain", 1).eq("pass", 0));
        int size = enterEntities.size();
        PassNumTo passNumTo = new PassNumTo();
        passNumTo.setPageUtils(new PageUtils(page));
        passNumTo.setPassSize(size);
        return passNumTo;
    }

    @Override
    public PageUtils monthList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedoutEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedoutEntity>());
        List<FeedoutEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getOutDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils monthCertainList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedoutEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedoutEntity>().eq("certain",1));
        List<FeedoutEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getOutDate();
            Integer enterMonth = Integer.valueOf(df1.format(enterDate).split("-")[1]);
            return month == enterMonth;
        }).collect(Collectors.toList());

        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils yearCertainList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedoutEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedoutEntity>().eq("certain",1));
        List<FeedoutEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getOutDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public FeedoutdetailEntity getDetailById(Map<String, Object> params) {
        String id = (String) params.get("id");
        FeedoutEntity enterEntity = baseMapper.selectById(id);
        Long batchNo = enterEntity.getOutNo();
        List<FeedoutdetailEntity> list = feedoutdetailService.list(new QueryWrapper<FeedoutdetailEntity>().eq("out_no", batchNo));
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageUtils yearList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year=cal.get(Calendar.YEAR);;//获取月份
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        List<FeedoutEntity> enterEntities = baseMapper.selectList(new QueryWrapper<FeedoutEntity>());
        List<FeedoutEntity> collect = enterEntities.stream().filter(item -> {
            Date enterDate = item.getOutDate();
            Integer enterYear = Integer.valueOf(df1.format(enterDate).split("-")[0]);
            return year == enterYear;
        }).collect(Collectors.toList());

        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);

        return pageUtils;
    }

    @Override
    public PageUtils passList(Map<String, Object> params) {
        QueryWrapper<FeedoutEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("certain",1).eq("pass",0);
        IPage<FeedoutEntity> page = this.page(
                new Query<FeedoutEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void passById(Long id) {
        FeedoutEntity entity = feedoutService.getById(id);
        Long outNo = entity.getOutNo();
        List<FeedoutdetailEntity> feedoutdetailEntities = feedoutdetailService.list(new QueryWrapper<FeedoutdetailEntity>().eq("out_no", outNo));
        if(feedoutdetailEntities!=null && feedoutdetailEntities.size()>0){
            //应付系统
            ShouldreceiveEntity shouldreceiveEntity = new ShouldreceiveEntity();
            FeedoutdetailEntity detail = feedoutdetailEntities.get(0);
            shouldreceiveEntity.setCategory(2);
            shouldreceiveEntity.setName("饲料出库应收");
            shouldreceiveEntity.setIncomePrice(detail.getUnitNum().multiply(detail.getUnitPrice()));
            shouldreceiveEntity.setTime(entity.getOutDate());
            shouldreceiveService.save(shouldreceiveEntity);
        }
        //审核通过
        entity.setPass(1);
        feedoutService.updateById(entity);
    }

    @Override
    public void saveFeedOutVo(FeedOutVo feedOut) {
        FeedoutEntity enterEntity = new FeedoutEntity();
        BeanUtils.copyProperties(feedOut,enterEntity);
        feedoutService.save(enterEntity);
        FeedoutdetailEntity detail = new FeedoutdetailEntity();
        detail.setCategory(feedOut.getCategory());
        detail.setDetailNo(feedOut.getDetailNo());
        detail.setName(feedOut.getName());
        detail.setOutNo(feedOut.getOutNo());
        detail.setSpecifications(feedOut.getSpecifications());
        detail.setUnit(feedOut.getUnit());
        detail.setUnitNum(feedOut.getUnitNum());
        detail.setUnitPrice(feedOut.getUnitPrice());
        feedoutdetailService.save(detail);
    }

    @Override
    public void updateFeedOutVoById(FeedOutVo enter) {
        FeedoutEntity entity = new FeedoutEntity();
        BeanUtils.copyProperties(enter,entity);
        feedoutService.updateById(entity);
    }

    @Override
    public void certainById(Long id) {
        FeedoutEntity entity = feedoutService.getById(id);
        entity.setCertain(1);
        feedoutService.updateById(entity);
    }

}