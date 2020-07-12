package shilin.dao;


import shilin.excption.SysException;
import shilin.model.Student;
import shilin.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class StudentDAO {
    public static List<Student> queryAsDict(int id) {
        List<Student> students = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, student_name, id_card, student_no " +
                    "from student " +
                    "where classes_id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setDictionaryTagKey(rs.getString("id"));
                student.setDictionaryTagValue(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard("id_card");
                students.add(student);
            }
        } catch (Exception e) {
            throw new SysException("000005","查询学生信息出错",e);
        } finally {
            DBUtil.close(c,ps,rs);
        }

        return students;
    }
}
