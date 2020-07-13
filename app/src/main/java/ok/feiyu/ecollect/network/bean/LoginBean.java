package ok.feiyu.ecollect.network.bean;

public class LoginBean {

    /**
     * success : true
     * data : {"token":"4e36a9d39dd54253884f175c74459562","tokenDomain":"test.com","accountId":"ff8080816284a408016284a408c70000","firstLogin":false,"expired":false}
     */

    private Boolean success;
    private DataBean data;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : 4e36a9d39dd54253884f175c74459562
         * tokenDomain : test.com
         * accountId : ff8080816284a408016284a408c70000
         * firstLogin : false
         * expired : false
         */

        private String token;
        private String tokenDomain;
        private String accountId;
        private Boolean firstLogin;
        private Boolean expired;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenDomain() {
            return tokenDomain;
        }

        public void setTokenDomain(String tokenDomain) {
            this.tokenDomain = tokenDomain;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Boolean isFirstLogin() {
            return firstLogin;
        }

        public void setFirstLogin(Boolean firstLogin) {
            this.firstLogin = firstLogin;
        }

        public Boolean isExpired() {
            return expired;
        }

        public void setExpired(Boolean expired) {
            this.expired = expired;
        }
    }
}
