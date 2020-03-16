/**
 * 包名：chongchong.wei.handlerlooperlib
 * 创建人：apple
 * 创建时间：2020-01-13 18:04
 * 描述：
 */
public class Looper {
    protected static MessageQueue mQueue;
    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static void loop() {
        while (true) {
            Message msg = mQueue.next();
            if (msg == null) {
                continue;
            }
            msg.target.dispatchMessage(msg);
        }
    }
}