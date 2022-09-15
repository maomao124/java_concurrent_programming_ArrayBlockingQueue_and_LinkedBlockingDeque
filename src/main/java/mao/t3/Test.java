package mao.t3;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Project name(项目名称)：java并发编程_ArrayBlockingQueue_and_LinkedBlockingDeque
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/15
 * Time(创建时间)： 19:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(10);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i < Integer.MAX_VALUE; i++)
                {
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    if (i % 2 == 0)
                    {
                        try
                        {
                            blockingDeque.putFirst(i);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        try
                        {
                            blockingDeque.putLast(i);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


        while (true)
        {
            Thread.sleep(1000);
            for (int i = 0; i < 10; i++)
            {
                System.out.println("出队：" + blockingDeque.takeFirst());
                //System.out.println("出队：" + blockingDeque.takeLast());
            }
            System.out.println();
        }
    }
}
