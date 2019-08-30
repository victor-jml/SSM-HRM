package com.zy.service.impl;


import com.zy.bean.Department;
import com.zy.bean.Employee;
import com.zy.bean.MyPage;
import com.zy.dao.DepartmentMapper;
import com.zy.dao.EmployeeMapper;
import com.zy.dto.emp.empDepSearchDTO;
import com.zy.dto.emp.employeePercentBySex;
import com.zy.dto.emp.objectTotal;
import com.zy.service.EmployeeService;
import com.zy.util.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<empDepSearchDTO> queryAllEmpInfo(){return employeeMapper.queryAll();}

    @Override
    public String checkEmpName(Employee employee) {
        if(employeeMapper.queryByName(employee.getEmpname())!=null){
            return "empnameExist";
        }else {
            return "empnameNotExist";
        }
    }

    @Override
    public List<empDepSearchDTO> queryEmpInfo(Employee employee) {
        return employeeMapper.queryEmpInfo(employee);
    }

    @Override
    public void deleteOneEmp(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    @Override
    public void deleteManyEmps(List<Integer> empsId) {
        for(Integer empid : empsId){
            deleteOneEmp(empid);
        }
    }

    @Override
    public String insertEmp(empDepSearchDTO empDepSearchDTO) {
        Department department = departmentMapper.queryByName(empDepSearchDTO.getDepname());
        empDepSearchDTO.setDepid(department.getDepid());
        empDepSearchDTO.setHiredate(MyTimeUtil.strToDate(empDepSearchDTO.getHiredateStr()));
        employeeMapper.insertEmp(empDepSearchDTO);
        return "insertSuccess";
    }

    @Override
    public String updateEmp(empDepSearchDTO empDepSearchDTO) {
        Department  department  =  departmentMapper.queryByName(empDepSearchDTO.getDepname());
        empDepSearchDTO.setDepid(department.getDepid());
        employeeMapper.updateEmp(empDepSearchDTO);
        return "updateSuccess";
    }



}
