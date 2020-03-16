/**
 * 包名：chongchong.wei.handlerlooperlib
 * 创建人：apple
 * 创建时间：2020-01-13 19:25
 * 描述：
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Looper.prepare();
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println("接收到的事件："+String.valueOf(msg.data));
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Message message = new Message();
                    message.data = Thread.currentThread().getName() + "----" + i;
                    handler.sendMessage(message);
                    System.out.println("发送的事件："+String.valueOf(message.data));
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Message message = new Message();
                    message.data = Thread.currentThread().getName() + "----" + i;
                    handler.sendMessage(message);
                    System.out.println("发送的事件："+String.valueOf(message.data));
                }
            }
        }).start();
        Looper.loop();
    }
}