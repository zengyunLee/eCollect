package ok.feiyu.ecollect;

public class LoginModel implements ILoginModel{

    public  String userName = "";
    public  String pwd = "";

    public LoginModel() {

    }

    @Override
    public void onLogin() {

    }

    @Override
    public void onSendMail() {

    }

    @Override
    public void onUserNameChange(String username) {
        this.userName = userName;
    }

    @Override
    public void onPwdChange(String pwd) {
        this.pwd = pwd;
    }
}
