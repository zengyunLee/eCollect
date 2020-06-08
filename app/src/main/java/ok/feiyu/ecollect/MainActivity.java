package ok.feiyu.ecollect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ILoginView , View.OnClickListener {

    private Button mLoginBtn;
    private EditText mUsername;
    private EditText mPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginBtn = findViewById(R.id.login_loginBtn);
        mUsername = findViewById(R.id.login_userName);
        mPwd = findViewById(R.id.login_pwd);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hiddenLoadingView() {

    }

    @Override
    public void onForgetPwd() {

    }
}
