package ok.feiyu.ecollect;

public interface ILoginPresenter {
    void onLogin();
    void onLoginSuccess();
    void onSendMail();
    void onUserNameChange(String username);
    void onPwdChange(String pwd);
}