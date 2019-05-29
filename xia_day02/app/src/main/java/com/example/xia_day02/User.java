package com.example.xia_day02;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 只想暴富 on 2019/5/28.
 */
@Entity
public class User  {
    @Id
    private Long id;
    private String desc;
    private String url;
    private String link;
    @Generated(hash = 1511170050)
    public User(Long id, String desc, String url, String link) {
        this.id = id;
        this.desc = desc;
        this.url = url;
        this.link = link;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    
}
