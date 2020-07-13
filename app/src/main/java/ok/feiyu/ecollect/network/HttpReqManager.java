package ok.feiyu.ecollect.network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpReqManager {
    private static volatile apiInterface mHttpUtils = null;
    public static HashMap<String,String> customHeaders;

    static {
        customHeaders = new HashMap();
        customHeaders.put("tm-header-date-origin",Constant.EDCORIGIN);
    }

    public static apiInterface getInstance() {
        if(mHttpUtils == null) {
            synchronized (HttpReqManager.class) {
                if(mHttpUtils == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://trialos.test.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(getCustomClient())
                            .build();
                    mHttpUtils = retrofit.create(apiInterface.class);
                }
            }
        }
        return mHttpUtils;
    }

    private static OkHttpClient getCustomClient() {
        return new OkHttpClient.Builder().addInterceptor(getInterceptor()).build();
    }

    private static Interceptor getInterceptor () {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                if(customHeaders.size() > 0) {
                    for (Map.Entry<String, String> entry : customHeaders.entrySet()) {
                        builder.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                return chain.proceed(builder.build());
            }
        };
    }

}
