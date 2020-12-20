package model.service;

import model.entity.StoreEntity;
import model.repository.StoreRepository;

import java.util.List;

public class StoreService {

    private static StoreService storeService = new StoreService();

    public static StoreService getInstance() {
        return storeService;
    }

    private StoreService() {

    }

    public void save(StoreEntity storeEntity) throws Exception {
        try (StoreRepository storeRepository = new StoreRepository()) {
            storeRepository.insert(storeEntity);
            storeRepository.commit();
        }
    }

    public void edit(StoreEntity storeEntity) throws Exception {
        try (StoreRepository storeRepository = new StoreRepository()) {
            storeRepository.update(storeEntity);
            storeRepository.commit();
        }
    }

    public void remove(int code) throws Exception {
        try (StoreRepository storeRepository = new StoreRepository()) {
            storeRepository.delete(code);
            storeRepository.commit();
        }
    }

    public List<StoreEntity> report() throws Exception {
        List<StoreEntity> storeEntities;
        try(StoreRepository storeRepository = new StoreRepository()) {
            storeEntities = storeRepository.select();
        }
        return storeEntities;
    }
}
