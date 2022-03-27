package com.demo.dao;

import com.demo.pojo.fruit;
import com.demo.until.BDConnection;

import java.util.List;

public interface FruitDAO {

    //获取所有的库存信息
    List<fruit> getFruitList();

    fruit getFruitListById(int uid);

    void updateFruitListById(fruit fru);

    void deleteFruitById(int uid);

    void addFruit(fruit fru);

    List<fruit> getFruitListByPageNum(String KeyWord,int pageNum);

    Long getFruitCount(String keyWord);

}
