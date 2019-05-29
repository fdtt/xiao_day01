package com.example.xia_day02.Presenter;

import com.example.xia_day02.Mode.Imode;
import com.example.xia_day02.Mode.mode;
import com.example.xia_day02.User;
import com.example.xia_day02.View.Iview;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class presenter implements  Ipresenter {
    Imode imode;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imode=new mode();
    }

    @Override
    public void wan(int page) {
        imode.wan(new Callback() {
            @Override
            public void sessend(User user) {
                iview.sessend(user);
            }
        },page);
    }
}
