package jiyun.com.mvp_rxjavaretrofit_demo.model.http;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 15:06
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface RetrofitInter {

    @GET
    Observable<ResponseBody> mGetRetrofit(@Url String url, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> mPostRetrofit(@Url String url,@FieldMap Map<String,String> map);

}
