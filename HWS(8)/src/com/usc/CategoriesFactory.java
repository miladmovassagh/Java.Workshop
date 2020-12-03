package com.usc;

public class CategoriesFactory {

    public static Categories getCategories(String str) throws ExceptionManager {
        switch(str) {
            case "VEGETABLES":
                return new Vegetables();
            case "FRUITS":
                return new Fruits();
            case "SUMMERS":
                return new Summers();
            default:
                throw new ExceptionManager("Invalid category name!!");
        }
    }
}
