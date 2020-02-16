package com.ydgk.ssm.controller;

import com.ydgk.ssm.entities.Infomation;
import com.ydgk.ssm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @create 2020-02-13 15:57
 */
@Controller
public class ToInfoController {

    @Autowired
    private InfoService infoService;

    //用于信息提示自动加载信息
    @RequestMapping("/toInfo")
    public String toInfo(Map<String, Object> map){
        List<Infomation> infomation = infoService.getInfomation();
        map.put("infomations",infomation);
        return  "main/info";
    }



}
