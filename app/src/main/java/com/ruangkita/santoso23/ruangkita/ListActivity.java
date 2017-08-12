package com.ruangkita.santoso23.ruangkita;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ruangkita.santoso23.ruangkita.adapter.RecyclerViewAdapter;
import com.ruangkita.santoso23.ruangkita.api.RegisterApi;
import com.ruangkita.santoso23.ruangkita.common.AppDefinition;
import com.ruangkita.santoso23.ruangkita.model.Pengguna;
import com.ruangkita.santoso23.ruangkita.model.Value;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.id;


public class ListActivity extends AppCompatActivity{


    private List<Pengguna> pengguna = new ArrayList<>();
    private RecyclerViewAdapter viewAdapter;


    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);


        viewAdapter = new RecyclerViewAdapter(this, pengguna);
        RecyclerView.LayoutManager aLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(aLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataMahasiswa();
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadDataMahasiswa();
    }

    private void loadDataMahasiswa(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefinition.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterApi api = retrofit.create(RegisterApi.class);
        Call<Value> call = api.view();

        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                if(value.equals("1")){
                    pengguna = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(ListActivity.this, pengguna);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }

}
