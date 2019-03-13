import com.yy.provider1.DubboProvider1Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO 2019/3/8
 *
 * @author yuyi
 */

@SpringBootTest(classes = DubboProvider1Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ManyDataSourcesTest {
    @Autowired
    @Qualifier("metisJdbcTemplate")
    private JdbcTemplate pandoraJdbcTem;

    @Autowired
    @Qualifier("studyJdbcTemplate")
    private JdbcTemplate studyJdbcTem;

    @Test
    public void testJdbcTemplate() {
        pandoraJdbcTem.update("INSERT INTO 'people' ('id_card','NAME','gender','address') VALUE ('42900119990909510','颇尔','1','中山路22号')");

    }


}
