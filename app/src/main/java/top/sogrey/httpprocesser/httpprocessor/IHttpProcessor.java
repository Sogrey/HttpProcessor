package top.sogrey.httpprocesser.httpprocessor;

import java.util.Map;

/**
 * 描述：网络抽象层接口
 * Created by Sogrey on 2018/11/15.
 */

public interface IHttpProcessor {
    void post(String url, Map<String,Object> params,ICallback callback);
    void get(String url, Map<String,Object> params,ICallback callback);
}
