package com.thecabine.sample.rest;

import retrofit.RestAdapter;

/**
 * Created by admin on 10/21/15.
 */
public class RetrofitApiManager {
    private static final String BASE_URL = "http://mama-studio.com";
    private SampleApi mApi;

    public RetrofitApiManager() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        mApi = adapter.create(SampleApi.class);
    }

    public SampleApi getApi() {
        return mApi;
    }
}
