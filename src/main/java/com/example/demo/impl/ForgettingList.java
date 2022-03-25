package com.example.demo.impl;

import com.example.demo.Association;
import com.example.demo.ForgettingCollection;

import java.util.ArrayList;
import java.util.Map;

public class ForgettingList implements ForgettingCollection {

    private int maxSize;

    ArrayList<Association> arrayList= new ArrayList<>();
    public ForgettingList(int maxAssociations){
        this.maxSize=maxAssociations;
    }

    @Override
    public void add(Association association) {
        if(arrayList.size()>=maxSize){
            removeLeastUsed();
            arrayList.add(association);
        } else{
            arrayList.add(association);
        }

    }

    @Override
    public Association find(String key) {
        try {
            Integer i= Integer.parseInt(key);
            return arrayList.get(i);
        } catch (Exception ex){
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    private void removeLeastUsed(){
        Association leastUsed=null;
        for(Association assoc:arrayList){
            if(assoc==null || assoc.getNoOfUses()<leastUsed.getNoOfUses()){
                leastUsed=assoc;
            }
        }
        arrayList.remove(leastUsed);
    }
}
