package com.ruangkita.santoso23.ruangkita;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ruangkita.santoso23.ruangkita.api.RegisterApi;
import com.ruangkita.santoso23.ruangkita.common.AppDefinition;
import com.ruangkita.santoso23.ruangkita.model.Value;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private ProgressDialog progress;
    String username, password, email, nama, jenisKelamin;

    private EditText editUsername;
    private EditText editPassword;
    private EditText editEmail;
    private EditText editNama;
    private EditText editJenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editNama = (EditText) findViewById(R.id.edit_nama);
        editJenisKelamin = (EditText) findViewById(R.id.edit_jk);


    }

    public void inisiasi(){
        username = editUsername.getText().toString();
        password = editPassword.getText().toString();
        email = editEmail.getText().toString();
        nama = editNama.getText().toString();
        jenisKelamin = editJenisKelamin.getText().toString();
    }


    public void lihatOnClick(View v){
        Intent i = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(i);

    }

    public void simpanOnClick(View v){
        //menampilakn progress dialog
        inisiasi();
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefinition.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterApi api = retrofit.create(RegisterApi.class);
        Call<Value> call = api.daftar(username, password, email, nama, jenisKelamin);

        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();

                progress.dismiss();

                if(value.equals("1")){
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "Jaringan Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
