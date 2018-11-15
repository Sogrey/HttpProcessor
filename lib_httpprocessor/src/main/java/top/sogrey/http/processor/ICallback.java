package top.sogrey.http.processor;

/**
 * 描述：通用回调接口
 * Created by Sogrey on 2018/11/14.
 */

public interface ICallback {
    /**
     * 成功
     * @param result 访问网络结果
     */
    void onSuccess(String result);

    /**
     * 失败
     * @param error 失败信息
     */
    void onFailure(String error);
}
