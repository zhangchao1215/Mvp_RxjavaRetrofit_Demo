package jiyun.com.mvp_rxjavaretrofit_demo.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import jiyun.com.mvp_rxjavaretrofit_demo.model.biz.NewsModel;
import jiyun.com.mvp_rxjavaretrofit_demo.model.biz.NewsModelImpl;
import jiyun.com.mvp_rxjavaretrofit_demo.view.NewsView;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/18 9:17
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NewsPresenterImpl implements NewsPresenter {
    private NewsModel model;
    private NewsView view;

    public NewsPresenterImpl(NewsView view) {
        this.view = view;
        model = new NewsModelImpl();
    }

    @Override
    public void News() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String responseBody) {
                Log.d("NewsPresenterImpl", responseBody);
                view.TooastMsg("成功");
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("NewsPresenterImpl", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        model.News(observer);


    }
}
