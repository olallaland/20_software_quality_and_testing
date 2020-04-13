package cn.cstqb.exam.testmaker.actions.examPaper;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
public class LoadPaper extends ActionSupport{
    private List<Paper> papers;

    public List<Paper> getPapers(){
        return papers;
    }

    public String execute() {


        String ret = ERROR;
        Connection conn = DBConnect.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            //sql语句，判断account表中是否有对应的username和password
            System.out.println("1. ------------------------------: 设置成功" );
            String sql = "SELECT exampaper.id, exampaper.name, exampaper.status_id,user.username, syllabus.level, syllabus.version FROM exampaper, user, syllabus where exampaper.facilitator_id=user.id and exampaper.syllabus_id=syllabus.id ";
            //sql+=" user = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("sql: ------------------------------: " + sql );
//            ps.setString(1, name);
//            ps.setInt(2, status_id);
//            ps.setInt(3, syllabus_id);
//            ps.setInt(4, facilitator_id);
            System.out.println("2. ------------------------------: 设置成功" );
            rs = ps.executeQuery();
            //ps.executeUpdate();
            System.out.println("3. ------------------------------: 执行成功" );


            papers = new ArrayList<>();


            while (rs.next()) {
                System.out.println("4. ------------------------------: 执行成功" );
                System.out.println("id: " + rs.getInt("exampaper.id"));

                papers.add(new Paper(rs.getInt("exampaper.id"), rs.getInt("exampaper.status_id"), rs.getString("exampaper.name"), rs.getString("syllabus.level")+rs.getString("syllabus.version"),rs.getString("user.username")));
                System.out.println("5. ------------------------------: 执行成功" );

                ret = SUCCESS;
            }

            ret = SUCCESS;

        } catch (Exception e) {
            ret = ERROR;
            e.printStackTrace();

        } finally {
            DBConnect.close(rs, state, conn);
        }

        System.out.println("---------------------------------------------------------: " + ret);



        return ret;
    }


}
