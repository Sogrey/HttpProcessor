package top.sogrey.httpprocesser.httpprocessor;

import android.app.Application;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

import top.sogrey.http.processor.ICallback;
import top.sogrey.http.processor.IHttpProcessor;

/**
 * 描述：xutils
 * Created by Sogrey on 2018/11/15.
 */

public class XUtilsProcessor implements IHttpProcessor {
    public XUtilsProcessor(Application app) {
        x.Ext.init(app);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onFailure(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {

    }
}
