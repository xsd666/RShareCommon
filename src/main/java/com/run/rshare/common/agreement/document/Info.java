package com.run.rshare.common.agreement.document;

/**
 * @ClassName Info
 * @Description: ��������ṩAPI��Ԫ���ݡ�����ͻ�����Ҫʱ���ܻ��õ���ЩԪ���ݣ����ҿ��ܻᱻ�����ڱ༭���߻����ĵ����ɹ����С�
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class Info {
    /**
     * ��Ӧ�õļ������
     */
    private String description;
    /**
     * ��ѡ. API�ĵ��İ汾��Ϣ
     */
    private String version;
    /**
     * ��ѡ. Ӧ�õ�����
     */
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
