package shilin.dao;

import shilin.excption.SysException;
import shilin.model.DictionaryTag;
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
public class DictionaryTagDAO {

    public static List<DictionaryTag> query(String key){
        List<DictionaryTag> tags = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key, " +
                    "       dt.dictionary_tag_value " +
                    "from dictionary d " +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id " +
                    "where d.dictionary_key = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                tags.add(tag);
            }
        } catch (Exception e) {
            throw new SysException("000002", "查询数据字典信息出错", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }

        return tags;

    }
}
