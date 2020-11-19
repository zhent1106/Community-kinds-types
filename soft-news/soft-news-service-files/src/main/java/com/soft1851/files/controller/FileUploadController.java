package com.soft1851.files.controller;

import com.soft1851.api.controller.files.FileUploadControllerApi;
import com.soft1851.files.resource.FileResource;
import com.soft1851.files.service.UploadService;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tianzhen
 * @date 2020/11/19 14:33
 * @description 文件上传api
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileUploadController implements FileUploadControllerApi {
    private final UploadService uploadService;
    private final FileResource fileResource;

    @Override
    public GraceResult uploadFace(String userId, MultipartFile file) throws Exception {
        String path;
        if (file != null) {
//            获得文件上传的名称
            String fileName = file.getOriginalFilename();
//            判断文件名不能为空
            if (StringUtils.isNotBlank(fileName)) {
//                分割文件名
                String[] fileNameArr = fileName.split("\\.");
//                获得后缀
                String suffix = fileNameArr[fileNameArr.length - 1];
//                判断后缀符合我们的预定规范
                if ("png".equalsIgnoreCase(suffix) &&
                        !"jpg".equalsIgnoreCase(suffix) &&
                        !"jpeg".equalsIgnoreCase(suffix)
                ) {
                    return GraceResult.errorCustom(ResponseStatusEnum.FILE_FORMATTER_FAILD);
                }
//                执行上传服务，得到回调路径
                path = uploadService.uploadFdfs(file, suffix);

            } else {
                return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
            }
        } else {
            return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
        }
        log.info("path = " + path);
        String finalPath;
        if (StringUtils.isNotBlank(path)) {
            finalPath = fileResource.getHost() + path;

        } else {
            return GraceResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_FAILD);
        }
        return GraceResult.ok(finalPath);
    }
}
