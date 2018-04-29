package com.epi.epichallenge.api;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import okhttp3.OkHttpClient;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;
public class RetroClient
{
    /********
     * URLS
     *******/
    public static final String ROOT_URL = "http://192.168.137.224:8080/";

    /**
     * Get Retrofit Instance
     */
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static OkHttpClient client = new OkHttpClient();
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}