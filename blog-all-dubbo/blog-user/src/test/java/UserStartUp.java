import com.blog.user.proxy.BlogUserProxyImpl;

import java.io.IOException;

/**
 * Created by Mario on 2015/10/8.
 */
public class UserStartUp {
    public static void main(String[] args) {
        BlogUserProxyImpl blogUserProxy = new BlogUserProxyImpl();
        try {
            System.out.println("按任意键退出");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
