package jiyun.com.mvp_rxjavaretrofit_demo.model.utils;

import com.google.gson.Gson;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/15 15:37
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class GsonUtils {
    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    public static <T> T GsonBean(String str, Class<T> clazz) {
        T t = null;

        if (gson != null) {
            t = gson.fromJson(str, clazz);
        }
        return t;

    }


}
