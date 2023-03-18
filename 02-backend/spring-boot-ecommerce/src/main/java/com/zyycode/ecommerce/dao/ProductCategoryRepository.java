package com.zyycode.ecommerce.dao;

import com.zyycode.ecommerce.entity.Product;
import com.zyycode.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
//collectionResourceRel = "productCategory"  name of json entry
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {


}
