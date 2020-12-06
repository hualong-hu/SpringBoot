package org.bigjava.mapper;
import org.apache.ibatis.annotations.Param;

import org.bigjava.bean.Product;import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ProductMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-30 16:04
 * @Version v1.0
 */
public interface ProductMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Product record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Product record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Product record);

    List<Product> selectByAll(Product product);


}