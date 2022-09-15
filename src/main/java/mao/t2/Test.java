package mao.t2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Project name(项目名称)：java并发编程_ArrayBlockingQueue_and_LinkedBlockingDeque
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/15
 * Time(创建时间)： 19:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        //创建一个容量为Integer.MAX_VALUE的LinkedBlockingDeque 。
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();

        for (int i = 0; i < 20; i++)
        {
            blockingDeque.putLast(i);
        }

        for (int i = 0; i < 30; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println("出队第一个元素：" + blockingDeque.takeFirst());
            }
            else
            {
                System.out.println("出队最后一个元素：" + blockingDeque.takeLast());
            }
        }
    }
}
