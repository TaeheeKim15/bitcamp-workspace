package com.eomcs.pms.domain;

import java.sql.Date;

// 데이터 타입 역할을 하는 애는 도메인 밑에 둔다

  public class Member {
     public int no;
    public String name;
    public String email;
    public String password;
    public String photo;
    public String tel;
    public Date registeredDate;
  }
