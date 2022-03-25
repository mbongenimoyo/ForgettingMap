package com.example.demo.util;

import com.example.demo.Association;

import java.util.Comparator;
import java.util.Map;
/*
  The original implementation of forgetting sorted the map by number of uses and got the first
  the lowest uses by getting the association at the first index
 */
public class AssociationMapComparator implements Comparator<Association> {

    Map<String, Association> base;
   
    public AssociationMapComparator(Map<String,Association> base){
        this.base=base;
    }



    @Override
    public int compare(Association first, Association second) {
        if (first.getNoOfUses() >= second.getNoOfUses()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
