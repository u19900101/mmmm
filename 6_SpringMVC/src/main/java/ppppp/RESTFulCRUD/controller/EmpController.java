package ppppp.RESTFulCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ppppp.RESTFulCRUD.dao.DepartmentDao;
import ppppp.RESTFulCRUD.dao.EmployeeDao;
import ppppp.RESTFulCRUD.entities.Department;
import ppppp.RESTFulCRUD.entities.Employee;

import java.util.Collection;

/**
 * @author lppppp
 * @create 2021-01-20 22:27
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/list")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "list";
    }

    @RequestMapping("/toaddpage")
    public String add_page(Model model){
        model.addAttribute("employee", new Employee(1, "laName", "123.com", 0, new Department(5, "HOUSE")));
        return "addEmp";
    }

    //CRUD
    @RequestMapping(value = "/emp",method = {RequestMethod.POST,RequestMethod.PUT})
    public String add_update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list";
    }

    @RequestMapping(value = "/emp/{id}",method = {RequestMethod.DELETE})
    public String delete(Employee employee){
        employeeDao.delete(employee.getId());
        return "redirect:/list";
    }

    @RequestMapping(value = "/emp/{id}",method = {RequestMethod.GET})
    public String before_update(Model model, @PathVariable Integer id){
        model.addAttribute("employee", employeeDao.get(id));
        // 交由 @ModelAttribute 处理
        // Collection<Department> departments = departmentDao.getDepartments();
        // model.addAttribute("departments", departments);
        return "editEmp";
    }

    // 每次运行之前都把 部门的信息放进去
    @ModelAttribute
    public void setDepartmentInfo(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
    }

}