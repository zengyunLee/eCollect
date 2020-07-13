package ok.feiyu.ecollect.network;

import java.util.HashMap;
import java.util.Map;

import ok.feiyu.ecollect.network.bean.LoginBean;
import ok.feiyu.ecollect.network.bean.TenantInfoBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface apiInterface {

    @POST("sso/sso/doLogin")
    Call<LoginBean> login(@Body Map<String,Object> params);

    @GET("api/csp-service/trialos/listTenantByRoleType")
    Call<TenantInfoBean> listTenantByRoleType(@QueryMap HashMap<String,String > params);
}