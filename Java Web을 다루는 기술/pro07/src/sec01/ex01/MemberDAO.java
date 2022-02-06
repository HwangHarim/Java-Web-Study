//package sec01.ex01;
//
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MemberDAO{
//
//  private static final String driver = "com.mysql.cj.jdbc.Driver";
//  private static final String url = "jdbc:mysql://localhost:3306/jsp";
//  private static final String user = "root";
//  private static final String pwd = "1226";
//  private Connection con = null;
//  private Statement stmt = null;
//  ResultSet rs = null;
//
//  public List<MemberVO> listMembers() {
//    List<MemberVO> list = new ArrayList<>();
//    try {
//      connDB();
//      String query = "select * from t_member ";
//      System.out.println(query);
//      rs = stmt.executeQuery(query);
//      while (rs.next()) {
//        String id = rs.getString("id");
//        String pwd = rs.getString("pwd");
//        String name = rs.getString("name");
//        String email = rs.getString("email");
//        Date joinDate = rs.getDate("joinDate");
//        MemberVO vo = new MemberVO();
//        vo.setId(id);
//        vo.setPwd(pwd);
//        vo.setName(name);
//        vo.setEmail(email);
//        vo.setJoinDate(joinDate);
//        list.add(vo);
//      }
//      rs.close();
//      stmt.close();
//      con.close();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return list;
//  }
//
//  private void connDB() {
//    try {
//      Class.forName(driver);
//      System.out.println("mysql 생성 성공");
//      con = DriverManager.getConnection(url, user, pwd);
//      System.out.println("Connection 생성 성공");
//      stmt = con.createStatement();
//      System.out.println("Statement 생성 성공");
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//}
