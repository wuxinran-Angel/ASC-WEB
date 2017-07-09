/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyanlou.photo.util;

import com.shiyanlou.photo.domain.Image;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author tang
 */
public class test {
    public static void main(String[] args)
    {
    Image[] image = new Image[6];
    Image ii=new Image();
    DBUtils db = new DBUtils();
    ArrayList list = new ArrayList();
    list = db.getDetails();
    JSONArray ja1=new JSONArray();
    for (int i = 0; i < list.size(); i++) {
        String[] item = (String[]) list.get(i);
        ii.description=item[0];
        ii.setUrl(item[1]);
        image[i]=ii;
        //System.out.print(image[i].getDescription());
        ja1.put(OrgJsonHelper.toJSON(image[i]));
        //JSONObject jo1 = OrgJsonHelper.toJSON(image[i]);
    }
    System.out.println(ja1.toString());
    }
}
