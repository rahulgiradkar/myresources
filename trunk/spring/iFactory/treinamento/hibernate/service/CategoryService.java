package iFactory.treinamento.hibernate.service;

import iFactory.treinamento.hibernate.domain.Category;

import java.util.List;

public interface CategoryService {

	Category findById(Long long1);

    List findAll();

    void insert(Category c);

    void delete(Category c);

    void update(Category c);
}
