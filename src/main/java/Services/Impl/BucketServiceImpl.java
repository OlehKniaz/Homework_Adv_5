package Services.Impl;

import DAO.BucketDao;
import Services.BucketService;
import entities.Product;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public List<Product> getProductsFromBucket(int bucketId) {
        List<Product> allProduct = new ArrayList<>();
        try {
            allProduct = bucketDao.getAllProduct(bucketId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allProduct;
    }

    @Override
    public void addProductToBucket(int bucketId, int productId) {
        try {
            bucketDao.insertProduct(bucketId, productId);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void removeItem(int bucketId, int productId) throws SQLException {
        bucketDao.removeProductFromBucket(bucketId, productId);
    }
}
