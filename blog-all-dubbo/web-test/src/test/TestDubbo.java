import com.blog.bbsApi.BlogBbsProxy;
import com.blog.categoryApi.BlogCategoryProxy;
import com.blog.userApi.BlogUserProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mario on 2015/10/9.
 */
public class TestDubbo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        BlogUserProxy blogUserProxy = (BlogUserProxy) ctx.getBean("userProxy");
//        BlogCategoryProxy blogCategoryProxy = (BlogCategoryProxy) ctx.getBean("categoryProxy");
        BlogBbsProxy blogBbsProxy = (BlogBbsProxy) ctx.getBean("bbsProxy");

        //......................
        String rs = blogBbsProxy.sayHello("adadad");
        System.out.printf("rs==" + rs  );
    }
}
