import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 包名：chongchong.wei.handlerlooperlib
 * 创建人：apple
 * 创建时间：2020-01-13 18:05
 * 描述：消息队列，出队和入队。并且，这是一个生产者、消费者设计模式。BlockingDeque是阻塞队列
 */
public class MessageQueue {
    private BlockingDeque blockingDeque = new LinkedBlockingDeque(50);

    //生产消息
    public void enqueueMessage(Message msg) {
        if (msg.target != null) {
            try {
                blockingDeque.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //消费者，消费消息
    public Message next() {

        Message msg = null;
        try {
            msg = (Message) blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
