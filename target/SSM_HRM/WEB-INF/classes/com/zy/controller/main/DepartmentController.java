package com.zy.controller.main;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.bean.Department;
import com.zy.bean.Employee;
import com.zy.bean.MyPage;
import com.zy.dto.emp.empDepSearchDTO;
import com.zy.service.DepartmentService;
import com.zy.util.JsonMsg;
import com.zy.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @project : HRM
 * @description : 控制器-部门管理页面
 * @author : zy
 */
@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /**
     *
     * 功能描述: 查询所有的部门
     *
     * @param: myPage
     * @return: ResponseEntity<Layui>分页信息
     * @auther: zy
     * @date: 2019/8/28 15:01
     */
    @RequestMapping("queryAllDep.html")
    @ResponseBody
    public ResponseEntity<Layui> queryAllDep(MyPage myPage){
        PageHelper.startPage(myPage.getPageNum(),myPage.getPageSize());
        List<Department> allDepInfo = departmentService.getAll();
        PageInfo pageInfo = new PageInfo(allDepInfo,5);
        Layui layui = Layui.data(pageInfo.getTotal(),pageInfo.getList());
        return ResponseEntity.ok(layui);
    }

    /**
     *
     * 功能描述: 检查部门是否存在
     *
     * @param: department
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:01
     */
    @RequestMapping("checkDepName.html")
    @ResponseBody
    public Map<String,Object> checkDepName(Department department){
        Map<String,Object> map = new HashMap<>();
        map.put("data",departmentService.checkDepName(department.getDepname()));
        return map;
    }

    /**
     *
     * 功能描述: 查询部门信息
     *
     * @param: myPage,Msg
     * @return: ResponseEntity<Layui>分页信息
     * @auther: zy
     * @date: 2019/8/28 15:02
     */
    @RequestMapping("queryDepInfo.html")
    @ResponseBody
    public ResponseEntity<Layui> queryDep(MyPage myPage,@RequestParam("Msg") String Msg){
        PageHelper.startPage(myPage.getPageNum(),myPage.getPageSize());
        List<Department> depInfo = departmentService.queryDepInfo(Msg);
        PageInfo pageInfo = new PageInfo(depInfo,5);
        Layui layui = Layui.data(pageInfo.getTotal(),pageInfo.getList());
        return ResponseEntity.ok(layui);
    }

    /**
     *
     * 功能描述: 删除指定的部门
     *
     * @param: department
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:04
     */
    @RequestMapping("deleteOneDep.html")
    public Map<String,Object> deleteOneDep(Department department){
        Map<String,Object> map = new HashMap<>();
        map.put("data",departmentService.deleteOneDep(department.getDepid()));
        return map;
    }

    /**
     *
     * 功能描述: 批量删除部门信息
     *
     * @param: deps
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:02
     */
    @RequestMapping("deleteManyDeps.html")
    @ResponseBody
    public Map<String,Object> deleteManyDeps(@RequestParam("deps")String deps){
        Map<String,Object> map = new HashMap<>();
        List<Department> departmentList = JSON.parseArray(deps,Department.class);
        List<Integer> depsId = new ArrayList<>();
        for (Department department : departmentList){
            depsId.add(department.getDepid());
        }
        departmentService.deleteManyDeps(depsId);
        map.put("data","deleteSuccess");
        return map;
    }

    /**
     *
     * 功能描述: 跳转编辑部门的页面
     *
     * @param: department
     * @return: String
     * @auther: zy
     * @date: 2019/8/28 15:03
     */
    @RequestMapping("toEditDep.html")
    public String toEditDep(Model model,Department department){
        model.addAttribute("depInfo",department);
        return "modify/departmentForm";
    }

    /**
     *
     * 功能描述: 添加部门
     *
     * @param: department
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:03
     */
    @RequestMapping("insertDep.html")
    @ResponseBody
    public Map<String,Object> insertDep(Department department){
        Map<String,Object> map = new HashMap<>();
        map.put("data",departmentService.insertDep(department));
        return map;
    }


    /**
     *
     * 功能描述: 更新部门信息
     *
     * @param: department
     * @return: Map<String,Object>
     * @auther: zy
     * @date: 2019/8/28 15:04
     */
    @RequestMapping("updateDep.html")
    @ResponseBody
    public Map<String,Object> updateDep(Department department){
        Map<String,Object> map = new HashMap<>();
        map.put("data",departmentService.updateDep(department));
        return map;
    }
}
