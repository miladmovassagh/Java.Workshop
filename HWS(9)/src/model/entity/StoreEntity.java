package model.entity;

public class StoreEntity {
    private String name;
    private int code;
    private String gender;
    private String size;
    private long price;

    public StoreEntity() {

    }

    public StoreEntity(String name, int code, String gender, String size, long price) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public StoreEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getCode() {
        return code;
    }

    public StoreEntity setCode(int code) {
        this.code = code;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StoreEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getSize() {
        return size;
    }

    public StoreEntity setSize(String size) {
        this.size = size;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public StoreEntity setPrice(long price) {
        this.price = price;
        return this;
    }
}
