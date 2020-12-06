package org.bigjava.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.bigjava.bean.Product;
import org.bigjava.mapper.ProductMapper;
import org.bigjava.service.ProductService;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ProductServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-30 14:22
 * @Version v1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> selectByAll(Product product) {
        return productMapper.selectByAll(product);
    }


}

