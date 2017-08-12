package com.ruangkita.santoso23.ruangkita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ruangkita.santoso23.ruangkita.MainActivity;
import com.ruangkita.santoso23.ruangkita.R;
import com.ruangkita.santoso23.ruangkita.UpdateActivity;
import com.ruangkita.santoso23.ruangkita.model.Pengguna;

import java.util.List;

/**
 * Created by santoso on 8/11/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Pengguna> pengguna;

    public RecyclerViewAdapter(Context context, List<Pengguna> pengguna) {
        this.context = context;
        this.pengguna = pengguna;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pengguna p = pengguna.get(position);
        holder.txtUsername.setText(p.getUsername());
        holder.txtPassword.setText(p.getPassword());
        holder.txtEmail.setText(p.getEmail());
        holder.txtName.setText(p.getNama());
        holder.txtJk.setText(p.getJenisKelamin());

    }

    @Override
    public int getItemCount() {
        return pengguna.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtUsername;
        private TextView txtPassword;
        private TextView txtEmail;
        private TextView txtName;
        private TextView txtJk;


        public ViewHolder(View itemView) {
            super(itemView);


            txtUsername = (TextView) itemView.findViewById(R.id.txt_username);
            txtPassword = (TextView) itemView.findViewById(R.id.txt_password);
            txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
            txtName = (TextView) itemView.findViewById(R.id.txt_nama);
            txtJk = (TextView) itemView.findViewById(R.id.txt_jk);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            String email = txtEmail.getText().toString();
            String nama = txtName.getText().toString();
            String jk = txtJk.getText().toString();

            Intent i = new Intent(context, UpdateActivity.class);
            i.putExtra("username",username);
            i.putExtra("password",password);
            i.putExtra("email",email);
            i.putExtra("nama",nama);
            i.putExtra("jk",jk);
            context.startActivity(i);


        }
    }
}