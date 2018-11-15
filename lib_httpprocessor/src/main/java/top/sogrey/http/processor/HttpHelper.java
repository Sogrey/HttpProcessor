package top.sogrey.http.processor;

import android.util.Log;

import java.util.Map;

/**
 * 描述：http代理类
 * Created by Sogrey on 2018/11/15.
 */

public class HttpHelper implements IHttpProcessor {
    private static IHttpProcessor mIHttpProcessor;

    public static void init(IHttpProcessor iHttpProcessor) {
        mIHttpProcessor = iHttpProcessor;
    }

    private static HttpHelper instance;

    private HttpHelper() {
    }

    //单例
    public static HttpHelper obtain() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        mIHttpProcessor.post(appendParams(url, params), params, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        mIHttpProcessor.get(appendParams(url, params), params, callback);
    }

    public static String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) return url;
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlBuilder.indexOf("?") <= 0) {
            urlBuilder.append("?");
        } else {
            if (!urlBuilder.toString().endsWith("?")) urlBuilder.append("&");
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            urlBuilder.append("&" + entry.getKey()).append("=").append(encode(entry.getValue().toString()));
        }
        Log.e("XXX",urlBuilder.toString());
        return urlBuilder.toString();
    }

    private static String encode(String value) {
        return value;
//        try {
//            return URLEncoder.encode(value, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
    }
}
