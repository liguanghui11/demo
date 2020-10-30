package com.example.demo.utils;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：ligh
 * @date ：Created in 2020/7/22 0022 16:46
 */
public class EasyExcelRead {

    public static void main(String[] args) {
        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read("E:\\协议\\e文件\\河南鼎龙家具有限公司—报价明细表.xlsx").sheet().doReadSync();

        List<List<Object>> list = new ArrayList<List<Object>>();
        for (Map<Integer, String> map : listMap) {
            // 返回每条数据的键值对 表示所在的列 和所在列的值

            List<Object> data = new ArrayList<Object>();
            if(null != map.get(0) ){
                data.addAll(map.values());
                list.add(data);

            } else {
                List sub = list.get(list.size() -1);
                sub.set(6, sub.get(6) + "   " + map.get(6));
            }

        }

        // 写法1
        String fileName = "E:\\协议\\e文件\\河南鼎龙家具有限公司—报价明细表2.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName).sheet("明细").doWrite(list);

    }
}
