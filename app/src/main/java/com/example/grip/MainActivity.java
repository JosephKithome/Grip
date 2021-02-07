package com.example.grip;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.grip.Api.ApiClient;
import com.example.grip.Api.ApiInterface;
import com.example.grip.models.CountryData;
import com.example.grip.models.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private List<CountryData> countryDataList = new ArrayList<>();
    private  int page_number =1;
    private  int limit = 10;
    private ApiInterface apiInterface;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: oncreate called");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.loadingProgress);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        progressBar.setVisibility(View.VISIBLE);
        Call<List<CountryData>> call = apiInterface.getCountryData(page_number,limit);
        call.enqueue(new Callback<List<CountryData>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {

                Log.d(TAG, "onResponse:"+ response.body());
                if (response.body() != null){
                    response.body().forEach(countryData -> {
                        countryDataList.add(countryData);
                    });
                    recyclerAdapter = new RecyclerAdapter(countryDataList,MainActivity.this);
                    recyclerView.setAdapter(recyclerAdapter);
                    recyclerAdapter.setCountryDataList(countryDataList);
                    progressBar.setVisibility(View.GONE);
                }else{
                    Log.d(TAG, "onResponse: Error loading data");
                }
               
            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {

            }
        });




    }
}