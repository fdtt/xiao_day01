package com.example.xia_day02.Mode;

import com.example.xia_day02.Presenter.Callback;
import com.example.xia_day02.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 只想暴富 on 2019/5/28.
 */

public class mode implements Imode {
    @Override
    public void wan(final Callback callback, int page) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url(" http://www.wanandroid.com/article/list/" + page + "/json")
                .build();
        okHttpClient.newCall(build).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONArray datas = data.getJSONArray("datas");
                    for (int i = 0; i <datas.length() ; i++) {
                        JSONObject jsonObject1 = datas.getJSONObject(i);
                        String desc = jsonObject1.getString("desc");
                        String link = jsonObject1.getString("link");
                        String envelopePic = jsonObject1.getString("envelopePic");
                        User user = new User();
                        user.setDesc(desc);
                        user.setLink(link);
                        user.setUrl(envelopePic);
                        callback.sessend(user);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
