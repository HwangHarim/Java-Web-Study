package sec04.ex01;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet("/second")
public class SecondServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String address = (String)request.getAttribute("address");
    out.println("<html><body>");
    out.println("address = "+address);
    out.println("<br>");
    out.println("redirect를 이용한 바인딩 실습니다.");
    out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
