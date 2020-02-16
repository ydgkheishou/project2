package com.ydgk.ssm.service;

import com.ydgk.ssm.entities.Infomation;
import com.ydgk.ssm.entities.InfomationExample;
import com.ydgk.ssm.mappers.InfomationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author asus
 * @create 2020-02-13 16:25
 */
@Service
public class InfoService {

    @Autowired
    private InfomationMapper infomationMapper;

    public List<Infomation> getInfomation(){
        InfomationExample infomationExample = new InfomationExample();
        InfomationExample.Criteria criteria = infomationExample.createCriteria();
        criteria.andTextIsNotNull();
        List<Infomation> infomations = infomationMapper.selectByExample(infomationExample);
        return infomations;
    }

    public void addInfo(String text) {
        Infomation infomation=new Infomation();
        infomation.setText(text);
        infomation.setTime(new Date());
        infomationMapper.insert(infomation);
    }

    public void deleteInfo(Integer nid) {
        infomationMapper.deleteByPrimaryKey(nid);
    }
}
