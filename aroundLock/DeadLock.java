/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
class Pen {
    private String pen = "笔" ;
    public String getPen() {
        return pen;
    }
}
class Book {
    private String book = "本" ;
    public String getBook() {
        return book;
    }
}

public class DeadLock {
    private Pen pen = new Pen();
    private Book book = new Book();
    public void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(pen) {
                    System.out.println(Thread.currentThread()+":pen");
                    synchronized(book) {
                        System.out.println(Thread.currentThread()+":book");
                    }
                }
            }
        }, "pen");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized(book) {
                    System.out.println(Thread.currentThread()+":book");
                    synchronized(pen) {
                        System.out.println(Thread.currentThread()+"pen");
                    }
                }
            }
        },"book");
        t1.start();
        t2.start();
    }
}