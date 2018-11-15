package top.sogrey.http.processor;

import android.util.Log;

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

        Class<?> clazz = analysisClassInfo(this);

//        Gson gson = new Gson();
//        Result objResult = (Result) gson.fromJson(result, clazz);

        //String -> Object
        Result objResult = analysis(result, clazz);

        //传回调用者
        onSuccess(objResult);
    }

    /**
     * 失败
     *
     * @param error 失败信息
     */
    @Override
    public void onFailure(String error) {
    }

    protected Result analysis(String result, Class<?> clazz){
        throw new RuntimeException("\n请添加你的HttpCallback继承自top.sogrey.http.processor.HttpCallback,\n" +
                "并复写analysis(result,clazz)方法实现你自己的数据解析，\n" +
                "比如用Gson解析json:\n" +
                "══╡ JAVA CODE ╞════════════════════\n"+
                "public abstract class MyHttpCallback<Result> extends HttpCallback<Result> {\n" +
                "    @Override\n" +
                "    protected Result analysis(String result, Class<?> clazz) {\n" +
                "        Gson gson = new Gson();\n" +
                "        Result objResult = (Result) gson.fromJson(result, clazz);\n" +
                "        return objResult;\n" +
                "    }\n" +
                "}\n"+
                "═══════════════════════════════════"
        );
    }

    protected abstract void onSuccess(Result objResult);

    private static Class<?> analysisClassInfo(Object object) {
        //getGenericSuperclass 可以得到包含原始类型，参数化类型，数组类型，自定义类，基本数据类型
        Type genType = object.getClass().getGenericSuperclass();
        //获取参数化类型
        Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) types[0];
    }
}
