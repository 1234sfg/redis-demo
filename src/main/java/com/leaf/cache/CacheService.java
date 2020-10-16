package com.leaf.cache;


import com.leaf.model.TInfo;

import java.util.List;

public interface CacheService {


    List<TInfo> getTInfolist(String tInfos);

    void setTInfoList(String tInfos, List<TInfo> tInfoList);
}
