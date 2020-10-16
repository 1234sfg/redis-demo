package com.leaf.controller;

import com.leaf.model.TInfo;
import com.leaf.service.TInfoService;
import com.leaf.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

@RestController
public class TInfoController {
    @Autowired
    private TInfoService tInfoService;

//    @Autowired
//    private RedisTemplate redisTemplate;

    //    增post
    @PostMapping("saveTInfo")
    public String saveTInfo(@RequestBody TInfo tInfo) {
        Integer count = tInfoService.saveTInfo(tInfo);
        return count.toString();
    }
    //    删delete

    //    改put

    //    查get
    @GetMapping("getTInfoList")
    public Result getTInfoList () {
        //获取redis中key="userJSON"的value
        List<TInfo> tInfoList= tInfoService.getTInfoList();
        return new Result(200,tInfoList);
    }







     @GetMapping("/getTInfoPage")
        public Page<Map<String, Object>> getTInfoPage (@RequestParam(defaultValue = "1") Integer currPage,
                                                        @RequestParam(defaultValue = "5") Integer pageSize){
            Page<Map<String, Object>> page = tInfoService.getTInfoPage(currPage, pageSize);
            return page;
        }

    }
