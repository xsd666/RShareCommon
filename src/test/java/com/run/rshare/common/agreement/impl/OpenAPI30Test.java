package com.run.rshare.common.agreement.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
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
import com.run.rshare.common.utils.ReqAndRespUtil;
import io.swagger.models.HttpMethod;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.json.schema.*;
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

    @Test
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
    public void testSchemaSelfValidate(Vertx vertx) throws Exception {
        JsonSchemaOptions SCHEMA_OPTIONS = new JsonSchemaOptions().setDraft(Draft.DRAFT202012).setBaseUri("app://");
        SchemaRepository repository = SchemaRepository.create(SCHEMA_OPTIONS);

        FileReader fileReader1 = new FileReader("classpath:specification/251Whole.json");
        String schemaJson = fileReader1.readString();

        OutputUnit ou = repository
                .preloadMetaSchema(vertx.fileSystem())
                .validator("https://json-schema.org/draft/2020-12/schema")
                .validate(new JsonObject(schemaJson));

        if (!ou.getValid()) {
            System.out.println(ou.getError());
        }
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
    }

    @Test
    public void excelToSchema() throws Exception {
        JSONObject fileContent = ReqAndRespUtil.externalRegFile("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\通用查询.xlsx");
        JSONObject reqAndRespData = fileContent.getJSONObject("data");
        //试
        String name = "通用查询";
        //测试
        String desc = "通用查询";
        //暂时设置为1.0.1
        String version = "1.0.1";
        //暂时设置为空
        List<Servers> servers = Lists.newArrayList();
        String operationId = "postBBDataTest";
        String httpMethod = HttpMethod.POST.name();
        String defaultSchema = OpenApiUtil.reqAndRespToOpenApiJson(reqAndRespData, name, desc, version, servers, operationId, httpMethod);
        String schemaName = operationId + "_" + DateUtil.format(new Date(), "yyyy-MM-dd") + ".json";
        File schemaNameFile = new File("D:\\code\\2023\\RShare_V2.0R\\RShareCommon\\" + schemaName);
        FileUtil.writeString(defaultSchema, schemaNameFile, "utf-8");
        LOG.info("============生成服务规约json结束============");

        OpenApiDocument openApiDocument = JSONObject.parseObject(defaultSchema, OpenApiDocument.class);
        JSONObject requestJSON = openApiDocument.fetchRequestJSON();
        String toJSONString = JSONObject.toJSONString(requestJSON, SerializerFeature.WriteMapNullValue);
        LOG.info("服务请求参数体json:" + toJSONString);
        LOG.info("============服务请求参数json打印结束============");

        //todo 通用查询中example是有字段的,规约参数中
        //todo RequestParam.ResourceInfos[0].DataItems[0].Name
        //todo 中是以val值的形式，规约中没有
        List<FieldInfo> requestInfoList = OpenApiUtil.getRequestFieldInfoByOpenApiJson(defaultSchema);
        LOG.info("requestInfoList:" + JSONObject.toJSONString(requestInfoList, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务请求字段打印结束============");


        //取请求结果码为200的
        Optional<OpenApiResponse> openApiResponse = openApiDocument.fetchOpenApiResponseOptional("200");
        JSONObject responseHeader = openApiDocument.fetchResponseHeader(openApiResponse);
        LOG.info("ResponseHeader:" + JSONObject.toJSONString(responseHeader, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应头打印结束============");

        JSONObject responseJSON = openApiDocument.fetchResponseJSON(openApiResponse);
        LOG.info("responseJSON:" + JSONObject.toJSONString(responseJSON, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应json打印结束============");

        List<FieldInfo> responseFieldInfos = OpenApiUtil.getResponseFieldInfoByOpenApiJson(defaultSchema, "200");
        LOG.info("responseFieldInfos:" + JSONObject.toJSONString(responseFieldInfos, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务响应字段打印结束============");

        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("SenderID","400653");
        paramsMap.put("ServiceResourceId","S-320300000000-0400-00001");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("Name","XSD1");
        jsonObject1.put("Fmt","");
        jsonArray.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Name","XSD2");
        jsonObject2.put("Fmt","");
        jsonArray.add(jsonObject2);
        paramsMap.put("DataItems",jsonArray);
        ServiceRequest buildServiceRequest = OpenApiUtil.buildServiceRequest(defaultSchema, paramsMap);
        LOG.info("ServiceRequest:"+JSONObject.toJSONString(buildServiceRequest, SerializerFeature.WriteMapNullValue));
        LOG.info("============服务请求体打印结束============");
    }


}
