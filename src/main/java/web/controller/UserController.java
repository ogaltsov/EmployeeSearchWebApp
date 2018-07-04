package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView redirectToUserPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirectToUserPage");
//        return modelAndView;
//    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public ModelAndView userPage()
    {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("userPage");
        return model;
    }

}
