package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：ligh
 * @date ：Created in 2020/11/2 0002 15:16
 */
public class testlambda {


    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("time", "dkjfdlsj");
        map.put("aa","dfdsagfsdgffdsg");
        map.put("userName","2");
        map.put("orderNo","222222");

        Map map2 = new HashMap();
        map2.put("userName","l");
        map2.put("orderNo","222222");

        List<Map> list = new ArrayList();
        list.add(map);
        list.add(map2);

        list.stream().filter(map1 -> "2".equals(map1.get("userName"))).forEach(
                map0 -> {
                    System.out.println(map2);
                    if ("1".equals(map0.get("userName"))){
                        return;
                    }
                    System.out.println(map0);
                }

        );


    }

}
