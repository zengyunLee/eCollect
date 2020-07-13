package ok.feiyu.ecollect.page.tenantList;

import java.util.HashMap;
import java.util.List;

import ok.feiyu.ecollect.BasePresenter;
import ok.feiyu.ecollect.network.HttpReqManager;
import ok.feiyu.ecollect.network.bean.TenantInfoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TenantPickPresenter extends BasePresenter<TenantPickActivity> implements CommonList<TenantInfoBean> {

    TenantModel mTenantModel ;

    TenantPickPresenter(TenantModel model) {
        mTenantModel = model;
    }

    @Override
    public void onItemPick(TenantInfoBean bean) {

    }

    @Override
    public void loadData() {
        TenantPickActivity tenantPickActivity = (TenantPickActivity) weakReference.get();
        tenantPickActivity.showLoadingView("加载中");
        final HashMap reqMap = new HashMap<String,String>();
        reqMap.put("roleType","ecollect_app_role");
        HttpReqManager.getInstance().listTenantByRoleType(reqMap).enqueue(new Callback<TenantInfoBean>() {
            @Override
            public void onResponse(Call<TenantInfoBean> call, Response<TenantInfoBean> response) {
                TenantInfoBean bean = response.body();
                mTenantModel.setTenantList(bean.getData());
                onLoadComplete();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                onLoadComplete();
            }
        });
    }

    @Override
    public void onLoadComplete() {
        TenantPickActivity tenantPickActivity = (TenantPickActivity) weakReference.get();
        tenantPickActivity.onDataLoadSuccess();
        tenantPickActivity.hiddenLoadingView();
    }

    public List<TenantInfoBean.DataBean> getTenantList() {
        return mTenantModel.getTenantList();
    }
}
