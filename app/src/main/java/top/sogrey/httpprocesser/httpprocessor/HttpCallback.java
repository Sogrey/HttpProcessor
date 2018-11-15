package top.sogrey.httpprocesser.httpprocessor;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 描述：网络回调接口的实现
 *
 * 1.得到Result
 * 2.用于把网络层传输的的String转换成调用层传入的参数化类型 Result
 *
 * Created by Sogrey on 2018/11/14.
 */

public abstract class HttpCallback<Result> implements ICallback {
    @SuppressWarnings("unchecked")
    @Override
    public void onSuccess(String result) {
        Log.e("xxx",result);
        Gson gson = new Gson();

        Class<?> clazz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result, clazz);

        //传回调用者
        onSuccess(objResult);
    }

    protected abstract void onSuccess(Result objResult);

    private static Class<?> analysisClassInfo(Object object) {
        //getGenericSuperclass 可以得到包含原始类型，参数化类型，数组类型，自定义类，基本数据类型
        Type genType = object.getClass().getGenericSuperclass();
        //获取参数化类型
        Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) types[0];
    }

    @Override
    public void onFailure(String error) {

    }
}
