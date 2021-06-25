package com.example.coviddata;

public abstract class Callback<T> {
    public abstract void onResponse(Call<String> call, Response<String> response);
}
