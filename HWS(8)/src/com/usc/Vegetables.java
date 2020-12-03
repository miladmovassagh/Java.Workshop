package com.usc;

public class Vegetables implements Categories {

    @Override
    public void insert(String productName, long price) {
        Market market = new Market().setProductCategory("vegetables").setProductName(productName).setPrice(price);
        try {
            market.connection();
            market.insert();
            market.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showProducts() {
        Market market = new Market();
        try {
            market.connection();
            market.showProducts("vegetables");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
