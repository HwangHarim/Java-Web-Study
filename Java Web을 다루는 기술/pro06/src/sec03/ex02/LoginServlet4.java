package sec03.ex02;

import java.io.UnsupportedEncodingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login4", value = "/login4")
public class LoginServlet4 extends HttpServlet {

  @Override
  public void init() throws ServletException {
    System.out.println("init 메서드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doHandle(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doHandle(request, response);
  }

  private void doHandle(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");
    System.out.println("아이디" + user_id);
    System.out.println("비밀번호" + user_pw);
  }

  @Override
  public void destroy() {
    System.out.println("destroy 메서드 호출");
  }
}
