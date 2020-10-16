package com.leaf.cache.impl;


import com.leaf.cache.CacheService;
import com.leaf.model.TInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {


    @Override
    public List<TInfo> getTInfolist(String tInfos) {
        return null;
    }

    @Override
    public void setTInfoList(String tInfos, List<TInfo> tInfoList) {

    }
}
