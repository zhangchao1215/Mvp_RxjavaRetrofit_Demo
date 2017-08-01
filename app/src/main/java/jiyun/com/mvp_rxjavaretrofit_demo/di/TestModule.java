package jiyun.com.mvp_rxjavaretrofit_demo.di;

import dagger.Module;
import dagger.Provides;
import jiyun.com.mvp_rxjavaretrofit_demo.view.LoginView;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 17:17
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */
@Module
public class TestModule {
    private LoginView loginView;

    public TestModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    LoginView mview() {
        return loginView;
    }
}
