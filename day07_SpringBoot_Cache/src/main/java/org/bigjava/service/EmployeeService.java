package org.bigjava.service;

import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: EmployeeService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-27 15:41
 * @Version v1.0
 */
//抽取缓存的公共配置
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字
     *      cacheNames/value：指定缓存组件的名字,将方法的返回结果放在哪个缓存中，以数组的方式指定多个缓存
     *      key：缓存数据使用的key：可以用它来指定。默认是使用方法参数的值
     *          编写SqEL： #id:参数id的值  #a0  #b0  #root.args[0]
     *      keyGenerator：key的生成器，可以自己指定key的生成器的组件id
     *          key/keyGenerator：二者选其一使用
     *      cacheManager：指定缓存管理器，或者cacheResolver指定获取解析器
     *      condition：指定符合条件的情况下才缓存；
     *      unless：否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *          unless = "#result == null"
     *      sync：是否使用异步模式
     *
     */
    @Cacheable(value = {"emps"})
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        return employeeMapper.getEmpById(id);
    }

    /**
     * @CachePut ： 既调用方法，又更新缓存数据
     *  修改了数据库的某个数据，同时更新缓存
     *
     */
    @CachePut(value = "emps",key = "#result.id")
    public Employee updateEmployee(Employee employee){
        System.out.println("update:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    /**
     * @CacheEvict : 清除缓存
     *      key：指定要清除的数据
     *      allEntries = true：指定清除这个缓存中的所有数据
     *      beforeInvocation = true：缓存1的清除是否在方法之前执行
     *          默认代表是在方法执行之后执行；如果出现异常缓存就不会清除
     *      beforeInvocation = false：代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都会清除
     */
    @CacheEvict(value = "emps",key = "#id",allEntries = true,beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("id = " + id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmployeeByLastName(String lastName){
        return employeeMapper.getEmployeeByLastName(lastName);
    }
}
