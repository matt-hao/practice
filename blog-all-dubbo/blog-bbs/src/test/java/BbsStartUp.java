import com.blog.bbs.proxy.BlogBbsProxyImpl;

import java.io.IOException;

/**
 * Created by Mario on 2015/10/9.
 */
public class BbsStartUp {
    public static void main(String[] args) {
        BlogBbsProxyImpl blogBbsProxyImpl = new BlogBbsProxyImpl();
        try {
            System.out.println("按任意键退出.....");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
