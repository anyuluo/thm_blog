package cn.thm.common.properties;

import lombok.Data;

/**
 * 七牛云配置
 *
 * @author thm
 * @date 2019-09-19
 */
@Data
public class QiniuProperties {

    /**
     * AccessKey
     */
    private String ak;

    /**
     * SecretKey
     */
    private String sk;

    /**
     * BucketName
     */
    private String bn;

    /**
     * 外链
     */
    private String url;
}
