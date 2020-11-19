package com.soft1851.files.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName FileResource
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/19
 **/
@Component
@PropertySource("classpath:file-${spring.profiles.active}.properties")
@ConfigurationProperties(prefix = "file")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileResource {
    private  String host;
    private  String endpoint;
    private  String  bucketName;
    private  String objectName;
    private  String ossHost;

}