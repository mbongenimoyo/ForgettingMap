package com.example.demo;

import com.example.demo.collections.impl.ForgettingMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class TestForgettingMap {

    private int ASSOC_SIZE=10;

    @Test
    void contextLoads() {
    }

    /*
    Test if constructor produces an instance
     */
    @Test
    public void constructForgettingMapClass(){
        ForgettingMap forgettingMap= new ForgettingMap(ASSOC_SIZE);
        assertEquals("ForgettingMap must not be null", Objects.nonNull(forgettingMap),true);
    }

    /*
       Add excessive amounts of association to map
     */
    @Test
    public void addMoreAssociationsThanMaxSize(){
        ForgettingMap map= new ForgettingMap(ASSOC_SIZE);
        createNumOfTestAssociations(map,20);
        assertEquals("Map size must not surpass map limit:"+map.size(),Objects.equals(map.size(),ASSOC_SIZE),true);
    }

    /*
       Test if findAssociation() function returns correct object
     */
    @Test
    public void findAssociation(){
        ForgettingMap map= new ForgettingMap(ASSOC_SIZE);
        Association association=generateAssociation(1);
        map.add(association);
        Association result=map.find(association.getKey());
        assertEquals("Association must not be null",Objects.nonNull(result),true);
        assertEquals("Assocation key must be equal",Objects.equals(result,association),true);
    }

    @Test
    public void findAssociationMultipleTimes(){
        ForgettingMap map= new ForgettingMap(ASSOC_SIZE);
        int count=10;
        Association association=generateAssociation(1);
        for(int i=0;i<count;i++){
            association.incrementUses();
        }
        assertEquals("The number of uses is incorrect",Objects.equals(association.getNoOfUses(),count),true);
    }

    @Test
    public void addAssociationToForgettingMap(){
        String keyVal="TEST";
        String obj= "test value";
        ForgettingMap forgettingMap = new ForgettingMap(ASSOC_SIZE);
        Association assoc = new Association(keyVal, obj);
        forgettingMap.add(assoc);
        assertEquals("ForgettingMap must not be null",Objects.nonNull(forgettingMap.find(keyVal)),true);
    }



    private Association generateAssociation(int num){
        String content = String.format("TEST INPUT %s",num);

        Association testAssociation = new Association(""+num, content);
        return testAssociation;
    }

    private void createNumOfTestAssociations(ForgettingMap map, int numOfAssoc){
        for(int i=0;i<numOfAssoc;i++){
            map.add(generateAssociation(i));
        }
    }

}
