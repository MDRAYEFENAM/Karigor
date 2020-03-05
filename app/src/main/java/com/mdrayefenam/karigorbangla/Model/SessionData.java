package com.mdrayefenam.karigorbangla.Model;

public class SessionData {

        private int id;
        private String token;

    public SessionData() {
        this.id = id;
        this.token = token;
    }

    public SessionData(String token) {
        this.token = token;

    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
