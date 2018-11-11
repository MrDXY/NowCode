import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException{
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("尝试获取锁...");
                    lock.lockInterruptibly();
                    System.out.println("成功获取");
                }catch (InterruptedException e){
                    System.out.println("  Interrupted  ");
                }
            }
        });
        t1.start();
        t1.interrupt();
        Thread.sleep(1);
    }
}
