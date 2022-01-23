package sec01.ex01;

import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "input2", value = "/input2")
public class InputServlet2 extends HttpServlet {

  @Override
  public void init() throws ServletException{
    System.out.println("init 메서드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    Enumeration enu = request.getParameterNames();
    while(enu.hasMoreElements()){
    String name = (String) enu.nextElement();
    String[] values = request.getParameterValues(name);
      for(String value : values){
        System.out.println("name "+ name +"values "+value);
      }
    }
  }

  @Override
  public void destroy(){
    System.out.println("destroy 메서드 호출");
  }
}
