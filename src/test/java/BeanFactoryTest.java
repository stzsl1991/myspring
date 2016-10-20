import com.myspring.ioc.BeanDefinition;
import com.myspring.ioc.BeanFactory;
import org.junit.Test;

/**
 * Created by shulin on 16/10/20.
 */
public class BeanFactoryTest {

    @Test
    public void test(){
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBeanDefinition("helloWorldService");
        helloWorldService.sayHello();
    }
}
