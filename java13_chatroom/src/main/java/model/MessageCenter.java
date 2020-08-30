package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class MessageCenter {
    private volatile static MessageCenter instance = null;

    public static MessageCenter getInstance() {
        if(instance == null) {
            synchronized (MessageCenter.class) {
                if(instance == null) {
                    instance = new MessageCenter();
                }
            }
        }
        return instance;
    }

    //里面有两个重要的数据结构
    //1、保存消息的队列
    private BlockingQueue<Message> messages = new LinkedBlockingDeque<>();
    //2、保存在线用户列表
    private ConcurrentHashMap<Integer, Session> onlineUsers = new ConcurrentHashMap<>();

    //实现几个操作这两个数据结构的方法：
    //1、用户上线
    public void addOnlineUser(int userId, Session session) {
        onlineUsers.put(userId,session);
    }
    //2、用户下线
    public void delOnlineUser(int userId) {
        onlineUsers.remove(userId);
    }
    //3、新增消息
    public void addMessage(Message message) throws InterruptedException {
        messages.put(message);
    }

    //接下来这个代码非常重要
    //创建一个线程，来一直扫描消息队列，把里面的消息转发给所有用户
    //构造MessageCenter实例的时光，就启动这个线程
    private MessageCenter() {
        Thread t = new Thread() {
            Gson gson = new GsonBuilder().create();
            @Override
            public void run() {
                while (true) {
                    try {
                        //1、从队列中尝试取消息 take
                        //如果队列为空，此时 take 就会阻塞
                        Message message = messages.take();
                        //2、把消息转成 json 字符串
                        String jsonString = gson.toJson(message);
                        //3、遍历在线用户列表，把消息转发给每个 用户
                        for(ConcurrentHashMap.Entry<Integer, Session> entry: onlineUsers.entrySet()) {
                            Session session = entry.getValue();
                            session.getBasicRemote().sendText(jsonString);
                        }
                    }catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
