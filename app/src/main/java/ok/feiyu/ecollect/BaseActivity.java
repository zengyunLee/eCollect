package ok.feiyu.ecollect;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * BaseActivty：封装Presenter的绑定与解绑方法，减少相同冗余代码
 * @param <V> View界面
 * @param <P> Presenter
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {
    private P presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attach((V) this);
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.WHITE);
    }

    public BasePresenter<V> getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null) {
            presenter.detach();
            presenter = null;
        }
    }

    public void showLoadingView(String text) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(text);    //设置内容
        progressDialog.setCancelable(false);//点击屏幕和按返回键都不能取消加载框
        progressDialog.show();

    }

    public void hiddenLoadingView() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /**
     * 创建继承于BasePresenter的子类
     * @return
     */
    protected abstract P createPresenter();
}
