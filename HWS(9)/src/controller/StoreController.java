package controller;

import model.entity.StoreEntity;
import model.service.StoreService;
import view.ClothingDelete;
import view.ClothingEdit;
import view.ClothingRegistration;

import javax.swing.*;
import java.util.List;

public class StoreController {

    private static StoreController storeController = new StoreController();

    public static StoreController getInstance() {
        return storeController;
    }

    private StoreController() {

    }

    public void insert(String name, int code, String gender, String size, long price) throws Exception {
        if(name.equals(""))
            JOptionPane.showMessageDialog(null, "Name cannot is empty", "ERROR", JOptionPane.WARNING_MESSAGE);
        else {
            StoreService.getInstance().save(new StoreEntity().setName(name).setCode(code).setGender(gender).setSize(size).setPrice(price));
            ClothingRegistration.jFrame.dispose();
            JOptionPane.showMessageDialog(null, "Register successfully");
        }
    }

    public void update(String name, int code, String gender, String size, long price) throws Exception {
        if(name.equals(""))
            JOptionPane.showMessageDialog(null, "Name cannot is empty", "ERROR", JOptionPane.WARNING_MESSAGE);
        else {
            if (select(code)) {
                StoreService.getInstance().edit(new StoreEntity().setName(name).setCode(code).setGender(gender).setSize(size).setPrice(price));
                ClothingEdit.jFrame.dispose();
                JOptionPane.showMessageDialog(null, "Edit successfully");
            } else
                JOptionPane.showMessageDialog(null, "Invalid Code", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void delete(int code) throws Exception {
        if(select(code)) {
            StoreService.getInstance().remove(code);
            ClothingDelete.jFrame.dispose();
            JOptionPane.showMessageDialog(null, "Delete successfully");
        } else
            JOptionPane.showMessageDialog(null, "Invalid Code", "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public boolean select(int code) throws Exception {
        boolean check = false;
        List<StoreEntity> storeEntityList = StoreService.getInstance().report();
        for (StoreEntity storeEntity : storeEntityList) {
            if(code == storeEntity.getCode()) {
                check = true;
                break;
            }
        }
        return check;
    }
}
