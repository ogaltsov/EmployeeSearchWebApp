package web.controller;

import dao.EmployeeDao;
import dao.entity.EmployeesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.ListToJsonArray;
import web.model.SearchQuery;



@Controller
@RequestMapping("/search")
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;

    /////
    public EmployeeController(EmployeeDao dao){
        this.dao=dao;
    }


//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Employee> getAllUsers() {
//        return employeeSearchService.getAllEmployees();
//    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("searchQuery", new SearchQuery());
        modelAndView.setViewName("employees_result_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public @ResponseBody
    ListToJsonArray checkUser(@ModelAttribute("searchQuery") SearchQuery searchQuery) {
        ListToJsonArray array = new ListToJsonArray();
        array.setJsonArray(dao.searchEmployee(searchQuery));
        return array;
//        List list = new ArrayList();
//        searchQuery.setDepartment(null);
//        list.add(searchQuery.getFirstName()==null);
//        return list;
    }

    @RequestMapping(value = "/testt", method = RequestMethod.GET)
    public @ResponseBody
    EmployeesEntity checkUserTest(@ModelAttribute SearchQuery searchQuery) {
        return (EmployeesEntity) dao.searchEmployee(searchQuery).get(0);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }


}
