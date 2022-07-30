package Services.Impl;

import DAO.ProductDao;
import Services.ProductService;
import entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createNewProduct(Product product) {
        try {
            productDao.insert(product);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            products = productDao.getAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        try {
            Optional<Product> byId = productDao.getById(id);
            if (byId.isPresent()){
                return byId.get();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
