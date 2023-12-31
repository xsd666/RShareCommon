package com.run.rshare.common.agreement.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.run.rshare.common.agreement.ServiceRequest;
import com.run.rshare.common.agreement.ServiceResponse;
import com.run.rshare.common.agreement.document.OpenApiDocument;
import com.run.rshare.common.agreement.document.OpenApiResponse;
import com.run.rshare.common.agreement.document.OpenApiUtil;
import com.run.rshare.common.agreement.document.Servers;
import com.run.rshare.common.agreement.type.FieldInfo;
import com.run.rshare.common.agreement.type.ServiceInfo;
import com.run.rshare.model.Result;
import io.swagger.models.HttpMethod;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.json.schema.*;
import io.vertx.json.schema.common.SchemaRouterImpl;
import io.vertx.json.schema.draft7.Draft7SchemaParser;
import io.vertx.junit5.VertxExtension;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

@ExtendWith(VertxExtension.class)
public class OpenAPI30Test {

    private static Logger LOG = LoggerFactory.getLogger(OpenAPI30Test.class);

    OpenAPI30 openAPI30 = new OpenAPI30();

    /*@Test
    public void testCheckRequireSchema() throws Exception {
        openAPI30.checkRequireSchema();
    }

    @Test
    public void testCheckResponseSchema() throws Exception {
        openAPI30.checkResponseSchema();
    }

    @Test
    public void testGetResponseParam() throws Exception {
        List<FieldInfo> result = openAPI30.getResponseParam("id");
        Assert.assertEquals(Arrays.<FieldInfo>asList(new FieldInfo()), result);
    }

    @Test
    public void testIsValid() throws Exception {
        openAPI30.isValid();
    }

    @Test
    public void testGetRequestParamOrigin() throws Exception {
        FileReader fileReader1 = new FileReader("classpath:specification/simpleSchema.json");
        String schemaJson = fileReader1.readString();
        Validator validator = Validator.create(
                JsonSchema.of(new JsonObject(schemaJson)),
                new JsonSchemaOptions()
                        .setBaseUri("https://www.run.com")
                        .setDraft(Draft.DRAFT202012)
                        .setOutputFormat(OutputFormat.Basic));

        FileReader fileReader2 = new FileReader("classpath:data/251.1.request.json");
        String jsonContent = fileReader2.readString();
        OutputUnit res = validator.validate(new JsonObject(jsonContent));

        // Should be fine!
        res.checkValidity();
    }



    @Test
    public void testGetRequestParam() throws Exception {
        List<FieldInfo> result = openAPI30.getRequestParam("id");
        Assert.assertEquals(Arrays.<FieldInfo>asList(new FieldInfo()), result);
    }

    @Test
    public void testTryRun() throws Exception {
        openAPI30.tryRun();
    }

    @Test
    public void testCreateFromServiceConfig() throws Exception {
        String result = openAPI30.createFromServiceConfig(new ServiceInfo());
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testBuildServiceRequest() throws Exception {
        ServiceRequest result = openAPI30.buildServiceRequest(new HashMap<String, String>() {{
            put("String", "String");
        }});
        Assert.assertEquals(new ServiceRequest(), result);
    }

    @Test
    public void testBuildServiceResponse() throws Exception {
        ServiceResponse result = openAPI30.buildServiceResponse("result");
        Assert.assertEquals(new ServiceResponse(), result);
    }

    @Test
    public void testBuildServiceRequest2() throws Exception {
    }

    @Test
    public void testBuildServiceResponse2() throws Exception {
    }

    @Test
    public void getJSONBBTag() throws Exception {
        FileReader fileReader = new FileReader("classpath:data/251.1.response.json");
        String jsonBBData = fileReader.readString();

        //Object fieldsPath = JSONPath.eval(jsonBBData,"$.ResponseParam.ResourceInfos[0].x\\-rshare\\-fields\\-path");
        Object fieldsPath = JSONPath.eval(jsonBBData, "$.ResponseParam..x\\-rshare\\-fields\\-path");
        System.out.println("--????·??");
        System.out.println("type:" + fieldsPath.getClass());
        System.out.println("value:" + ((ArrayList<Object>) fieldsPath).get(0));
        String thePath = ((ArrayList<Object>) fieldsPath).get(0).toString();

        System.out.println("--?????б?");
        Object fields = JSONPath.eval(jsonBBData, thePath);
        System.out.println("type:" + fields.getClass());
        System.out.println("value:" + fields);

        //fieldsPath = JSONPath.eval(jsonBBData,"$.ResponseParam.ResourceInfos[0].x\\-rshare\\-data\\-path");
        fieldsPath = JSONPath.eval(jsonBBData, "$.ResponseParam..x\\-rshare\\-data\\-path");
        System.out.println("--??·??");
        System.out.println("type:" + fieldsPath.getClass());
        System.out.println("value:" + ((ArrayList<Object>) fieldsPath).get(0));
        thePath = ((ArrayList<Object>) fieldsPath).get(0).toString();

        System.out.println("--???б?");
        fields = JSONPath.eval(jsonBBData, thePath);
        System.out.println("type:" + fields.getClass());
        System.out.println("value:" + fields);
    }

    @Test
    public void getJSONTag() throws Exception {
        FileReader fileReader = new FileReader("classpath:data/third.example.json");
        String jsonBBData = fileReader.readString();

        Object fieldsPath = JSONPath.eval(jsonBBData, "$.x\\-rshare\\-fields\\-path");
        System.out.println("--????·??");
        System.out.println("type:" + fieldsPath.getClass());
        System.out.println("value:" + fieldsPath);
        String thePath = fieldsPath.toString();

        System.out.println("--?????б?");
        Object fields = JSONPath.eval(jsonBBData, thePath);
        System.out.println("type:" + fields.getClass());
        System.out.println("value:" + ((JSONArray) fields).getJSONObject(0).keySet());

        fieldsPath = JSONPath.eval(jsonBBData, "$.x\\-rshare\\-data\\-path");
        System.out.println("--??·??");
        System.out.println("type:" + fieldsPath.getClass());
        System.out.println("value:" + fieldsPath);
        thePath = fieldsPath.toString();

        System.out.println("--???б?");
        fields = JSONPath.eval(jsonBBData, thePath);
        System.out.println("type:" + fields.getClass());
        System.out.println("value:" + fields);
    }

    @Test
    public void getJSONPositionInfo() throws Exception {
        String path1 = "$.ResponseParam.ResourceInfos[0].DataItems[*].name";
        String path2 = "$.ResponseParam.ResourceInfos[0].DataInfos[*]";
        String path3 = "$.data[*]";
        String path4 = "$.data[*]";

        FileReader fileReader = new FileReader("classpath:data/251.1.response.json");
        String jsonBBData = fileReader.readString();

        FileReader fileReader1 = new FileReader("classpath:data/third.example.json");
        String jsonExData = fileReader1.readString();

        Configuration conf = Configuration.defaultConfiguration();
        ReadContext ctx = JsonPath.using(conf).parse(jsonBBData);
        // ???JSONPath?????? "bookstore" ?????????????
        Object titles = ctx.read("$.ResponseParam.ResourceInfos[0].DataItems[*].Name");

        // ??????
        System.out.println("type:" + titles.getClass());
        System.out.println("value:");
    }

    @Test
    public void getJSONPositionInfoByFastJSON() throws Exception {
        String path1 = "$.ResponseParam.ResourceInfos[0].DataItems[*].name";
        String path2 = "$.ResponseParam.ResourceInfos[0].DataInfos[*]";
        String path3 = "$.data[*]";
        String path4 = "$.data[*]";

        FileReader fileReader = new FileReader("classpath:data/251.1.response.json");
        String jsonBBData = fileReader.readString();

        FileReader fileReader1 = new FileReader("classpath:data/third.example.json");
        String jsonExData = fileReader1.readString();

        // ???JSONPath?????? "bookstore" ?????????????
        Object titles = JSONPath.eval(jsonBBData, "$.ResponseParam.ResourceInfos[0].DataItems[*].Name");

        // ??????
        System.out.println("--?BB??????");
        System.out.println("type:" + titles.getClass());
        System.out.println("value:" + titles.toString());

        System.out.println("--?BB???????");
        titles = JSONPath.eval(jsonBBData, "$.ResponseParam.ResourceInfos[0].DataInfo[*]");
        // ???JSONPath?????? "bookstore" ?????????????

        // ??????
        System.out.println("type:" + titles.getClass());
        System.out.println("value:" + titles.toString());

        // ??????
        System.out.println("--???????");
        titles = JSONPath.eval(jsonExData, "$.data[*][0]");
        System.out.println("type:" + titles.getClass());
        System.out.println("value:" + ((JSONObject) titles).keySet());

        System.out.println("--????????");
        titles = JSONPath.eval(jsonExData, "$.data[*]");
        // ???JSONPath?????? "bookstore" ?????????????

        // ??????
        System.out.println("type:" + titles.getClass());
        System.out.println("value:" + titles.toString());
    }*/

    /*@Test
    public void validation() throws Exception {
        String utf8String = FileUtil.readUtf8String(new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\postBBDataTest1_2023-09-02.json"));
        OpenApiDocument openApiDocument = JSONObject.parseObject(utf8String, OpenApiDocument.class);
        JSONObject requestJSON = openApiDocument.fetchRequestJSON();
        String requestData = "{\n" +
                "  \"From\": \"370000000001\",\n" +
                "  \"To\": \"110000000001\",\n" +
                "  \"MessageSequence\": \"201901071414120001\",\n" +
                "  \"RequestParam\": {\n" +
                "    \"Condition\": \"XM='张三'\",\n" +
                "    \"ResourceInfos\": [\n" +
                "      {\n" +
                "        \"ResourceName\": \"R-010000220000-00000001\",\n" +
                "        \"DataItems\": [\n" +
                "          {\n" +
                "            \"Name\": \"XXZJBH1\",\n" +
                "            \"Fmt\": \"\"\n" +
                "          },\n" +
                "\t\t  {\n" +
                "            \"Name\": \"XXZJBH2\",\n" +
                "            \"Fmt\": \"\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"OtherCondition\": {\n" +
                "      \"MaxReturnNum\": \"2\",\n" +
                "      \"AsyncBoolean\": \"0\",\n" +
                "      \"AsyncOnceReturnNum\": \"2\",\n" +
                "      \"AsyncQuery\": \"\",\n" +
                "      \"CallbackID\": \"\",\n" +
                "      \"CodeMode\": \"0\",\n" +
                "      \"SortResults\": \"DJSJ+,XM-\"\n" +
                "    }\n" +
                "  }";
        Vertx vertx = Vertx.vertx();
        SchemaParser parser = SchemaParser.createDraft7SchemaParser(
                SchemaRouter.create(vertx, new SchemaRouterOptions())
        );
        SchemaRouter schemaRouter = new SchemaRouter();
        SchemaParserBuilder builder = Draft7SchemaParser.create(schemaRouter)
                .w

        // 解析 JSON Schema
        Schema schema = parser.parse(schemaJson);
        Optional<OpenApiResponse> openApiResponse = openApiDocument.fetchOpenApiResponseOptional("200");
        JSONObject fetchResponseJSON = openApiDocument.fetchResponseJSON(openApiResponse);
    }
*/

    @Test
    public void testSchemaSelfValidate() throws Exception {
        String requestData = "{\"From\": \"370000000001\",\"To\": \"110000000001\",\"MessageSequence\": \"201901071414120001\",\"RequestParam\": {\"Condition\": \"XM='张三'\",\"ResourceInfos\": [{\"ResourceName\": \"R-010000220000-00000001\",\"DataItems\": [{\"Name\": \"XXZJBH\",\"Fmt\": \"\"},{\"Name\": \"XXZJBH\",\"Fmt\": \"\"}]}],\"OtherCondition\": {\"MaxReturnNum\": \"2\",\"AsyncBoolean\": \"0\",\"AsyncOnceReturnNum\": \"2\",\"AsyncQuery\": \"\",\"CallbackID\": \"\",\"CodeMode\": \"0\",\"SortResults\": \"DJSJ+,XM-\"}}}";
        String utf8String = FileUtil.readUtf8String(new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\postBBDataTest1_2023-09-04.json"));
        Result<Boolean> booleanResult1 = OpenApiUtil.validateRequestParams(utf8String, requestData);
        LOG.info("请求体校验结果为:[{}]", JSON.toJSONString(booleanResult1));
        String responseData = "{\"MessageStatus\": \"0200\",\"MessageSequence\": \"2019010714141200001\",\n" +
                "\"Remark\": \"正常\",\n" +
                "\"ResponseParam\": {\n" +
                "\"ResourceInfos\": [\n" +
                "{\n" +
                "\"ResourceName\": \"R-010000220000-00000001\",\n" +
                "\"x-rshare-fields-path\": \"$.ResponseParam.ResourceInfos[0].DataItems[*].Name\",\n" +
                "\"DataItems\": [\n" +
                "  {\n" +
                "    \"Name\": \"XXZJBH\",\n" +
                "    \"Fmt\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Name\": \"XM\",\n" +
                "    \"Fmt\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Name\": \"XBDM\",\n" +
                "    \"Fmt\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Name\": \"GMSFZHM\",\n" +
                "    \"Fmt\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Name\": \"DJSJ\",\n" +
                "    \"Fmt\": \"d14\"\n" +
                "  }\n" +
                "],\n" +
                "\"x-rshare-data-path\": \"$.ResponseParam.ResourceInfos[0].DataInfo[*]\",\n" +
                "\"DataInfo\": [\n" +
                "  [\n" +
                "    \"R01000022000000000001\",\n" +
                "    \"张三\",\n" +
                "    \"1\",\n" +
                "    \"11000000000000001\",\n" +
                "    \"20160108112211\"\n" +
                "  ],\n" +
                "  [\n" +
                "    \"R01000022000000000002\",\n" +
                "    \"张三\",\n" +
                "    \"1\",\n" +
                "    \"11000000000000002\",\n" +
                "    \"20170108112222\"\n" +
                "  ]\n" +
                "]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        Result<Boolean> booleanResult2 = OpenApiUtil.validateResponse(utf8String, responseData);

        LOG.info("响应体校验结果为:[{}]", JSON.toJSONString(booleanResult2));

    }

    @Test
    public void excelToSchema() throws Exception {
        LOG.info("===========postBBDataTest1请求开始=============");
        File file1 = new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\通用查询_1.xlsx");
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("SenderID", "400653");
        paramsMap.put("ServiceResourceId", "S-320300000000-0400-00001");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("Name", "XSD1");
        jsonObject1.put("Fmt", "");
        jsonArray.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Name", "XSD2");
        jsonObject2.put("Fmt", "");
        jsonArray.add(jsonObject2);
        paramsMap.put("DataItems", jsonArray);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ResourceName","R-010000220000-00000001");
        resultMap.put("DataItems","[{\"Name\": \"XXZJBH\", \"Fmt\": \"\"},{\"Name\": \"XM\",\"Fmt\": \"\"},{\"Name\": \"GMSFZHM\",\"Fmt\": \"\"},{\"Name\": \"DJSJ\",\"Fmt\": \"\"}]");
        resultMap.put("DataInfo","[[\"R01000022000000000001\",\"张三\",\"1\",\"11000000000000001\",\"20160108112211\"],[\"R01000022000000000002\",\"张三\",\"1\",\"11000000000000002\",\"20170108112222\"]]");

        excelToSchema1(file1, "postBBDataTest1", paramsMap, HttpMethod.POST.name(), resultMap);
        LOG.info("===========postBBDataTest1请求结束=============");

        LOG.info("========================================================================");
        LOG.info("========================================================================");

        LOG.info("===========postThirdTest1请求开始=============");
        File file2 = new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\外部服务.xlsx");
        Map<String, Object> paramsMap2 = new HashMap<>();
        paramsMap2.put("SenderID", "400653");
        paramsMap2.put("ServiceResourceId", "S-320300000000-0400-00001");
        String strategy = "{\n" +
                "      \"startTime\": \"2021/10/15\",\n" +
                "      \"endTime\": \"2021/10/15\",\n" +
                "      \"crontab\": \"0 0/10 * * * ?\"\n" +
                "   }";
        paramsMap2.put("strategy",JSONObject.parseObject(strategy));

        String data = "[{ \"id\": 1, \"name\": \"Item 1\" },{ \"id\": 2, \"name\": \"Item 2\" }]";
        JSONArray jsonArray1 = JSONArray.parseArray(data);
        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("data",jsonArray1);
        excelToSchema1(file2, "postThirdTest1", paramsMap2, HttpMethod.POST.name(), resultMap2);

    }


    public void excelToSchema1(File file, String operationId, Map<String, Object> paramsMap, String httpMethod, Map<String, Object> resultMap) throws Exception {
        JSONObject fileContent = OpenApiUtil.importExcelRegFile(file);
        JSONObject reqAndRespData = fileContent.getJSONObject("data");
        String fileName = file.getName();
        String name = fileName.split(".json")[0];
        //测试
        String desc = "通用查询";
        //暂时设置为1.0.1
        String version = "1.0.1";
        //暂时设置为空
        List<Servers> servers = Lists.newArrayList();
        String defaultSchema = OpenApiUtil.reqAndRespToOpenApiJson(reqAndRespData, name, desc, version, servers, operationId, httpMethod);
        String schemaName = operationId + "_" + DateUtil.format(new Date(), "yyyy-MM-dd") + ".json";
        File schemaNameFile = new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\" + schemaName);
        FileUtil.writeString(defaultSchema, schemaNameFile, "utf-8");

        OpenApiDocument openApiDocument = JSONObject.parseObject(defaultSchema, OpenApiDocument.class);

        JSONObject RequestHeader = openApiDocument.fetchRequestHeader(paramsMap);
        String requestHeaderJSONString = JSONObject.toJSONString(RequestHeader, SerializerFeature.WriteMapNullValue);
        LOG.info("请求头体json:\r\n" + requestHeaderJSONString);

        JSONObject requestJSON = openApiDocument.fetchEmptyRequestJSON();
        String toJSONString = JSONObject.toJSONString(requestJSON, SerializerFeature.WriteMapNullValue);
        LOG.info("服务请求参数体json:\r\n" + toJSONString);
        LOG.info("============服务请求参数json打印结束============");


        //todo RequestParam.ResourceInfos[0].DataItems[0].Name
        //todo 中是以val值的形式，规约中没有
       /* List<FieldInfo> requestInfoList = OpenApiUtil.getRequestFieldInfoByOpenApiJson(defaultSchema);
        LOG.info("requestInfoList:\r\n" + JSONObject.toJSONString(requestInfoList, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务请求字段打印结束============");*/


        //取请求结果码为200的
        Optional<OpenApiResponse> openApiResponse = openApiDocument.fetchOpenApiResponseOptional("200");
        JSONObject responseHeader = openApiDocument.fetchResponseHeader(openApiResponse, new HashMap<>());
        LOG.info("ResponseHeader:\r\n" + JSONObject.toJSONString(responseHeader, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应头打印结束============");

        JSONObject responseJSON = openApiDocument.fetchEmptyResponseJSON(openApiResponse);
        LOG.info("responseJSON:\r\n" + JSONObject.toJSONString(responseJSON, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应json打印结束============");

        /*List<FieldInfo> responseFieldInfos = OpenApiUtil.getResponseFieldInfoByOpenApiJson(defaultSchema, "200");
        LOG.info("responseFieldInfos:\r\n" + JSONObject.toJSONString(responseFieldInfos, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应字段打印结束============");*/
        ServiceRequest buildServiceRequest = OpenApiUtil.buildServiceRequest(defaultSchema, paramsMap);
        LOG.info("ServiceRequest:\r\n" + JSONObject.toJSONString(buildServiceRequest, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务请求体打印结束============");

        ServiceResponse serviceResponse = OpenApiUtil.buildServiceResponse(defaultSchema, resultMap);
        LOG.info("ServiceResponse:\r\n" + JSONObject.toJSONString(serviceResponse, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应体打印结束============");
    }


}
