package com.yy.provider1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import com.yy.provider1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class streamTest1 {

    @Test
    public void test5() {
        Random random = new Random();
        List list = new ArrayList<User>() {
            {
                for (int i = 1; i <= 5; i++) {
                    add(new User("NO:" + i, random.nextInt(50) + 50));
                }
            }
        };


        Object collect = list.stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User u) {
                return u.getCost() >= 80;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);

        Object collect1 = list.stream().filter(x -> x.getClass() != null).collect(Collectors.toList());


        System.out.println(collect1);


        list.forEach(user -> log.info(user.toString()));

        //按cost排序,升序
        list.sort(Comparator.comparing(User::getCost));

        log.info(list.toString());

        //按cost排序,降序
        list.sort(Comparator.comparing(User::getCost).reversed());
        log.info(list.toString());
    }

    @Test
    public void test4() {
        String[] players = {
                "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro", "Richard Gasquet", "John Isner"
        };

 /*       Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });*/
        Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));
        log.info(Arrays.toString(players));
    }

    @Test
    public void test3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("This is thread1");
            }
        });
        Thread thread2 = new Thread(() -> log.info("This is thread2"));
        thread1.run();
        thread2.run();
    }

    @Test
    public void test0() {
        String s = "  ";
        System.out.println(StringUtils.isEmpty(s));
        System.out.println(StringUtils.isBlank(s));
    }

    @Test
    public void streamTest1() throws UnsupportedEncodingException {
        String s = " {\n" +
                "    \"fileId\": \"group1/M01/2E/BA/CmAFGVv1HSuAYyDvAAAMOQI4hXI132.txt\",\n" +
                "    \"fileBytes\": \"W3sic29ydEZpZWxkIjpudWxsLCJzb3J0T3JkZXIiOm51bGwsImJsYWNrbGlzdElkIjoiMTE0MTE4ODAiLCJibGFja2xpc3RUeXBlIjoiMSIsInNhbkNvZGUiOiIxIiwic2FuTmFtZSI6IiIsImFjY291bnRUeXBlIjoiSSIsImNlcnRpZmljYXRlVHlwZSI6IjAiLCJjZXJ0aWZpY2F0ZU51bWJlciI6IjAwMTk3NTE1NExTMDMzIiwiY2xpZW50TmFtZSI6IiIsImNsaWVudEVuZ2xpc2hOYW1lIjoiVmlyZ6iqbGlvIFBlZHJvIFNhbXVzc29uZ28iLCJuYXRpb25hbGl0eSI6IkFOR09MIiwiYmlydGhkYXkiOiIiLCJiaXJ0aENvdW50cnkiOiIiLCJnZW5kZXIiOiJNIiwibGFzdE9jY3VwYXRpb24iOiJNZW1iZXIsIE5hdGlvbmFsIEFzc2VtYmx5LCBVTklUQSwgTHVuZGEgU3VsIiwicmVzaWRlbmNlQ291bnRyeSI6IiIsImlzUG9saXRpY2lhbnMiOiJGIiwiaXNWYWxpZCI6IlQiLCJpc0RlbCI6IkYiLCJvcGVyYXRlU3RhdGUiOiIxIiwidmFsaWREYXRlIjoiIiwiZmlsbGVyMSI6IiIsImZpbGxlcjIiOiIiLCJmaWxsZXIzIjoiIiwiZmlsbGVyNCI6IiIsImNyZWF0ZURhdGUiOiIyMDE4LTA1LTE3IDA5OjU3OjQ5IiwibGFzdE1vZGlmeURhdGUiOiIiLCJsYXN0TW9kaWZ5T3BlcmF0b3IiOiIiLCJyZW1hcmtzIjoiIn0seyJzb3J0RmllbGQiOm51bGwsInNvcnRPcmRlciI6bnVsbCwiYmxhY2tsaXN0SWQiOiIxMTQxMTg4MCIsImJsYWNrbGlzdFR5cGUiOiIxIiwic2FuQ29kZSI6IjEiLCJzYW5OYW1lIjoiIiwiYWNjb3VudFR5cGUiOiJJIiwiY2VydGlmaWNhdGVUeXBlIjoiMCIsImNlcnRpZmljYXRlTnVtYmVyIjoiMDAxOTc1MTU0TFMwMzMiLCJjbGllbnROYW1lIjoiIiwiY2xpZW50RW5nbGlzaE5hbWUiOiJWaXJnqKpsaW8gUGVkcm8gU2FtdXNzb25nbyIsIm5hdGlvbmFsaXR5IjoiQU5HT0wiLCJiaXJ0aGRheSI6IiIsImJpcnRoQ291bnRyeSI6IiIsImdlbmRlciI6Ik0iLCJsYXN0T2NjdXBhdGlvbiI6Ik1lbWJlciwgTmF0aW9uYWwgQXNzZW1ibHksIFVOSVRBLCBMdW5kYSBTdWwiLCJyZXNpZGVuY2VDb3VudHJ5IjoiIiwiaXNQb2xpdGljaWFucyI6IkYiLCJpc1ZhbGlkIjoiVCIsImlzRGVsIjoiRiIsIm9wZXJhdGVTdGF0ZSI6IjEiLCJ2YWxpZERhdGUiOiIiLCJmaWxsZXIxIjoiIiwiZmlsbGVyMiI6IiIsImZpbGxlcjMiOiIiLCJmaWxsZXI0IjoiIiwiY3JlYXRlRGF0ZSI6IjIwMTgtMDUtMTcgMDk6NTc6NDkiLCJsYXN0TW9kaWZ5RGF0ZSI6IiIsImxhc3RNb2RpZnlPcGVyYXRvciI6IiIsInJlbWFya3MiOiIifSx7InNvcnRGaWVsZCI6bnVsbCwic29ydE9yZGVyIjpudWxsLCJibGFja2xpc3RJZCI6IjExNDExODgwIiwiYmxhY2tsaXN0VHlwZSI6IjEiLCJzYW5Db2RlIjoiMSIsInNhbk5hbWUiOiIiLCJhY2NvdW50VHlwZSI6IkkiLCJjZXJ0aWZpY2F0ZVR5cGUiOiIwIiwiY2VydGlmaWNhdGVOdW1iZXIiOiIwMDE5NzUxNTRMUzAzMyIsImNsaWVudE5hbWUiOiIiLCJjbGllbnRFbmdsaXNoTmFtZSI6IlZpcmeoqmxpbyBQZWRybyBTYW11c3NvbmdvIiwibmF0aW9uYWxpdHkiOiJBTkdPTCIsImJpcnRoZGF5IjoiIiwiYmlydGhDb3VudHJ5IjoiIiwiZ2VuZGVyIjoiTSIsImxhc3RPY2N1cGF0aW9uIjoiTWVtYmVyLCBOYXRpb25hbCBBc3NlbWJseSwgVU5JVEEsIEx1bmRhIFN1bCIsInJlc2lkZW5jZUNvdW50cnkiOiIiLCJpc1BvbGl0aWNpYW5zIjoiRiIsImlzVmFsaWQiOiJUIiwiaXNEZWwiOiJGIiwib3BlcmF0ZVN0YXRlIjoiMSIsInZhbGlkRGF0ZSI6IiIsImZpbGxlcjEiOiIiLCJmaWxsZXIyIjoiIiwiZmlsbGVyMyI6IiIsImZpbGxlcjQiOiIiLCJjcmVhdGVEYXRlIjoiMjAxOC0wNS0xNyAwOTo1Nzo0OSIsImxhc3RNb2RpZnlEYXRlIjoiIiwibGFzdE1vZGlmeU9wZXJhdG9yIjoiIiwicmVtYXJrcyI6IiJ9LHsic29ydEZpZWxkIjpudWxsLCJzb3J0T3JkZXIiOm51bGwsImJsYWNrbGlzdElkIjoiMTE0MTE4ODAiLCJibGFja2xpc3RUeXBlIjoiMSIsInNhbkNvZGUiOiIxIiwic2FuTmFtZSI6IiIsImFjY291bnRUeXBlIjoiSSIsImNlcnRpZmljYXRlVHlwZSI6IjAiLCJjZXJ0aWZpY2F0ZU51bWJlciI6IjAwMTk3NTE1NExTMDMzIiwiY2xpZW50TmFtZSI6IiIsImNsaWVudEVuZ2xpc2hOYW1lIjoiVmlyZ2lsaW8gUGVkcm8gU2FtdXNzb25nbyIsIm5hdGlvbmFsaXR5IjoiQU5HT0wiLCJiaXJ0aGRheSI6IiIsImJpcnRoQ291bnRyeSI6IiIsImdlbmRlciI6Ik0iLCJsYXN0T2NjdXBhdGlvbiI6Ik1lbWJlciwgTmF0aW9uYWwgQXNzZW1ibHksIFVOSVRBLCBMdW5kYSBTdWwiLCJyZXNpZGVuY2VDb3VudHJ5IjoiIiwiaXNQb2xpdGljaWFucyI6IkYiLCJpc1ZhbGlkIjoiVCIsImlzRGVsIjoiRiIsIm9wZXJhdGVTdGF0ZSI6IjEiLCJ2YWxpZERhdGUiOiIiLCJmaWxsZXIxIjoiIiwiZmlsbGVyMiI6IiIsImZpbGxlcjMiOiIiLCJmaWxsZXI0IjoiIiwiY3JlYXRlRGF0ZSI6IjIwMTgtMDUtMTcgMDk6NTc6NDkiLCJsYXN0TW9kaWZ5RGF0ZSI6IiIsImxhc3RNb2RpZnlPcGVyYXRvciI6IiIsInJlbWFya3MiOiIifSx7InNvcnRGaWVsZCI6bnVsbCwic29ydE9yZGVyIjpudWxsLCJibGFja2xpc3RJZCI6IjExNDExODgwIiwiYmxhY2tsaXN0VHlwZSI6IjEiLCJzYW5Db2RlIjoiMSIsInNhbk5hbWUiOiIiLCJhY2NvdW50VHlwZSI6IkkiLCJjZXJ0aWZpY2F0ZVR5cGUiOiIwIiwiY2VydGlmaWNhdGVOdW1iZXIiOiIwMDE5NzUxNTRMUzAzMyIsImNsaWVudE5hbWUiOiIiLCJjbGllbnRFbmdsaXNoTmFtZSI6IlZpcmdpbGlvIFBlZHJvIFNhbXVzc29uZ28iLCJuYXRpb25hbGl0eSI6IkFOR09MIiwiYmlydGhkYXkiOiIiLCJiaXJ0aENvdW50cnkiOiIiLCJnZW5kZXIiOiJNIiwibGFzdE9jY3VwYXRpb24iOiJNZW1iZXIsIE5hdGlvbmFsIEFzc2VtYmx5LCBVTklUQSwgTHVuZGEgU3VsIiwicmVzaWRlbmNlQ291bnRyeSI6IiIsImlzUG9saXRpY2lhbnMiOiJGIiwiaXNWYWxpZCI6IlQiLCJpc0RlbCI6IkYiLCJvcGVyYXRlU3RhdGUiOiIxIiwidmFsaWREYXRlIjoiIiwiZmlsbGVyMSI6IiIsImZpbGxlcjIiOiIiLCJmaWxsZXIzIjoiIiwiZmlsbGVyNCI6IiIsImNyZWF0ZURhdGUiOiIyMDE4LTA1LTE3IDA5OjU3OjQ5IiwibGFzdE1vZGlmeURhdGUiOiIiLCJsYXN0TW9kaWZ5T3BlcmF0b3IiOiIiLCJyZW1hcmtzIjoiIn1d\"\n" +
                "}";

        JSONObject json = (JSONObject) JSONObject.parse(s);
        String result = new String(Base64.decodeFast(json.getString("fileBytes")), "GBK");
        Map<String, List<String>> map = new HashMap<>();

        JSONArray jsonArray = JSON.parseArray(result);
        jsonArray.forEach(e -> {
            JSONObject jsonObject = (JSONObject) e;
            jsonObject.forEach((key, value) -> {
                List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
                list.add(jsonObject.getString(key));
            });
        });
        JSONObject o = (JSONObject) JSON.toJSON(map);

        System.out.println(o);
    }

    @Test
    public void testStream2() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

//        System.out.println(Arrays.toString(inputStream.toArray()));
//        [[1], [2, 3], [4, 5, 6]]
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        System.out.println(Arrays.toString(outputStream.toArray()));
//        [1, 2, 3, 4, 5, 6]
    }
}
