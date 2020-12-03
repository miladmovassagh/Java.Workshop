package com.usc;

public class Summers implements Categories {

    @Override
    public void insert(String productName, long price) {
        Market market = new Market().setProductCategory("summers").setProductName(productName).setPrice(price);
        try {
            market.connection();
            market.insert();
            market.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showProducts() {
        Market market = new Market();
        try {
            market.connection();
            market.showProducts("summers");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
