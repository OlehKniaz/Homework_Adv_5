package DAO.Impl;

import DAO.BucketDao;
import JDBC.MySQLConnector;
import Mappers.ProductMapper;
import entities.Product;

import java.sql.*;
import java.util.List;

public class BucketDaoImpl implements BucketDao {

    Connection connection;

    public BucketDaoImpl() {
        this.connection = new MySQLConnector().getConnection();
    }

    @Override
    public void create(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO bucket VALUE (?, ?)");
        statement.setInt(1, id);
        statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        statement.execute();
    }

    @Override
    public void insertProduct(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bucket_product VALUE (?, ?)");
        statement.setInt(1, bucketId);
        statement.setInt(2, productId);
        statement.execute();
    }

    @Override
    public List<Product> getAllProduct(int bucketId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT p.id, p.name, p.description, p.price, p.image FROM bucket_product bp INNER JOIN product p on bp.product_id = p.id WHERE bp.bucket_id = ?");
        statement.setInt(1, bucketId);
        ResultSet resultSet = statement.executeQuery();
        return ProductMapper.mapToListOfProducts(resultSet);
    }

    public void removeProductFromBucket(int bucketId, int productId) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM bucket_product WHERE bucket_id = ? AND product_id = ?;");
        statement.setInt(1, bucketId);
        statement.setInt(1, productId);
        statement.execute();
    }
}
