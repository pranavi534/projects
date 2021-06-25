package com.example.coviddata;

import com.example.coviddata1.MyInterface;

public class MyInertface extends MyInterface {
    @GET(.getString(R.string.day))
    Call<String> getValue(@Path("input") String i);

}
