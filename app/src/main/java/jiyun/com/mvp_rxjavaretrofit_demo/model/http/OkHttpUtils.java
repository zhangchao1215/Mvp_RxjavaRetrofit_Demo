package jiyun.com.mvp_rxjavaretrofit_demo.model.http;

import java.util.Map;
import java.util.Set;

import io.reactivex.Observer;
import jiyun.com.mvp_rxjavaretrofit_demo.model.callback.HttpCallback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/17 15:32
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class OkHttpUtils implements HttpCallback {

    private OkHttpUtils() {
    }

    public OkHttpUtils okHttpUtils = new OkHttpUtils();

    public OkHttpUtils getInstance() {
        return okHttpUtils;
    }


    @Override
    public void Post(String url, Map<String, String> map, Observer observer) {

    }

    @Override
    public void Get(String url, Map<String, String> map, Observer observer) {

    }


    //这是OkHttp网络请求
    @Override
    public void OkPost(String url, Map<String, String> map, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        FormBody.Builder builder = new FormBody.Builder();



        if (map != null && map.size() > 0) {
            Set<String> keySet = map.keySet();

            for (String key : keySet) {

                String value = map.get(key);
                builder.add(key, value);

            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(builder.build())
                    .build();

        }


    }


    @Override
    public void OkGet(String url, Map<String, String> map, MyCallBack callBack) {

    }
}
