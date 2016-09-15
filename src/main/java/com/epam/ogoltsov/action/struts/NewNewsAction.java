package com.epam.ogoltsov.action.struts;

import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.IService;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewNewsAction {

    private static final Logger log = LoggerFactory.getLogger(NewNewsAction.class);
    private static final String NEWS_SERVICE_BEAN = "newsService";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String FORWARD_SHOW_ADD_NEWS_PAGE = "showAddNews";
    private static final String SHOW_ADD_NEWS_PAGE = "Show add new news page";
    private static final String ADD_NEW_NEWS = "Add new news: ";
    private static final String FORWARD_MAIN_PAGE = "mainPage";
    private static final String ACTION_INIT = "NewNewsAction init";

    private IService<News> service;

    public NewNewsAction() {
        log.debug(ACTION_INIT);
        service = SpringContextSingleton.getContext().getBean(NEWS_SERVICE_BEAN, NewsService.class);
    }

//    public ActionForward addViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//                                     HttpServletResponse response) throws Exception {
//        NewNewsForm newsForm = (NewNewsForm) form;
//
//        newsForm.setTitle(null);
//        newsForm.setBrief(null);
//        newsForm.setContent(null);
//        newsForm.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
//        log.debug(SHOW_ADD_NEWS_PAGE);
//        return mapping.findForward(FORWARD_SHOW_ADD_NEWS_PAGE);
//    }
//
//    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//                                 HttpServletResponse response) throws Exception {
//        NewNewsForm newsForm = (NewNewsForm) form;
//        News news = new News();
//        news.setTitle(newsForm.getTitle());
//        news.setBrief(newsForm.getBrief());
//        news.setContent(newsForm.getContent());
////        news.setDate(LocalDate.parse(newsForm.getDate(),
////                DateTimeFormatter.ofPattern(DATE_FORMAT)));
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = dateFormat.parse(newsForm.getDate());
//        news.setDate(parse);
//        service.save(news);
//        log.debug(ADD_NEW_NEWS + news);
//        return mapping.findForward(FORWARD_MAIN_PAGE);
//    }
}
