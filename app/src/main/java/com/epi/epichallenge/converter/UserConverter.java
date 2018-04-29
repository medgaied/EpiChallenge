package com.epi.epichallenge.converter;
import com.epi.epichallenge.domain.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by said on 29/04/18.
 */

public class UserConverter {
    @SerializedName("")
@Expose
    public ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
