package DAO.Impl;

import DAO.ProductDao;
import JDBC.MySQLConnector;
import Mappers.ProductMapper;
import entities.Product;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    private Connection connection;

    public ProductDaoImpl() {
        this.connection = new MySQLConnector().getConnection();
    }

    @Override
    public void insert(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO product(name, description, price, image) VALUE (?, ?, ?, ?)");
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setString(4, product.getImage());
        statement.execute();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        return ProductMapper.mapToListOfProducts(resultSet);
    }

    @Override
    public Optional<Product> getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = ProductMapper.mapToListOfProducts(resultSet);
        return Optional.ofNullable(products.get(0));
    }
}
