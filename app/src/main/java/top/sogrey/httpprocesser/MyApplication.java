package top.sogrey.httpprocesser;

import android.app.Application;

import top.sogrey.httpprocesser.httpprocessor.HttpHelper;
import top.sogrey.httpprocesser.httpprocessor.VolleyProcessor;
import top.sogrey.httpprocesser.httpprocessor.XUtilsProcessor;

/**
 * 描述：
 * Created by Sogrey on 2018/11/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VolleyProcessor(this));
//        HttpHelper.init(new XUtilsProcessor(this));
    }
}
