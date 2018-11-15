package top.sogrey.httpprocesser.httpprocessor;

import com.google.gson.Gson;

import top.sogrey.http.processor.HttpCallback;

/**
 * 描述：
 * Created by Sogrey on 2018/11/15.
 */

public abstract class MyHttpCallback<Result> extends HttpCallback<Result> {
    @Override
    protected Result analysis(String result, Class<?> clazz) {
        Gson gson = new Gson();
        Result objResult = (Result) gson.fromJson(result, clazz);
        return objResult;
    }
}
