/**
 * 包名：chongchong.wei.handlerlooperlib
 * 创建人：apple
 * 创建时间：2020-01-13 18:05
 * 描述：
 */
public class Handler {

    private MessageQueue mQueue;

    public Handler() {
        mQueue = Looper.myLooper().mQueue;
    }

    public void handleMessage(Message msg) {

    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    public void sendMessage(Message msg) {
        if (mQueue != null) {
            msg.target = this;
            mQueue.enqueueMessage(msg);
        }
    }
}
