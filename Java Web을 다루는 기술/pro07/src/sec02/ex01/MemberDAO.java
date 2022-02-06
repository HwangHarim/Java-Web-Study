package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
    private PreparedStatement pstmt;
    private Connection con;
    private DataSource dataFactory;

//    private static final String driver = "com.mysql.cj.jdbc.Driver";
//    private static final String url = "jdbc:mysql://localhost:3306/jsp";
//    private static final String user = "root";
//    private static final String pwd = "1226";

    public MemberDAO() {
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory =(DataSource) envContext.lookup("jdbc/mysql");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers(){
        List<MemberVO> list = new ArrayList<MemberVO>();
        try{
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            System.out.println("prepareStatememt: " + query);

            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//    private void connDB() {
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, user, pwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
