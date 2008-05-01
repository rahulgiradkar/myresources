package iFactory.treinamento.hibernate.service;

import iFactory.treinamento.hibernate.dao.CategoryDao;
import iFactory.treinamento.hibernate.domain.Category;
import iFactory.treinamento.hibernate.util.AuthUtil;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	private AuthUtil auth;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setAuth(AuthUtil auth) {
		this.auth = auth;
	}

	public void delete(Category c) {
		if(auth.isInRole("admin")){
			categoryDao.delete(c);
		}else{
			throw new RuntimeException("User can't insert Category");
		}
	}

	public List findAll() {
		return categoryDao.findAll();
	}

	public Category findById(Long long1) {
		return categoryDao.findById(long1);
	}

	public void insert(Category c) {
		if(auth.isInRole("admin")){
			categoryDao.insert(c);
		}else{
			throw new RuntimeException("User can't insert Category");
		}
	}

	public void update(Category c) {
		if(auth.isInRole("admin")){
			categoryDao.update(c);
		}else{
			throw new RuntimeException("User can't update Category");
		}
	}

}
