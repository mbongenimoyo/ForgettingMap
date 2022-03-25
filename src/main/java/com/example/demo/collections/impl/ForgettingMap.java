package com.example.demo.collections.impl;

import com.example.demo.Association;
import com.example.demo.collections.ForgettingCollection;

import java.util.*;

public class ForgettingMap implements ForgettingCollection {

    private int maxSize;



    private HashMap<String,Association> map = new HashMap<>();

    public ForgettingMap(int maxsize){
        this.maxSize=maxsize;
    }

    @Override
    public void add(Association association) {
        //
        if(map.containsKey(association.getKey())){
            map.replace(association.getKey(),association);
        }
        else if(map.size()>=maxSize){
            removeLeastUsed();
            map.put(association.getKey(),association);
        }
        else {
            map.put(association.getKey(),association);
        }
        String key=association.getKey();

    }



    @Override
    public Association find(String key) {
        if(map.containsKey(key)){
            map.get(key).incrementUses();
            return  map.get(key);
        }
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    /*
 * sort the map using forgetting map by the number of times used
 * get the first entry in the sortedMap to get the least used association and remove it
 */
    private void removeLeastUsed(){
        Association leastUsed=null;
        ArrayList<Association> e= new ArrayList<>();

        for(Map.Entry<String, Association> a:map.entrySet()){
            if(leastUsed==null || a.getValue().getNoOfUses()<leastUsed.getNoOfUses()){
                leastUsed=a.getValue();
            }
        }

        map.remove(leastUsed.getKey());
    }
}
