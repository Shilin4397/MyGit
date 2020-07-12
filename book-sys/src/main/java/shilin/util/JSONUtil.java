package shilin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import shilin.excption.SysException;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class JSONUtil {

    private static ObjectMapper MAPPER;

    static{
        MAPPER = new ObjectMapper();
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    //读取输入流的json数据，反序列化对象，
    // 泛型的操作：<T>方法上定义泛型类型，返回值和传入参数都可以定义泛型。
    public static <T> T read(InputStream is, Class<T> clazz){
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            throw new SysException("000003","http请求，处理解析json数据出错",e);
        }
    }
    public static String write(Object o) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new SysException("000004","json序列化对象出错："+o,e);
        }
    }
}
