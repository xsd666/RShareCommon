package com.run.rshare.common.agreement.document;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName OpenAPIDocument
 * @Description: OpenAPI ����
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class OpenApiDocument {
    /**
     * ��ѡ. ����ַ��������ǿ���API�淶�汾���ᵽ�ķ������廯�汾�Ź淶�İ汾�š�openapi�ֶ�Ӧ�ñ����߻��߿ͻ����������� OpenAPI �ĵ������ֵ��API info.version�ַ���û�й�����
     */
    protected String openapi = "3.0.1";
    /**
     * ��ѡ�����ֶ��ṩAPI��ص�Ԫ���ݡ���ع��߿�����Ҫ����ֶΡ�
     */
    protected Info info;
    /**
     * ����һ��Server��������飬 �ṩ����������������Ϣ�����û���ṩservers���Ի�����һ��������
     */
    protected List<Servers> servers;
    /**
     * ��ѡ�������ṩ��API��Ч��·���Ͳ�����
     */
    protected Map<String, OpenApiPath> paths;

    public String getOpenapi() {
        return openapi;
    }

    public void setOpenapi(String openapi) {
        this.openapi = openapi;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Servers> getServers() {
        return servers;
    }

    public void setServers(List<Servers> servers) {
        this.servers = servers;
    }

    public Map<String, OpenApiPath> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, OpenApiPath> paths) {
        this.paths = paths;
    }

    public void paths(String key, OpenApiPath path) {
        if (this.paths == null) {
            this.paths = new LinkedHashMap<String, OpenApiPath>();
        }
        this.paths.put(key, path);
    }

}
