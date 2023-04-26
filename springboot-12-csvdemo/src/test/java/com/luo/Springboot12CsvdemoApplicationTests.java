package com.luo;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springboot12CsvdemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testCsv(){
            List resultList = new ArrayList();
            CSVPrinter printer = null;
            try {
                Object[] objects = null;
                for (int i = 0; i < 10; i++) {
                    List list = new ArrayList();
                    list.add("张三");
                    list.add(20);
                    resultList.add(list);
                }
                //  导出为CSV文件，文件默认格式为utf-8
                //  excel只能直接打开ANSI编码的csv文件，如果csv文件是utf-8编码的，excel打开会乱码。
                //  在简体中文Windows操作系统中，ANSI 编码代表 GBK 编码。
                //  GBK中文2个字节，英文1个字节；utf-8中文3个字节，英文1个字节
                FileWriter writer = new FileWriter("D:/test.csv");
                printer = CSVFormat.EXCEL.print(writer);
                Object[] cells = {"name", "age"};
                printer.printRecord(cells);
                for (int i = 0; i < resultList.size(); i++) {
                    List o = (List) resultList.get(i);
                    objects = o.toArray();
                    printer.printRecord(objects);
                    System.out.println(objects);

                }
                printer.flush();
                printer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void Test1() {
        String filePath = "D://b.csv";
        FileOutputStream fos = null;
        CsvWriter writer = null;
        try {
            File file = new File(filePath);
            // 创建 utf-8-bom 格式的csv文件
            // 先写入 UTF-8-BOM 编码头内容
            byte[] uft8bom = {(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
            fos = new FileOutputStream(file, true);
            fos.write(uft8bom);
            // 然后写入文件内容
            writer = CsvUtil.getWriter(file, CharsetUtil.CHARSET_UTF_8, true);
            List<String> header = ListUtil.toList("数据时间", "温度(℃)", "压力(MPa)", "流量(t/h)");
            writer.write(header.toArray(new String[0]));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            IoUtil.close(fos);
            IoUtil.close(writer);
        }
    }


}
