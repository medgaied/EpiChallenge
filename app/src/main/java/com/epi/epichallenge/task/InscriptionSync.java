package com.epi.epichallenge.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.epi.epichallenge.api.ApiService;
import com.epi.epichallenge.api.RetroClient;
import com.epi.epichallenge.converter.UserConverter;
import com.epi.epichallenge.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class InscriptionSync extends AsyncTask<String, String, Void> {

    private Context context;
    public InscriptionSync(Context context) {
        this.context = context;

    }
    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }
    @Override
    protected Void doInBackground(String... params) {
        User user=new User();
        user.setLastName(params[0]);
        user.setFirstName(params[1]);
        user.setUsername(params[2]);
        user.setPassword(params[3]);
        user.setEmail(params[4]);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        ApiService api = RetroClient.getApiService();
        Call<UserConverter> call = api.register(user);
        call.enqueue(new Callback<UserConverter>() {
            @Override
            public void onResponse(Call<UserConverter> call, Response<UserConverter> response) {
                if (response.isSuccessful()) {
                    if(response.body().getUsers()!=null){

                    }else
                        Toast.makeText(context.getApplicationContext(),"ERREUR : Email ou mot de passe incorrecte",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<UserConverter> call, Throwable t) {

                Toast.makeText(context.getApplicationContext(),"Authentication Failure",Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
