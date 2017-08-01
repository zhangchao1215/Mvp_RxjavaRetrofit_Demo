package jiyun.com.mvp_rxjavaretrofit_demo.model.biz;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import jiyun.com.mvp_rxjavaretrofit_demo.model.http.RetrofitUtils;
/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 16:31
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void Login(String name, String pwd, Observer observer) {
        if(name.isEmpty() && pwd.isEmpty()){
            return;
        }
        Map<String,String> params = new HashMap<>();
        params.put("username",name);
        params.put("pwd",pwd);
        params.put("keep_login","1");
        String url = "http://www.oschina.net/action/api/login_validate";
        RetrofitUtils.getInstance().Post(url,params,observer);


    }
}
