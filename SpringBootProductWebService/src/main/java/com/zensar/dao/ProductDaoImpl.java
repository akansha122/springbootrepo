package com.zensar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.entities.Product;

/**
 * @author Akansha Shah
 * @Creation_date 4th Oct 2019 10.23AM
 * @Modification_date 12th oct 2019 3.39PM
 * @version 4.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description It is an dao class used in persistent layer.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Product> getAll() {
		return (List<Product>) hibernateTemplate.find("from Product");
	}

	@Override
	public Product getById(int productId) {
		return hibernateTemplate.get(Product.class, productId);
	}

	@Override
	public void insert(Product product) {
		hibernateTemplate.save(product);
	}

	@Override
	public void update(Product product) {
		hibernateTemplate.update(product);
	}

	@Override
	public void delete(Product product) {
		hibernateTemplate.delete(product);
	}

}
