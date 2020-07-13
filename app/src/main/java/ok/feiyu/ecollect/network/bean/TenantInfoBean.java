package ok.feiyu.ecollect.network.bean;

import java.util.List;

public class TenantInfoBean {

    /**
     * success : true
     * data : [{"tenantName":"测试专用租户_EDC5","enTenantName":"test tenant eedc5","tenantId":"ceshi51","logoUrl":"http://file.test.com/resources/2c9483a8729d209e0172bbdf07123c06.PNG","enabled":true,"userProperty":"OutUser","softs":[{"softId":"edc","softName":"eCollect","softIndexUrl":"/edc/","softCode":"edc"}],"contactPerson":"","contactMobile":"","address":"","tenantType":"SPONSOR"},{"tenantName":"嘉兴太美医疗科技有限公司02_","enTenantName":"taimei tech","tenantId":"72012ed3-0a4f-45f8-ac16-f051a207895b","logoUrl":"https://test-file.trialos.com/resources/4028e85671781127017187da601e30e1.png","enabled":true,"userProperty":"CompanyUser","softs":[{"softId":"edc","softName":"eCollect","softIndexUrl":"/edc/","softCode":"edc"}],"contactPerson":"2223XG","contactMobile":"566661222","address":"上海徐汇区1111XG","tenantType":"CRO"},{"tenantName":"Intelligence Cloud Tech.","tenantId":"rock_ai_old","logoUrl":"","enabled":true,"userProperty":"TMUser","softs":[{"softId":"edc","softName":"eCollect","softIndexUrl":"/edc/","softCode":"edc"}],"contactPerson":"","contactMobile":"","address":"","tenantType":"SPONSOR"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tenantName : 测试专用租户_EDC5
         * enTenantName : test tenant eedc5
         * tenantId : ceshi51
         * logoUrl : http://file.test.com/resources/2c9483a8729d209e0172bbdf07123c06.PNG
         * enabled : true
         * userProperty : OutUser
         * softs : [{"softId":"edc","softName":"eCollect","softIndexUrl":"/edc/","softCode":"edc"}]
         * contactPerson :
         * contactMobile :
         * address :
         * tenantType : SPONSOR
         */

        private String tenantName;
        private String enTenantName;
        private String tenantId;
        private String logoUrl;
        private boolean enabled;
        private String userProperty;
        private String contactPerson;
        private String contactMobile;
        private String address;
        private String tenantType;
        private List<SoftsBean> softs;

        public String getTenantName() {
            return tenantName;
        }

        public void setTenantName(String tenantName) {
            this.tenantName = tenantName;
        }

        public String getEnTenantName() {
            return enTenantName;
        }

        public void setEnTenantName(String enTenantName) {
            this.enTenantName = enTenantName;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getUserProperty() {
            return userProperty;
        }

        public void setUserProperty(String userProperty) {
            this.userProperty = userProperty;
        }

        public String getContactPerson() {
            return contactPerson;
        }

        public void setContactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
        }

        public String getContactMobile() {
            return contactMobile;
        }

        public void setContactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTenantType() {
            return tenantType;
        }

        public void setTenantType(String tenantType) {
            this.tenantType = tenantType;
        }

        public List<SoftsBean> getSofts() {
            return softs;
        }

        public void setSofts(List<SoftsBean> softs) {
            this.softs = softs;
        }

        public static class SoftsBean {
            /**
             * softId : edc
             * softName : eCollect
             * softIndexUrl : /edc/
             * softCode : edc
             */

            private String softId;
            private String softName;
            private String softIndexUrl;
            private String softCode;

            public String getSoftId() {
                return softId;
            }

            public void setSoftId(String softId) {
                this.softId = softId;
            }

            public String getSoftName() {
                return softName;
            }

            public void setSoftName(String softName) {
                this.softName = softName;
            }

            public String getSoftIndexUrl() {
                return softIndexUrl;
            }

            public void setSoftIndexUrl(String softIndexUrl) {
                this.softIndexUrl = softIndexUrl;
            }

            public String getSoftCode() {
                return softCode;
            }

            public void setSoftCode(String softCode) {
                this.softCode = softCode;
            }
        }
    }
}
