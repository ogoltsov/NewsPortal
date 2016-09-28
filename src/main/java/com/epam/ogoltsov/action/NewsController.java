package com.epam.ogoltsov.action;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.model.NewsToDeleteList;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class NewsController {
    private NewsService newsService;

    public NewsController() {

    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }


    @RequestMapping(value = {"/", "/news"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<News> newsList;
        try {
            newsList = newsService.findAll();
            model.addAttribute("newsList", newsList);
            model.addAttribute("list", new NewsToDeleteList());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "homePage";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String remoteNewsList(Model model, @ModelAttribute(value = "list") NewsToDeleteList newsToDeleteList) {
        List<Integer> list = newsToDeleteList.getNewsList();
        if (list != null) {
            try {
                for (Integer id : list) {
//                    newsService.delete(id);
                }
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: Add exception handler
            }
        }
        return "redirect:/news";
    }

    @RequestMapping(value = "/news/edit/{id}")
    public String editNews(Model mode, @PathVariable(value = "id") Integer id){
            System.out.println(id);
        return "editNews";
    }

    @RequestMapping(value = "/news/view/{id}")
    public String viewNews(Model model, @PathVariable(value = "id") Integer id){

        try {
            News news = newsService.findById(id);
            model.addAttribute("news", news);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "viewNews";
    }

}
