package DAO;

import entities.Product;

import java.util.*;
import java.sql.SQLException;

public interface ProductDao {
    void insert(Product product) throws SQLException;
    List<Product> getAll() throws SQLException;
    Optional<Product> getById(int id) throws SQLException;
}
