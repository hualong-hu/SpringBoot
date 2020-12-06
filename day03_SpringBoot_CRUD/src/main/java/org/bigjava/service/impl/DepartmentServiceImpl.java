package org.bigjava.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.bigjava.bean.Department;
import org.bigjava.mapper.DepartmentMapper;
import org.bigjava.service.DepartmentService;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: DepartmentServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-25 14:28
 * @Version v1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> findByAll() {
        return departmentMapper.findByAll();
    }

    @Override
    public int findCount(Integer id) {
        return departmentMapper.findCount(id);
    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentMapper.findByDepartmentName(departmentName);
    }

    @Override
    public Department findByAddress(String address) {
        return departmentMapper.findByAddress(address);
    }


}


