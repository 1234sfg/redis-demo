package com.leaf;

import com.leaf.cache.CacheService;
import com.leaf.mapper.TInfoMapper;
import com.leaf.model.TInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Demo {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private TInfoMapper tInfoMapper;
    @Test
    public List<TInfo> getTInfoList()  {
        List<TInfo> tInfoList = cacheService.getTInfolist("tInfos");

        if(tInfoList != null){

            return tInfoList;
        }
        else{
            tInfoList = tInfoMapper.getTInfoList();
            if (tInfoList != null){
                cacheService.setTInfoList("tInfos",tInfoList);
                return tInfoList;
            }else{
                System.out.println("並沒有查到任何東西");
                return null;}
        }
    }
}
