<%@page import="java.util.ArrayList"%><%@ page language="java" contentType="text/json; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.ArrayList, com.shiyanlou.photo.domain.*,org.json.*, com.shiyanlou.photo.util.*"%><%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%
    
    response.addHeader("Access-Control-Allow-Origin", "*");
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
    out.println(ja1.toString());
%>
