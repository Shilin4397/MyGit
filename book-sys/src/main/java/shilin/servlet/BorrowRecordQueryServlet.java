package shilin.servlet;

import shilin.dao.BorrowRecordDAO;
import shilin.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<BorrowRecord> records = BorrowRecordDAO.query();
        return records;
    }
}
