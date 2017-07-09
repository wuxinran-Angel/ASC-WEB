package com.shiyanlou.photo.domain;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tang
 */
public class Image implements Serializable{

    private int id;    //图片ID
    public String description;    //图片名
    private String url;    //图片URL

    public int getId() {
        return id;
    }
    public void setId(int s) {
        id = s;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String s) {
        description = s;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String s) {
        url = s;
    }
}
