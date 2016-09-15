package com.epam.ogoltsov.action;


import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class NewsController {


    private NewsService newsService;

    public NewsController() {
        System.out.println("SHIT!");
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {

        List<News> newsList;
        try {
            newsList = newsService.findAll();
            model.addAttribute("newsList", newsList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "homePage";
    }

}
