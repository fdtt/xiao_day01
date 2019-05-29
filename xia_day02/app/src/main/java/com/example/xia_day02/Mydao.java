package com.example.xia_day02;

import com.example.xia_day02.dao.DaoSession;
import com.example.xia_day02.dao.UserDao;

import java.util.List;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class Mydao {
    public  static  User getuser(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        User unique = daoSession.queryBuilder(User.class).where(UserDao.Properties.Desc.eq(user.getDesc())).build().unique();
        return  unique;
    }
    public  static  void insert(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        if (getuser(user)==null){
            daoSession.insert(user);
        }
    }
    public  static  void delete(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        if (getuser(user)!=null){
            daoSession.delete(user);
        }
    }
    public  static List<User> show(){
        DaoSession daoSession = Myapp.getDaoSession();
        List<User> list = daoSession.loadAll(User.class);
        return  list;
    }
}
