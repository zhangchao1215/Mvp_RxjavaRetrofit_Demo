package jiyun.com.mvp_rxjavaretrofit_demo.model.biz;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import jiyun.com.mvp_rxjavaretrofit_demo.model.http.RetrofitUtils;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/18 9:14
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NewsModelImpl implements NewsModel {
    @Override
    public void News(Observer observer) {
        Map<String, String> map = new HashMap<>();
        map.put("catalog", "1");
        map.put("pageIndex", "1");
        map.put("pageSize", "5");
        String url = "http://www.oschina.net/action/api/news_list";
        RetrofitUtils.getInstance().Get(url, map, observer);

    }
}
