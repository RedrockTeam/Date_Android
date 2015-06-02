package com.mredrock.date.model;

import com.mredrock.date.model.bean.PersonBrief;
import com.mredrock.date.model.bean.PersonInformatin;

/**
 * Created by Mr.Jude on 2015/4/28.
 */
public class PersonModel {
      public PersonBrief getUserPersonBrief(){
          PersonBrief user = new PersonBrief("http://tb.himg.baidu.com/sys/portrait/item/29d3d3c0df68c8e7b8e8a65f?t=1425151195","Jude95","大王叫我来巡山",0);
          return user;
      }
    public PersonInformatin getUserPersonInformation(){
        PersonInformatin personInfo=  new PersonInformatin("http://tb.himg.baidu.com/sys/portrait/item/29d3d3c0df68c8e7b8e8a65f?t=1425151195","Jude95","大王叫我来巡山",2013,"计算机科学与技术学院","18884814323","234234234","zsaaasdad");
        return  personInfo;
    }
}
