package com.run.rshare.common.agreement.document;

/**
 * @ClassName Servers
 * @Description: ����һ��Server��������飬 �ṩ����������������Ϣ�����û���ṩservers���Ի�����һ��������
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class Servers {
    /**
     * ��ѡ. ָ��Ŀ��������URL��ַ�����URL��ַ֧�ַ������������ҿ��������·������ʾ����·��������ڱ��ĵ����ڵ�·��
     */
    private String url;
    /**
     * һ����ѡ���ַ���������������URL��ַ
     */
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
