package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.dao.ProductDao;
import com.zensar.entities.Product;
/**
 * @author Akansha Shah
 * @Creation_date 4th oct 2019 9.56AM
 * @Modification_date 12th oct 2019 3.39PM
 * @version 4.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description:
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAllProducts() {
		return productDao.getAll();
	}

	@Override
	public Product findProductById(int productId) {
		return productDao.getById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productDao.insert(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public void removeProduct(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> findProductsByPriceRange(float minPrice, float maxPrice) {

		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
				product1.add(product);
			}
		}
		return product1;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		// TODO Auto-generated method stub
		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getName().equals(productName)) {
				product1.add(product);
			}
		}

		return product1;
	}

	@Override
	public List<Product> findProductByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> products = productDao.getAll();
		List<Product> product1 = new ArrayList();
		for (Product product : products) {
			if (product.getName().equals(brand)) {
				product1.add(product);
			}
		}

		return product1;
	}

	@Override
	public long getProductCount() {
		return findAllProducts().size();
	}
}
