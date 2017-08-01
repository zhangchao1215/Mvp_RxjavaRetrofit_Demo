package jiyun.com.mvp_rxjavaretrofit_demo.model.callback;

import java.util.Map;

import io.reactivex.Observer;
import jiyun.com.mvp_rxjavaretrofit_demo.model.http.MyCallBack;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 14:19
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface HttpCallback {
    void Post(String url, Map<String, String> map, Observer observer);

    void Get(String url, Map<String, String> map, Observer observer);


    void OkPost(String url, Map<String, String> map, MyCallBack callBack);

    void OkGet(String url, Map<String, String> map, MyCallBack callBack);

}
