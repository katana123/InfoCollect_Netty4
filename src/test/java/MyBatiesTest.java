import com.example.tuosha.model.CategoriesEntity;
import com.example.tuosha.server.InfoCollectServer;
import com.example.tuosha.service.CategoriesService;
import com.example.tuosha.service.impl.CategoriesServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class MyBatiesTest {

    private ApplicationContext ctx = null;
    private InfoCollectServer server = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        server = ctx.getBean(InfoCollectServer.class);
    }

    @Test
    public void testDataSource() throws Exception {
        server.bind();
    }

}
