package mao.t1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Project name(项目名称)：java并发编程_ArrayBlockingQueue_and_LinkedBlockingDeque
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/15
 * Time(创建时间)： 19:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        //创建具有给定（固定）容量和默认访问策略的ArrayBlockingQueue
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 5; i++)
        {
            blockingQueue.put(i);
        }

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    blockingQueue.put(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true)
        {
            System.out.println("出队：" + blockingQueue.take());
        }
    }
}
