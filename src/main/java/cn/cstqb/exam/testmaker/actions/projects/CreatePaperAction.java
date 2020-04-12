package cn.cstqb.exam.testmaker.actions.projects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
public class CreatePaperAction extends ActionSupport {
    private String name;
    private int status_id;
    private int syllabus_id;
    private int facilitator_id;

    public String execute() {
        String ret = ERROR;
        Connection conn = null;

        System.out.println("---------------------------------------------------------: ");
        System.out.println("---------------------------------------------------------: name: " + name + " status_id: " + status_id + " syllabus_id: "+syllabus_id+" facilitator_id: "+facilitator_id);
        try {
            String URL = "jdbc:mysql://localhost:3306/testmaker";
            Class.forName("com.mysql.jc.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "fudansoft@82");
            String sql = "INSERT INTO examPaper(name, status_id, syllabus_id,facilitator_id) VALUES (?,?,?,?)";
            //sql+=" user = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, status_id);
            ps.setInt(3, syllabus_id);
            ps.setInt(4, facilitator_id);
            //ResultSet rs = ps.executeQuery();
            ps.executeUpdate();
//            while (rs.next()) {
//                name = rs.getString(1);
//                ret = SUCCESS;
//            }
            ret = SUCCESS;
        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
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
