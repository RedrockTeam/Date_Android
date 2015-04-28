package com.mredrock.date.model;

import com.mredrock.date.model.bean.PersonBrief;

/**
 * Created by Mr.Jude on 2015/4/28.
 */
public class PersonModel {
      public PersonBrief getUserPersonBrief(){
          PersonBrief user = new PersonBrief("http://tb.himg.baidu.com/sys/portrait/item/29d3d3c0df68c8e7b8e8a65f?t=1425151195","Jude95","大王叫我来巡山");
          return user;
      }

}
