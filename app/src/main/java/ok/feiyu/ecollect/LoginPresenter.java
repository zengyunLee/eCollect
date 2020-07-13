package ok.feiyu.ecollect;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ok.feiyu.ecollect.network.HttpReqManager;
import ok.feiyu.ecollect.network.apiInterface;
import ok.feiyu.ecollect.network.bean.LoginBean;
import ok.feiyu.ecollect.utils.Md5Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILoginPresenter {

    private static final String TAG = "LoginModel";
    private MainActivity loginActivity ;
    private LoginModel model;
    public LoginPresenter(MainActivity activity) {
        loginActivity = activity;
        this.model = new LoginModel(this);
    }

    @Override
    public void onUserNameChange(String username) {
        model.setUserName(username);
    }

    @Override
    public void onPwdChange(String pwd) {
        model.setPwd(pwd);
    }

    @Override
    public void onLogin() {
        loginActivity.showLoadingView("登录中...");
        final apiInterface mApi = HttpReqManager.getInstance();
        final Map reqMap = new HashMap<>();
        reqMap.put("accountName",model.getUserName());
        reqMap.put("accountPswd", Md5Utils.md5Decode(model.getPwd()));
        reqMap.put("device","deviceId");
        reqMap.put("platform","mobile");
        reqMap.put("system","edc");
        reqMap.put("needHttpOnly",true);
        mApi.login(reqMap).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                loginActivity.hiddenLoadingView();
                LoginBean res = response.body();
                model.setLoginBean(res);
                HttpReqManager.customHeaders.put("cookie","token=" + res.getData().getToken());
                loginActivity.onLoginSuccess();
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t);
                loginActivity.hiddenLoadingView();
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        loginActivity.hiddenLoadingView();
    }

    @Override
    public void onSendMail() {

    }
}
