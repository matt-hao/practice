import com.blog.category.proxy.BlogCategoryProxyImpl;

import java.io.IOException;

/**
 * Created by Mario on 2015/10/9.
 */
public class CategoryStartUp {
    public static void main(String[] args) {
        BlogCategoryProxyImpl blogCategoryProxy = new BlogCategoryProxyImpl();
        System.out.println("按任意键退出");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
