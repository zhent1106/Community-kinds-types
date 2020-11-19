package com.soft1851.files.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.soft1851.files.resource.FileResource;
import com.soft1851.files.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @ClassName UploadServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/19
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadServiceImpl implements UploadService {
    public final FastFileStorageClient fastFileStorageClient;
    public final FileResource fileResource;
    public  final Sid sid;
    @Override
    public String uploadFdfs(MultipartFile file, String fileName) throws Exception {
        InputStream inputStream=file.getInputStream();
        StorePath storePath=fastFileStorageClient.uploadFile(inputStream,file.getSize(),fileName,null);
        inputStream.close();
        return storePath.getFullPath();
    }
}