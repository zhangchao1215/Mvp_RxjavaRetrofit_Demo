package jiyun.com.mvp_rxjavaretrofit_demo.model.http;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/17 15:30
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface MyCallBack {
    void onSuccess(String str);

    void onError(String error);

}
