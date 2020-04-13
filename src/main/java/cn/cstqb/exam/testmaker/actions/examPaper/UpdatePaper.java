package cn.cstqb.exam.testmaker.actions.examPaper;

import java.sql.*;
import java.sql.Date;
import com.opensymphony.xwork2.ActionSupport;
public class UpdatePaper extends ActionSupport{
    private String name;
    private int status_id;
    private int syllabus_id;
    private int facilitator_id;
    private String startDate;
    private String finishDate;
    public String execute() {
        System.out.println("---------------------------: name: " + name + " status_id: " + status_id + " syllabus_id: "+syllabus_id+" facilitator_id: "+facilitator_id);
        System.out.println("---------------------------: startDate: " + startDate + " finishDate: " + finishDate);

        String ret = ERROR;
        Connection conn = DBConnect.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            //sql语句，判断account表中是否有对应的username和password
            System.out.println("3. ------------------------------: 设置成功" );
            String sql = "INSERT INTO examPaper(name, status_id, syllabus_id,facilitator_id) VALUES (?,?,?,?)";
            //sql+=" user = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("4. ------------------------------: 设置成功" );
            ps.setString(1, name);
            ps.setInt(2, status_id);
            ps.setInt(3, syllabus_id);
            ps.setInt(4, facilitator_id);
            System.out.println("1. ------------------------------: 设置成功" );
            //ResultSet rs = ps.executeQuery();
            ps.executeUpdate();
            System.out.println("2. ------------------------------: 执行成功" );
//            while (rs.next()) {
//                name = rs.getString(1);
//                ret = SUCCESS;
//            }
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

    public int getFacilitator_id() {
        return facilitator_id;
    }

    public void setFacilitator_id(int facilitator_id) {
        this.facilitator_id = facilitator_id;
    }

    public int getSyllabus_id() {
        return syllabus_id;
    }

    public void setSyllabus_id(int syllabus_id) {
        this.syllabus_id = syllabus_id;
    }
    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
