package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import CategoryProfile.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
    _jspx_tagPool_c_import_url_nobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/background.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/background.css\">\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.validate.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jqueryFeedback.js\"></script>\n");
      out.write("\n");
      out.write("        <style>  \n");
      out.write("            \n");
      out.write("        .carousel-inner, img {\n");
      out.write("        width: 100%; /* Set width to 100% */\n");
      out.write("        height: 450px;\n");
      out.write("        margin: auto;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #myCarousel\n");
      out.write("        {\n");
      out.write("            width: 80%;\n");
      out.write("            height: 450px;  \n");
      out.write("            margin: auto;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .carousel-caption h3 {\n");
      out.write("            color: #fff !important;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        @media (max-width: 600px) {\n");
      out.write("            .carousel-caption {\n");
      out.write("                display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */\n");
      out.write("                            }\n");
      out.write("        } \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        .person {\n");
      out.write("            border: 10px solid transparent;\n");
      out.write("            margin-bottom: 25px;\n");
      out.write("            width: 50%;\n");
      out.write("            height: 50%;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .person:hover {\n");
      out.write("            border-color: #f1f1f1;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        .navbar {\n");
      out.write("      margin-bottom: 0;\n");
      out.write("      \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("       div.error{\n");
      out.write("        color: red;\n");
      out.write("        display: block;\n");
      out.write("        float:left;\n");
      out.write("        text-align: left;\n");
      out.write("        width: 100%;\n");
      out.write("        }\n");
      out.write("  \n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");
 
        CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl(); 
        List<CategoryProfiles> list= pdao.getProfiles();
        
        request.setAttribute("CategoryProData", list);
    
      out.write("\n");
      out.write("    \n");
      out.write("    <body id=\"myPage\">\n");
      out.write("        \n");
      out.write("        ");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("        <marquee width=\"100%\" behavior=\"scroll\">  \n");
      out.write("            <mark style=\"color:red;background-color: lightyellow;\" >Note: You must be a valid user to book an Appointment.</mark>\n");
      out.write("</marquee>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("  <!-- Indicators -->\n");
      out.write("    <ol class=\"carousel-indicators\">\n");
      out.write("    <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("     ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </ol>\n");
      out.write("\n");
      out.write("  <!-- Wrapper for slides -->\n");
      out.write("    <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("    <div class=\"item active\">\n");
      out.write("<!--        <img src=\"images/cardiology.jpg\" alt=\"Cardiology\" width=\"1200\" height=\"450px\" style=\"width:100%; height: 450px;\">-->\n");
      out.write("<img src=\"images/hospital.jpg\" alt=\"Hospital\" width=\"1200\" height=\"450px\" style=\"width:100%; height: 450px;\">\n");
      out.write("      <div class=\"carousel-caption\">\n");
      out.write("        <h3>Welcome to National Hospital</h3>\n");
      out.write("      </div> \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("   \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Left and right controls -->\n");
      out.write("    <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("    <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Previous</span>\n");
      out.write("    </a>\n");
      out.write("    \n");
      out.write("    <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("    <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"sr-only\">Next</span>\n");
      out.write("    </a>\n");
      out.write("  \n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <!-- end of Carousel -->\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"text-align: justify\">\n");
      out.write("            <h2 class=\"text-center\">National Hostpital </h2>\n");
      out.write("            <p>A hospital is a health care institution providing patient treatment with specialized medical and nursing staff and medical equipment. The best-known type of hospital is the general hospital, which typically has an emergency department to treat urgent health problems ranging from fire and accident victims to a heart attack. A district hospital typically is the major health care facility in its region, with large numbers of beds for intensive care and additional beds for patients who need long-term care. Specialised hospitals include trauma centres, rehabilitation hospitals, children's hospitals, seniors' (geriatric) hospitals, and hospitals for dealing with specific medical needs such as psychiatric treatment (see psychiatric hospital) and certain disease categories. Specialised hospitals can help reduce health care costs compared to general hospitals.</p>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <!-- end of content -->\n");
      out.write("        \n");
      out.write("        <div class=\"row text-center\" style=\"width:80%; margin: auto\">\n");
      out.write("         <h4 class=\"text-center\"><strong>Top Experienced Doctors</strong></h4>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"#demo\" data-toggle=\"collapse\">\n");
      out.write("        <img src=\"images/doctor.jpg\" class=\"person\" alt=\"Random Name\" width=\"255\" height=\"255\">\n");
      out.write("        <p class=\"text-center\"><strong>Dr. Firoz</strong></p>\n");
      out.write("      </a>\n");
      out.write("      <div id=\"demo\" class=\"collapse\">\n");
      out.write("        <p>Surgery Specilist</p>\n");
      out.write("        <p>MBBS</p>\n");
      out.write("        <p>Member since 1988</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"#demo2\" data-toggle=\"collapse\">\n");
      out.write("        <img src=\"images/doctor.jpg\" class=\"person\" alt=\"Random Name\" width=\"255\" height=\"255\">\n");
      out.write("        <p class=\"text-center\"><strong>Dr. Pradeep</strong></p>\n");
      out.write("      </a>\n");
      out.write("      <div id=\"demo2\" class=\"collapse\">\n");
      out.write("        <p>Heart Specialist</p>\n");
      out.write("        <p>MBBS, PHD</p>\n");
      out.write("        <p>Member since 1988</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"#demo3\" data-toggle=\"collapse\">\n");
      out.write("          <img src=\"images/doctor.jpg\" class=\"person\" alt=\"Random Name\" width=\"255\" height=\"255\">\n");
      out.write("          <p class=\"text-center\"><strong>Dr. Abhishek</strong></p>\n");
      out.write("      </a>\n");
      out.write("      <div id=\"demo3\" class=\"collapse\">\n");
      out.write("        <p>Cancer Specialist</p>\n");
      out.write("        <p>MBBS</p>\n");
      out.write("        <p>Member since 2005</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <!-- end of profile -->\n");
      out.write("   \n");
      out.write("        <div class=\"container\" style=\"border-top: 1px solid black; background-color: #fffaeb; width: 100%;\">\n");
      out.write("            <h3 class=\"text-center\">Contact Us</h3> <br>\n");
      out.write("    <div class=\"row test\">\n");
      out.write("    <div class=\"col-md-4\">\n");
      out.write("      <p>Contact:</p>\n");
      out.write("      <p><span class=\"glyphicon glyphicon-map-marker\"></span>&nbsp; Delhi, India</p>\n");
      out.write("      <p><span class=\"glyphicon glyphicon-phone\"></span>&nbsp; Phone: +11-99999</p>\n");
      out.write("      <p><span class=\"glyphicon glyphicon-envelope\"></span>&nbsp; Email: mail@mail.com</p> \n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-md-8\">\n");
      out.write("        <p>Any queries? Write us.</p>\n");
      out.write("        <form id=\"feedbackForm\" action=\"Feedback\" method=\"post\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-6 form-group\">\n");
      out.write("            <input class=\"form-control\" id=\"name\" placeholder=\"Name\" name=\"CommenterName\" type=\"text\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-6 form-group\">\n");
      out.write("            <input class=\"form-control\" id=\"email\" placeholder=\"Email\" name=\"CommenterEmail\" type=\"email\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <textarea class=\"form-control\" id=\"comments\"  name=\"CommenterComment\" placeholder=\"Comment\" rows=\"5\"></textarea>\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12 form-group\">\n");
      out.write("          <button class=\"btn pull-right\" type=\"submit\">Submit</button>\n");
      out.write("        </div>\n");
      out.write("      </div> \n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <!-- end of contact -->\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("  \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("header.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("j");
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(CategoryProData)}", java.lang.Integer.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).intValue());
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${j}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></li>\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CategoryProData}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("x");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("    <div class=\"item\">\n");
          out.write("        <a href=\"doctorcarousel.jsp?category=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getSpecialization()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("        <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getImage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"Hospital Department\" width=\"1200\" height=\"450px\" style=\"width:100%; height: 450px;\">\n");
          out.write("        </a>\n");
          out.write("        <div class=\"carousel-caption\">\n");
          out.write("        <h3>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getSpecialization()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h3>\n");
          out.write("        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x.getDescription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("      </div> \n");
          out.write("    </div>\n");
          out.write("     ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
