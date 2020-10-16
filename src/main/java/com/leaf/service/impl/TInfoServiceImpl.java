package com.leaf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leaf.cache.CacheService;
import com.leaf.mapper.TInfoMapper;
import com.leaf.model.TInfo;
import com.leaf.service.TInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TInfoServiceImpl implements TInfoService {
    @Autowired
    private TInfoMapper tInfoMapper;

    @Autowired
    private CacheService cacheService;

    @Override
    public Integer saveTInfo(TInfo tInfo) {
        Integer count = tInfoMapper.saveTInfo(tInfo);
        return count;
    }

    @Override
    public  List<TInfo> getTInfoList()  {
        String tInfos = "tInfos";
        List<TInfo> tInfoList = cacheService.getTInfolist(tInfos);
        if(tInfoList != null){
            return tInfoList;
        }
        else{
            tInfoList = tInfoMapper.getTInfoList();
            if (tInfoList != null){
                cacheService.setTInfoList(tInfos,tInfoList);
                return tInfoList;
            }else{
                System.out.println("並沒有查到任何東西");
                return null;}
        }
    }


    @Override
    public Page<Map<String, Object>> getTInfoPage(Integer currPage, Integer pageSize) {
        PageHelper.startPage(currPage,pageSize);
        Page<Map<String,Object>> page = tInfoMapper.getTInfoPage();
        return page;
    }


}
