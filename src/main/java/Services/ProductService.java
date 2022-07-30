package Services;

import entities.Product;
import java.util.*;

public interface ProductService {
    void createNewProduct(Product product);
    List<Product> getAll();
    Product getById(int id);
}
