package com.zy.service;

import com.github.pagehelper.PageInfo;
import com.zy.bean.Employee;
import com.zy.bean.MyPage;
import com.zy.dto.emp.empDepSearchDTO;
import com.zy.dto.emp.employeePercentBySex;

import java.util.List;

public interface EmployeeService {

    /**
     *
     * 功能描述: 查询所有职员的信息分页结果
     *
     * @param: myPage,employee
     * @return: PageInfo<Employee>
     * @auther: zy
     * @date: 2019/8/10 14:55
     */
    List<empDepSearchDTO> queryAllEmpInfo();

    String checkEmpName(Employee employee);

    List<empDepSearchDTO> queryEmpInfo(Employee employee);

    void deleteOneEmp(Integer empId);

    void deleteManyEmps(List<Integer> empsId);

    String insertEmp(empDepSearchDTO empDepSearchDTO);

    String updateEmp(empDepSearchDTO empDepSearchDTO);

}
