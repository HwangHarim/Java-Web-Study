package sec01.ex01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sec01.ex01.FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {

  @Override
  public void init() throws ServletException {
    System.out.println("init() 메서드 출력");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doGet() 메서드 출력");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doPost() 메서드 출력");
  }

  @Override
  public void destroy(){
    System.out.println("destroy() 메서드 출력");
  }
}