package shilin.servlet;

import shilin.dao.BorrowRecordDAO;
import shilin.excption.BusinessException;
import shilin.model.BorrowRecord;
import shilin.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
@WebServlet("/borrowRecord/update")
public class BorrowRecordUpdateServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        BorrowRecord record = JSONUtil.read(req.getInputStream(),BorrowRecord.class);
        int num = BorrowRecordDAO.update(record);
        if(num != 1)
            throw new BusinessException("00008","修改图书借阅信息数量异常");
        return null;
    }
}
