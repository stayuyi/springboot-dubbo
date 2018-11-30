package com.yy.provider1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


public class JsonArray2JsonObjectTest {
    String json="[\n" +
            "    {\n" +
            "        \"sortField\":null,\n" +
            "        \"sortOrder\":null,\n" +
            "        \"blacklistId\":\"11411880\",\n" +
            "        \"blacklistType\":\"1\",\n" +
            "        \"sanCode\":\"1\",\n" +
            "        \"sanName\":\"\",\n" +
            "        \"accountType\":\"I\",\n" +
            "        \"certificateType\":\"0\",\n" +
            "        \"certificateNumber\":\"001975154LS033\",\n" +
            "        \"clientName\":\"\",\n" +
            "        \"clientEnglishName\":\"Virgílio Pedro Samussongo\",\n" +
            "        \"nationality\":\"ANGOL\",\n" +
            "        \"birthday\":\"\",\n" +
            "        \"birthCountry\":\"\",\n" +
            "        \"gender\":\"M\",\n" +
            "        \"lastOccupation\":\"Member, National Assembly, UNITA, Lunda Sul\",\n" +
            "        \"residenceCountry\":\"\",\n" +
            "        \"isPoliticians\":\"F\",\n" +
            "        \"isValid\":\"T\",\n" +
            "        \"isDel\":\"F\",\n" +
            "        \"operateState\":\"1\",\n" +
            "        \"validDate\":\"\",\n" +
            "        \"filler1\":\"\",\n" +
            "        \"filler2\":\"\",\n" +
            "        \"filler3\":\"\",\n" +
            "        \"filler4\":\"\",\n" +
            "        \"createDate\":\"2018-05-17 09:57:49\",\n" +
            "        \"lastModifyDate\":\"\",\n" +
            "        \"lastModifyOperator\":\"\",\n" +
            "        \"remarks\":\"\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"sortField\":null,\n" +
            "        \"sortOrder\":null,\n" +
            "        \"blacklistId\":\"11411880\",\n" +
            "        \"blacklistType\":\"1\",\n" +
            "        \"sanCode\":\"1\",\n" +
            "        \"sanName\":\"\",\n" +
            "        \"accountType\":\"I\",\n" +
            "        \"certificateType\":\"0\",\n" +
            "        \"certificateNumber\":\"001975154LS033\",\n" +
            "        \"clientName\":\"\",\n" +
            "        \"clientEnglishName\":\"Virgílio Pedro Samussongo\",\n" +
            "        \"nationality\":\"ANGOL\",\n" +
            "        \"birthday\":\"\",\n" +
            "        \"birthCountry\":\"\",\n" +
            "        \"gender\":\"M\",\n" +
            "        \"lastOccupation\":\"Member, National Assembly, UNITA, Lunda Sul\",\n" +
            "        \"residenceCountry\":\"\",\n" +
            "        \"isPoliticians\":\"F\",\n" +
            "        \"isValid\":\"T\",\n" +
            "        \"isDel\":\"F\",\n" +
            "        \"operateState\":\"1\",\n" +
            "        \"validDate\":\"\",\n" +
            "        \"filler1\":\"\",\n" +
            "        \"filler2\":\"\",\n" +
            "        \"filler3\":\"\",\n" +
            "        \"filler4\":\"\",\n" +
            "        \"createDate\":\"2018-05-17 09:57:49\",\n" +
            "        \"lastModifyDate\":\"\",\n" +
            "        \"lastModifyOperator\":\"\",\n" +
            "        \"remarks\":\"\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"sortField\":null,\n" +
            "        \"sortOrder\":null,\n" +
            "        \"blacklistId\":\"11411880\",\n" +
            "        \"blacklistType\":\"1\",\n" +
            "        \"sanCode\":\"1\",\n" +
            "        \"sanName\":\"\",\n" +
            "        \"accountType\":\"I\",\n" +
            "        \"certificateType\":\"0\",\n" +
            "        \"certificateNumber\":\"001975154LS033\",\n" +
            "        \"clientName\":\"\",\n" +
            "        \"clientEnglishName\":\"Virgílio Pedro Samussongo\",\n" +
            "        \"nationality\":\"ANGOL\",\n" +
            "        \"birthday\":\"\",\n" +
            "        \"birthCountry\":\"\",\n" +
            "        \"gender\":\"M\",\n" +
            "        \"lastOccupation\":\"Member, National Assembly, UNITA, Lunda Sul\",\n" +
            "        \"residenceCountry\":\"\",\n" +
            "        \"isPoliticians\":\"F\",\n" +
            "        \"isValid\":\"T\",\n" +
            "        \"isDel\":\"F\",\n" +
            "        \"operateState\":\"1\",\n" +
            "        \"validDate\":\"\",\n" +
            "        \"filler1\":\"\",\n" +
            "        \"filler2\":\"\",\n" +
            "        \"filler3\":\"\",\n" +
            "        \"filler4\":\"\",\n" +
            "        \"createDate\":\"2018-05-17 09:57:49\",\n" +
            "        \"lastModifyDate\":\"\",\n" +
            "        \"lastModifyOperator\":\"\",\n" +
            "        \"remarks\":\"\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"sortField\":null,\n" +
            "        \"sortOrder\":null,\n" +
            "        \"blacklistId\":\"11411880\",\n" +
            "        \"blacklistType\":\"1\",\n" +
            "        \"sanCode\":\"1\",\n" +
            "        \"sanName\":\"\",\n" +
            "        \"accountType\":\"I\",\n" +
            "        \"certificateType\":\"0\",\n" +
            "        \"certificateNumber\":\"001975154LS033\",\n" +
            "        \"clientName\":\"\",\n" +
            "        \"clientEnglishName\":\"Virgilio Pedro Samussongo\",\n" +
            "        \"nationality\":\"ANGOL\",\n" +
            "        \"birthday\":\"\",\n" +
            "        \"birthCountry\":\"\",\n" +
            "        \"gender\":\"M\",\n" +
            "        \"lastOccupation\":\"Member, National Assembly, UNITA, Lunda Sul\",\n" +
            "        \"residenceCountry\":\"\",\n" +
            "        \"isPoliticians\":\"F\",\n" +
            "        \"isValid\":\"T\",\n" +
            "        \"isDel\":\"F\",\n" +
            "        \"operateState\":\"1\",\n" +
            "        \"validDate\":\"\",\n" +
            "        \"filler1\":\"\",\n" +
            "        \"filler2\":\"\",\n" +
            "        \"filler3\":\"\",\n" +
            "        \"filler4\":\"\",\n" +
            "        \"createDate\":\"2018-05-17 09:57:49\",\n" +
            "        \"lastModifyDate\":\"\",\n" +
            "        \"lastModifyOperator\":\"\",\n" +
            "        \"remarks\":\"\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"sortField\":null,\n" +
            "        \"sortOrder\":null,\n" +
            "        \"blacklistId\":\"11411880\",\n" +
            "        \"blacklistType\":\"1\",\n" +
            "        \"sanCode\":\"1\",\n" +
            "        \"sanName\":\"\",\n" +
            "        \"accountType\":\"I\",\n" +
            "        \"certificateType\":\"0\",\n" +
            "        \"certificateNumber\":\"001975154LS033\",\n" +
            "        \"clientName\":\"\",\n" +
            "        \"clientEnglishName\":\"Virgilio Pedro Samussongo\",\n" +
            "        \"nationality\":\"ANGOL\",\n" +
            "        \"birthday\":\"\",\n" +
            "        \"birthCountry\":\"\",\n" +
            "        \"gender\":\"M\",\n" +
            "        \"lastOccupation\":\"Member, National Assembly, UNITA, Lunda Sul\",\n" +
            "        \"residenceCountry\":\"\",\n" +
            "        \"isPoliticians\":\"F\",\n" +
            "        \"isValid\":\"T\",\n" +
            "        \"isDel\":\"F\",\n" +
            "        \"operateState\":\"1\",\n" +
            "        \"validDate\":\"\",\n" +
            "        \"filler1\":\"\",\n" +
            "        \"filler2\":\"\",\n" +
            "        \"filler3\":\"\",\n" +
            "        \"filler4\":\"\",\n" +
            "        \"createDate\":\"2018-05-17 09:57:49\",\n" +
            "        \"lastModifyDate\":\"\",\n" +
            "        \"lastModifyOperator\":\"\",\n" +
            "        \"remarks\":\"\"\n" +
            "    }\n" +
            "]";
    @Test
    public  void testJson() {
//        JSONObject myJson = JSONObject.fromObject(json);
//        System.out.println(myJson);
        String json="{\"a\":\"a\",\"b\":\"b\",\"c\":\"c\"}";
        JSONObject jsonObject = (JSONObject) JSON.parse(json);

        System.out.println(jsonObject.get("d"));

    }
}
