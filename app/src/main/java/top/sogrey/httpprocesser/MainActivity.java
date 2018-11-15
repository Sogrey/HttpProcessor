package top.sogrey.httpprocesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import top.sogrey.httpprocesser.bean.BaseData;
import top.sogrey.httpprocesser.httpprocessor.HttpCallback;
import top.sogrey.httpprocesser.httpprocessor.HttpHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
//        http://api.map.baidu.com/geocoder/v2/?address=%E8%A5%BF%E5%AE%89%E5%B8%82&output=json
// &mcode=70:FE:DF:8B:20:BA:98:2F:21:1B:67:06:F4:3D:62:B5:7A:A5:80:AD;com.baidu.baidulocationdemo&ak=pVTtPBAsLq38z4Mm77azNU7G


        Map<String, Object> params = new HashMap<>();
        params.put("address", "西安");
        params.put("output", "json");
        params.put("mcode", "70:FE:DF:8B:20:BA:98:2F:21:1B:67:06:F4:3D:62:B5:7A:A5:80:AD;com.baidu.baidulocationdemo");
        params.put("ak", "pVTtPBAsLq38z4Mm77azNU7G");
        HttpHelper.obtain().post("http://api.map.baidu.com/geocoder/v2/",
                params, new HttpCallback<BaseData>() {
                    @Override
                    protected void onSuccess(BaseData objResult) {
                        Toast.makeText(MainActivity.this,objResult.getStatus()+"",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
