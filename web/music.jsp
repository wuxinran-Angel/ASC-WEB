<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8" import="com.shiyanlou.photo.domain.Image,org.json.*, com.shiyanlou.photo.util.*"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%

// 这是一个API测试, 注意可以将 上面contentType 修改为contentType="text/json
// <!-- 请注意上面的 import 语句 , 用逗号分隔 -->

response.addHeader("Access-Control-Allow-Origin", "*");

JSONObject jo1 = JsonReader.readJsonFromUrl("https://api.douban.com/v2/music/search?tag=wedding"+ "");

out.println(jo1.toString());
//System.out.println(jo1.toString());
%>
