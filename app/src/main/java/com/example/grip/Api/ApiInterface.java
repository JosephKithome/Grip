package com.example.grip.Api;

import com.example.grip.models.CountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("asia")

    Call<List<CountryData>> getCountryData(@Query("page_number") int page , @Query("item_count") int limit);
}
