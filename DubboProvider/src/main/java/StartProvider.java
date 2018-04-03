import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by xiaoyh on 2017/5/11.
 */
public class StartProvider {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dubbo-provider.xml") ;
        ac.start();
        System.out.println("服务提供者在注册中心暴露服务");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
