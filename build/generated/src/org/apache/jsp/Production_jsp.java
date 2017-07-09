package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.ArrayList;
import com.shiyanlou.photo.domain.*;
import org.json.*;
import com.shiyanlou.photo.util.*;

public final class Production_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/json; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


    
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

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
