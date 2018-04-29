package com.epi.epichallenge.api;


import com.epi.epichallenge.converter.UserConverter;
import com.epi.epichallenge.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by said on 29/04/18.
 */

public interface ApiService {
    @POST("/login")
    Call<UserConverter>  authetification (@Body User user);
    @POST("/api/account/register")
    Call<UserConverter>  register
            (@Body User user);

}
