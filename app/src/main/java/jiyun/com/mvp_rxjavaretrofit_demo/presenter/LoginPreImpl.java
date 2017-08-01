package jiyun.com.mvp_rxjavaretrofit_demo.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import jiyun.com.mvp_rxjavaretrofit_demo.model.biz.LoginModel;
import jiyun.com.mvp_rxjavaretrofit_demo.model.biz.LoginModelImpl;
import jiyun.com.mvp_rxjavaretrofit_demo.view.LoginView;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 16:29
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class LoginPreImpl implements LoginPresenter {
    private LoginView view;
    private LoginModel model;
       @Inject
    public LoginPreImpl(LoginView view) {
        this.view = view;
        model = new LoginModelImpl();
    }

    @Override
    public void Login(String name, String pwd) {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String responseBody) {
                    Log.d("LoginPreImpl", responseBody);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("LoginPreImpl 失败", e.getMessage());
                Log.d("LoginPreImpl", "失败了");
            }

            @Override
            public void onComplete() {

            }
        };
        model.Login(name, pwd, observer);


    }
}
