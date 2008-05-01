package iFactory.treinamento.hibernate.dao;

import java.util.List;

import iFactory.treinamento.hibernate.domain.Category;

public interface ClienteDao {

    Category findById(Long long1);

    List findAll();

    List findAllCached();

    void insert(Category c);

    void delete(Category c);

    void update(Category c);

}
