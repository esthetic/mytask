package com.thecabine.sample.rest;

import com.thecabine.sample.domain.ItemsResponse;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by admin on 10/21/15.
 */
public interface SampleApi {
    @GET("/tt/data")
    Observable<ItemsResponse> getAllItems();
}
