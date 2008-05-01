package iFactory.treinamento.hibernate.dao;

import iFactory.treinamento.hibernate.domain.Product;

import java.util.List;

public interface ProductDao {

	Product findById(Long long1);

    List findAll();

    List findAllCached();

    void insert(Product p);

    void delete(Product p);

    void update(Product p);
}
