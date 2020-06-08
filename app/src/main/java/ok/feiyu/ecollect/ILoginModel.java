package ok.feiyu.ecollect;

public interface ILoginModel {
    void onLogin();
    void onSendMail();
    void onUserNameChange(String username);
    void onPwdChange(String pwd);
}