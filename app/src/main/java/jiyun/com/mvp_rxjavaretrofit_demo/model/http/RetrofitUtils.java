package jiyun.com.mvp_rxjavaretrofit_demo.model.http;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.mvp_rxjavaretrofit_demo.model.callback.HttpCallback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 14:18
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class RetrofitUtils implements HttpCallback {
    private Retrofit mRetrofit;
    private final RetrofitInter retrofitInter;

    private RetrofitUtils() {
        mRetrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInter = mRetrofit.create(RetrofitInter.class);
    }

    //添加okhttp拦截器
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);//拦截器实现的关键部分
            return proceed;
        }
    }).connectTimeout(1000, TimeUnit.SECONDS)
            .writeTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS)
            .build();

    private static RetrofitUtils mRetrofitUtils;

    //对retrofit进行单例化
    public static synchronized RetrofitUtils getInstance() {
        if (mRetrofitUtils == null) {
            mRetrofitUtils = new RetrofitUtils();
        }
        return mRetrofitUtils;
    }


    @Override
    public void Post(String url, Map<String, String> map, Observer observer) {

        Observable<ResponseBody> observable = retrofitInter.mPostRetrofit(url, map);
        observable.map(new Function<ResponseBody, String>() {
            @Override
            public String apply(@NonNull ResponseBody responseBody) throws Exception {
                String string = responseBody.string();

                return string;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    @Override
    public void Get(String url, Map<String, String> map, Observer observer) {

        Observable<ResponseBody> observable = retrofitInter.mGetRetrofit(url, map);
        observable.map(new Function<ResponseBody, String>() {
            @Override
            public String apply(@NonNull ResponseBody responseBody) throws Exception {
                String string = responseBody.string();

                return string;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void OkPost(String url, Map<String, String> map, MyCallBack callBack) {

    }

    @Override
    public void OkGet(String url, Map<String, String> map, MyCallBack callBack) {

    }


    public class TokenHeaderInterceptor implements Interceptor {

        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long longt1 = System.nanoTime();
            System.out.println(String.format("发送请求: [%s] %s%n%s",
                    request.url(), chain.connection()));

            Response response = chain.proceed(request);

            long longt2 = System.nanoTime();
            System.out.println(String.format("接收响应: [%s] %.1fms%n%s",
                    response.request().url()));

            return response;
        }
    }

}
