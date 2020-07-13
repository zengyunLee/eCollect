package ok.feiyu.ecollect;

public interface ILoginView {
    void showLoadingView( String text);
    void hiddenLoadingView();
    void onForgetPwd();
    void onLoginSuccess();
}