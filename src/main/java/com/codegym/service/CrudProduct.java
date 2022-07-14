package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudProduct {
    public List<Product> products = new ArrayList<>();

    public Map<String,String> listWord = new HashMap<>();

    public CrudProduct(){
        products.add(new Product(1,"abc","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW4SUQmhNBwIG3mcXzuXRmAV4tbPGLGsGA3TsnD5lYCs926KV_ouhfsBiP3ju1ubZzvAY&usqp=CAU",500));
        products.add(new Product(2,"ayz","https://angiangtourism.vn/chup-cuc-hoa-mi-o-dau/imager_19742.jpg",1500));
    }
    public void addWord(){
        listWord.put("computer","máy tính");
        listWord.put("banana","quả chuối");
        listWord.put("fly","máy bay");
        listWord.put("apple","quả táo");
        listWord.put("learn","học hành");
    }
}
