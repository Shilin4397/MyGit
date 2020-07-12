package shilin.dao;

import shilin.excption.SysException;
import shilin.model.Classes;
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
public class ClassesDAO {

    public static List<Classes> query() {
        List<Classes> classesList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, classes_name, classes_graduate_year, classes_major " +
                    "from classes;";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classesList.add(classes);
            }
        } catch (Exception e) {
            throw new SysException("000003","查询班级数据字典出错",e);
        } finally {
            DBUtil.close(c,ps,rs);
        }

        return classesList;
    }
}
