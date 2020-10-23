package com.usc;

import java.util.*;

public class Store<ProductName, ProductQuality, ProductWeight, ProductPrice> {
    private ProductName[] productName;
    private ProductQuality[] productQuality;
    private ProductWeight[] productWeight;
    private ProductPrice[] productPrice;
    private Map<String, String> map1, map2, map3, map4, map5, map6, map7, map8, map9, map10;

    public Store() {
        setMap1();
        setMap2();
        setMap3();
        setMap4();
        setMap5();
        setMap6();
        setMap7();
        setMap8();
        setMap8();
        setMap9();
        setMap10();
        setProductName((ProductName[]) new String[] {map1.get("product name"), map2.get("product name"), map3.get("product name"), map4.get("product name"),
                map5.get("product name"), map6.get("product name"), map7.get("product name"), map8.get("product name"), map9.get("product name"), map10.get("product name")});
        setProductQuality((ProductQuality[])new String[] {map1.get("product quality"), map2.get("product quality"), map3.get("product quality"), map4.get("product quality"),
                map5.get("product quality"), map6.get("product quality"), map7.get("product quality"), map8.get("product quality"), map9.get("product quality"), map10.get("product quality")});
        setProductWeight((ProductWeight[]) new String[] {map1.get("product weight"), map2.get("product weight"), map3.get("product weight"), map4.get("product weight"),
                map5.get("product weight"), map6.get("product weight"), map7.get("product weight"), map8.get("product weight"), map9.get("product weight"), map10.get("product weight")});
        setProductPrice((ProductPrice[]) new String[] {map1.get("product price"), map2.get("product price"), map3.get("product price"), map4.get("product price"),
                map5.get("product name"), map6.get("product price"), map7.get("product price"), map8.get("product price"), map9.get("product price"), map10.get("product price")});
    }

    public ProductName[] getProductName() {
        return productName;
    }

    public void setProductName(ProductName[] productName) {
        this.productName = productName;
    }

    public ProductQuality[] getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(ProductQuality[] productQuality) {
        this.productQuality = productQuality;
    }

    public ProductWeight[] getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(ProductWeight[] productWeight) {
        this.productWeight = productWeight;
    }

    public ProductPrice[] getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice[] productPrice) {
        this.productPrice = productPrice;
    }

    public Map<String, String> getMap1() {
        return map1;
    }

    public void setMap1() {
        map1 = new LinkedHashMap<>();
        map1.put("product name","pofak");
        map1.put("product quality","high");
        map1.put("product weight","300g");
        map1.put("product price","70000rial");
    }

    public Map<String, String> getMap2() {
        return map2;
    }

    public void setMap2() {
        map2 = new LinkedHashMap<>();
        map2.put("product name","chips");
        map2.put("product quality","high");
        map2.put("product weight","250g");
        map2.put("product price","35000rial");
    }

    public Map<String, String> getMap3() {
        return map3;
    }

    public void setMap3() {
        map3 = new LinkedHashMap<>();
        map3.put("product name","bastani");
        map3.put("product quality","medium");
        map3.put("product weight","75g");
        map3.put("product price","30000rial");
    }

    public Map<String, String> getMap4() {
        return map4;
    }

    public void setMap4() {
        map4 = new LinkedHashMap<>();
        map4.put("product name","lavashak");
        map4.put("product quality","low");
        map4.put("product weight","50g");
        map4.put("product price","40000rial");
    }

    public Map<String, String> getMap5() {
        return map5;
    }

    public void setMap5() {
        map5 = new LinkedHashMap<>();
        map5.put("product name","cake");
        map5.put("product quality","high");
        map5.put("product weight","200g");
        map5.put("product price","25000rial");
    }

    public Map<String, String> getMap6() {
        return map6;
    }

    public void setMap6() {
        map6 = new LinkedHashMap<>();
        map6.put("product name","smartiz");
        map6.put("product quality","low");
        map6.put("product weight","75g");
        map6.put("product price","60000rial");
    }

    public Map<String, String> getMap7() {
        return map7;
    }

    public void setMap7() {
        map7 = new LinkedHashMap<>();
        map7.put("product name","aloche");
        map7.put("product quality","medium");
        map7.put("product weight","90g");
        map7.put("product price","15000rial");
    }

    public Map<String, String> getMap8() {
        return map8;
    }

    public void setMap8() {
        map8 = new LinkedHashMap<>();
        map8.put("product name","adams");
        map8.put("product quality","high");
        map8.put("product weight","500g");
        map8.put("product price","80000rial");
    }

    public Map<String, String> getMap9() {
        return map9;
    }

    public void setMap9() {
        map9 = new LinkedHashMap<>();
        map9.put("product name","pastil");
        map9.put("product quality","medium");
        map9.put("product weight","350g");
        map9.put("product price","85000rial");
    }

    public Map<String, String> getMap10() {
        return map10;
    }

    public void setMap10() {
        map10 = new LinkedHashMap<>();
        map10.put("product name","shir");
        map10.put("product quality","high");
        map10.put("product weight","1.5l");
        map10.put("product price","90000rial");
    }

    public void showProductInformation(String key) throws ExceptionManager {
        if(map1.containsValue(key)) {
            System.out.println("product name: " + map1.get("product name"));
            System.out.println("product quality: " + map1.get("product quality"));
            System.out.println("product weight: " + map1.get("product weight"));
            System.out.println("product price: " + map1.get("product price"));
        }
        else if(map2.containsValue(key)) {
            System.out.println("product name: " + map2.get("product name"));
            System.out.println("product quality: " + map2.get("product quality"));
            System.out.println("product weight: " + map2.get("product weight"));
            System.out.println("product price: " + map2.get("product price"));
        }
        else if(map3.containsValue(key)) {
            System.out.println("product name: " + map3.get("product name"));
            System.out.println("product quality: " + map3.get("product quality"));
            System.out.println("product weight: " + map3.get("product weight"));
            System.out.println("product price: " + map3.get("product price"));
        }
        else if(map4.containsValue(key)) {
            System.out.println("product name: " + map4.get("product name"));
            System.out.println("product quality: " + map4.get("product quality"));
            System.out.println("product weight: " + map4.get("product weight"));
            System.out.println("product price: " + map4.get("product price"));
        }
        else if(map5.containsValue(key)) {
            System.out.println("product name: " + map5.get("product name"));
            System.out.println("product quality: " + map5.get("product quality"));
            System.out.println("product weight: " + map5.get("product weight"));
            System.out.println("product price: " + map5.get("product price"));
        }
        else if(map6.containsValue(key)) {
            System.out.println("product name: " + map6.get("product name"));
            System.out.println("product quality: " + map6.get("product quality"));
            System.out.println("product weight: " + map6.get("product weight"));
            System.out.println("product price: " + map6.get("product price"));
        }
        else if(map7.containsValue(key)) {
            System.out.println("product name: " + map7.get("product name"));
            System.out.println("product quality: " + map7.get("product quality"));
            System.out.println("product weight: " + map7.get("product weight"));
            System.out.println("product price: " + map7.get("product price"));
        }
        else if(map8.containsValue(key)) {
            System.out.println("product name: " + map8.get("product name"));
            System.out.println("product quality: " + map8.get("product quality"));
            System.out.println("product weight: " + map8.get("product weight"));
            System.out.println("product price: " + map8.get("product price"));
        }
        else if(map9.containsValue(key)) {
            System.out.println("product name: " + map9.get("product name"));
            System.out.println("product quality: " + map9.get("product quality"));
            System.out.println("product weight: " + map9.get("product weight"));
            System.out.println("product price: " + map9.get("product price"));
        }
        else if(map10.containsValue(key)) {
            System.out.println("product name: " + map10.get("product name"));
            System.out.println("product quality: " + map10.get("product quality"));
            System.out.println("product weight: " + map10.get("product weight"));
            System.out.println("product price: " + map10.get("product price"));
        }
        else
            throw new ExceptionManager("product is not available in store!");
    }

    public void showProductInventory() {
        System.out.println("products in store is:");
        System.out.println(Arrays.toString(getProductName()));
    }
}
