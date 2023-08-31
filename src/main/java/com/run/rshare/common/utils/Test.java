package com.run.rshare.common.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author xsd
 * @Date 2023/8/30
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        String json = "{\"MessageStatus\":\"0200\",\"ResponseParam\":{\"ResourceInfos\":[{\"DataInfo\":[[\"R01000022000000000001\",\"张三\",\"1\",\"11000000000000001\",\"20160108112211\"],[\"R01000022000000000002\",\"张三\",\"1\",\"11000000000000002\",\"20170108112222\"]],\"DataItems\":[{\"Fmt\":\"\",\"Name\":\"\"}],\"ResourceName\":\"R-010000220000-00000001\",\"x-rshare-data-path\":\"$.ResponseParam.ResourceInfos[0].DataInfo[*]\",\"x-rshare-fields-path\":\"$.ResponseParam.ResourceInfos[0].DataItems[*].Name\"}],\"MessageSequence\":\"2019010714141200001\",\"Remark\":\"正常\"}}";

        // 构建字段列表
        List<String> newFieldList = new ArrayList<>();
        newFieldList.add("XXZJBH");
        newFieldList.add("XM");
        newFieldList.add("XBDM");
        newFieldList.add("GMSFZHM");
        newFieldList.add("DJSJ");
        // Parse the JSON
        DocumentContext document = JsonPath.parse(json);

        // Replace the field list in "x-rshare-fields-path"
        document.set("$.ResponseParam.ResourceInfos[0].x-rshare-fields-path", newFieldList);

        // Update the "Name" values in "DataItems"
        List<String> nameList = document.read("$.ResponseParam.ResourceInfos[0].DataItems[*].Name");
        for (int i = 0; i < nameList.size(); i++) {
            document.set("$.ResponseParam.ResourceInfos[0].DataItems[" + i + "].Name", newFieldList.get(i));
        }
        System.out.println(document.jsonString());
    }
}

