package ok.feiyu.ecollect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import ok.feiyu.ecollect.network.HttpReqManager;
import ok.feiyu.ecollect.page.tenantList.TenantPickActivity;

public class MainActivity extends AppCompatActivity implements ILoginView , View.OnClickListener {
    private ProgressDialog progressDialog;

    private Button mLoginBtn;
    private EditText mUsername;
    private EditText mPwd;
    private LoginPresenter mPresenter;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(this);
        setContentView(R.layout.activity_main);
        mLoginBtn = findViewById(R.id.login_loginBtn);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.WHITE);
        mLoginBtn.setOnClickListener(this);
        mUsername = findViewById(R.id.login_userName);
        mUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.onUserNameChange(mUsername.getText().toString());
            }
        });
        mPwd = findViewById(R.id.login_pwd);
        mPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.onPwdChange(mPwd.getText().toString());
            }
        });
        saveVersionName();
    }

    private void saveVersionName() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            HttpReqManager.customHeaders.put("tm-header-version-code",version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Aaron","onResume");
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getApplicationContext(), TenantPickActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_loginBtn:
                mPresenter.onLogin();
        }
    }

    @Override
    public void showLoadingView(String text) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(text);    //设置内容
        progressDialog.setCancelable(false);//点击屏幕和按返回键都不能取消加载框
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 60 * 000);

    }

    @Override
    public void hiddenLoadingView() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onForgetPwd() {

    }
}
