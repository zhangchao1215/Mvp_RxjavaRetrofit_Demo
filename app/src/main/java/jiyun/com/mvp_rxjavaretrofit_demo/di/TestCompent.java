package jiyun.com.mvp_rxjavaretrofit_demo.di;

import dagger.Component;
import jiyun.com.mvp_rxjavaretrofit_demo.MainActivity;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 17:16
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */
@Component(modules = TestModule.class)
public interface TestCompent {

    void injust(MainActivity activity);

}
