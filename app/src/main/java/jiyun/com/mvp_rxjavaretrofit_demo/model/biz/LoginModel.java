package jiyun.com.mvp_rxjavaretrofit_demo.model.biz;

import io.reactivex.Observer;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 16:31
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface LoginModel {
    void Login(String name, String pwd,Observer observer);
}
