package DAO;

import entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface BucketDao {
    void create(int id) throws SQLException;
    void insertProduct(int bucketId, int productId) throws SQLException;
    List<Product> getAllProduct(int bucketId) throws SQLException;
    void removeProductFromBucket(int bucketId, int productId) throws SQLException;
}
