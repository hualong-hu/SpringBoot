package org.bigjava.service;

import org.bigjava.bean.Product;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ProductService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-30 14:22
 * @Version v1.0
 */
public interface ProductService {


    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByAll(Product product);

}

