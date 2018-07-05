package web.controller;

import dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.ListToJsonArray;
import web.model.News;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsDao dao;

    @RequestMapping(value = "/getLastNewsList", method = RequestMethod.GET)
    public @ResponseBody
    ListToJsonArray<News> getLastNewsList(){
        ListToJsonArray<News> list = new ListToJsonArray<>();
        list.setJsonArray(dao.getLatestNews());
        return list;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)

}
