package web.controller;

import dao.ObjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import web.model.Employee;
import web.model.SearchQuery;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/search")
public class EmployeeController {
    @Autowired
    private ObjectDao dao;

    /////
    public EmployeeController(ObjectDao dao){
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
    List checkUser(@ModelAttribute("searchQuery") SearchQuery searchQuery) {
        return dao.selectFromWhere(searchQuery.getFirstName(), searchQuery.getSecondName(),
                            searchQuery.getPosition(), searchQuery.getDepartment());
    }
}
