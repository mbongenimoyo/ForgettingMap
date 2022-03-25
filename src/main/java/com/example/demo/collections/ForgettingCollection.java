package com.example.demo.collections;

import com.example.demo.Association;

import java.util.Map;
/*
 ForgettingCollection interface provides functions signature

 */
public interface ForgettingCollection  {

    public void add(Association association);

    public Association find(String key);

    public int size();



}
