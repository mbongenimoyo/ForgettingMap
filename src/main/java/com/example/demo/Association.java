package com.example.demo;

public class Association {

    private Object contect;
    private String key;
    private int noOfUses=0;

    public Association(String key,Object object){
        this.key=key;
        this.contect=object;
    }

    public String getKey() {
        return key;
    }

    public Object getContect(){
        return contect;
    }

    public int getNoOfUses() {
        return noOfUses;
    }

    public void incrementUses(){
        noOfUses++;
    }
}
