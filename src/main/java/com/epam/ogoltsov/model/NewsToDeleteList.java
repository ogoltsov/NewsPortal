package com.epam.ogoltsov.model;

import java.util.ArrayList;
import java.util.List;

public class NewsToDeleteList {


    private List<Integer> newsList;

    public NewsToDeleteList() {
        this.newsList = new ArrayList<>();
    }

    public List<Integer> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<Integer> newsList) {
        this.newsList = newsList;
    }
}
