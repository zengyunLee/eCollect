package ok.feiyu.ecollect;

import ok.feiyu.ecollect.network.bean.LoginBean;

public class LoginModel {
    private LoginPresenter mPresenter;
    private String userName = "";
    private String pwd = "";
    private String mailAddress = "";
    private LoginBean loginBean = null;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LoginModel(LoginPresenter lp) {
        mPresenter = lp;
    }

}
