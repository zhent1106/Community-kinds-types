package com.soft1851.files.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadService
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/19
 **/
public interface UploadService {
    /**
     * fdfs上传
     * @param file
     * @param fileName
     * @return
     * @throws Exception
     */
    String uploadFdfs(MultipartFile file,String fileName) throws  Exception;

    /**
     * OSS上传文件
     * @param file
     * @param useId
     * @param fileExtName
     * @return
     * @throws Exception
     */
    public String uploadOSS(MultipartFile file,String useId,String fileExtName) throws  Exception;
}
