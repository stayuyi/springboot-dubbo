import com.alibaba.fastjson.JSONObject;
import com.yy.provider1.utils.JsonConverterUtil;
import org.junit.Test;

public class JsonConverterUtilTest {
    @Test
    public void test1(){
        String str="[{\"A\":\"a1\", \"B\":\"a1\"}, {\"A\":\"a2\", \"B\":\"b2\"}, {\"A\":\"a3\", \"B\":\"b3\"}]";

        JSONObject jsonObject = JsonConverterUtil.jsonForBuilder(str);

        System.out.println(jsonObject);

    }



}
