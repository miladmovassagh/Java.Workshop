package com.usc;

public class Fruits implements Categories {

    @Override
    public void insert(String productName, long price) {
        Market market = new Market().setProductCategory("fruits").setProductName(productName).setPrice(price);
        try {
            market.connection();
            market.insert();
            market.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProducts() {
        Market market = new Market();
        try {
            market.connection();
            market.showProducts("fruits");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
