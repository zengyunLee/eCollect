package ok.feiyu.ecollect.page.tenantList;

import java.util.List;

import ok.feiyu.ecollect.network.bean.TenantInfoBean;

public class TenantModel {
    private TenantPickPresenter presenter;
    private List <TenantInfoBean.DataBean> tenantList;

    public List<TenantInfoBean.DataBean> getTenantList() {
        return tenantList;
    }

    public void setTenantList(List<TenantInfoBean.DataBean> tenantList) {
        this.tenantList = tenantList;
    }

    TenantModel(TenantPickPresenter presenter) {
        this.presenter = presenter;
    }
}