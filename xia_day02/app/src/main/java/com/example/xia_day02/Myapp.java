package com.example.xia_day02;

import android.app.Application;

import com.example.xia_day02.dao.DaoMaster;
import com.example.xia_day02.dao.DaoSession;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class Myapp extends Application {

    private static  DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "pp.dp");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public static  DaoSession getDaoSession(){
        return  daoSession;
    }
}
