package com.example.xia_day02;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class XiaActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mXiaTl;
    /**
     * 开始下载
     */
    private Button mXiaBt;
    private ImageView mXiaIv;
    /**
     * 已下载：
     */
    private TextView mXiaTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xia);
        initView();
    }

    private void initView() {
        mXiaTl = (Toolbar) findViewById(R.id.xia_tl);
//        mXiaTl.setTitle("我的下载");
//        setSupportActionBar(mXiaTl);
        mXiaBt = (Button) findViewById(R.id.xia_bt);
        mXiaBt.setOnClickListener(this);
        mXiaIv = (ImageView) findViewById(R.id.xia_iv);
        mXiaTv = (TextView) findViewById(R.id.xia_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xia_bt:
                toxia();
                break;
        }
    }

    private void toxia() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String s = Environment.getExternalStorageDirectory() + File.separator + "a.png";
        File file = new File(s);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody build = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "11")
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        Request build1 = new Request.Builder()
                .url("http://yun918.cn/study/public/file_upload.php")
                .post(build)
                .build();
        okHttpClient.newCall(build1)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        try {
                            JSONObject jsonObject = new JSONObject(string);
                            JSONObject data = jsonObject.getJSONObject("data");
                            final String url = data.getString("url");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Glide.with(XiaActivity.this).load(url).into(mXiaIv);
                                    mXiaTv.setText(string);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
