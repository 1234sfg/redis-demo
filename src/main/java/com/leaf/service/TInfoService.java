package com.leaf.service;

import com.github.pagehelper.Page;
import com.leaf.model.TInfo;

import java.util.List;
import java.util.Map;

public interface TInfoService {
    Integer saveTInfo(TInfo tInfo);

    List<TInfo> getTInfoList();

    Page<Map<String, Object>> getTInfoPage(Integer currPage, Integer pageSize);
}
