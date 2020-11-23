package com.soft1851.files.controller;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.soft1851.api.controller.files.FileUploadControllerApi;
import com.soft1851.files.resource.FileResource;
import com.soft1851.files.service.UploadService;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.utils.extend.AliImageReviewUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private  final AliImageReviewUtil aliImageReviewUtil;
    private GridFsTemplate gridFsTemplate;

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
        return GraceResult.ok(doAliImageReview(finalPath));
    }

    public static final String FAILED_IMAGE_URL = "https://zhengliang00.oss-cn-beijing.aliyuncs.com/study/201119FG1H1C96K4.png";

    private String doAliImageReview(String pendingImageUrl){
        log.info(pendingImageUrl);
        boolean result = false;
        try {
            result = aliImageReviewUtil.reviewImage(pendingImageUrl);
        }catch (Exception e){
            System.out.println("图片识别出错");
        }
        if (!result){
            return FAILED_IMAGE_URL;
        }
        return pendingImageUrl;
    }


    @Override
    public GraceResult uploadSomeFiles(String userId, MultipartFile[] files) throws Exception {
        // 声明list，，用于存放多个图片的地址路径 返回到前端
        List<String> imageUrlList = new ArrayList<>();
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                String path;
                if (file != null) {
                    // 获得文件上传的名称
                    String fileName = file.getOriginalFilename();
                    // 判断文件名不能为空
                    if (StringUtils.isNotBlank(fileName)) {
                        String[] fileNameArr = fileName.split("\\.");
                        // 获得后缀
                        String suffix = fileNameArr[fileNameArr.length - 1];
                        // 判断后缀符合我们的预定义规范
                        if (!"png".equalsIgnoreCase(suffix) &&
                                !"jpg".equalsIgnoreCase(suffix) &&
                                !"jpeg".equalsIgnoreCase(suffix)
                        ) {
                            continue;
                        }
                        // 执行上传
                        path = uploadService.uploadOSS(file, userId,suffix);
                    }else {
                        continue;
                    }


                }else  {
                    continue;
                }
                String finalPath;
                if (StringUtils.isNotBlank(path)) {
                    finalPath = fileResource.getOssHost() + path;
                    imageUrlList.add(finalPath);
                }
            }
        }
        return GraceResult.ok(imageUrlList);
    }

    @Override
    public GraceResult uploadToGridFS(String username, MultipartFile multipartFile) throws Exception {
        Map<String,String> metaData = new HashMap<>(4);
        InputStream is = null;
        try{
            is = multipartFile.getInputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        //获取文件的源名称
        String fielName = multipartFile.getOriginalFilename();
        //进行文件存储
        assert is != null;
        ObjectId objectId = gridFsTemplate.store(is,fielName,metaData);
        try{
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return GraceResult.ok(objectId.toHexString());
    }

    @Override
    public GraceResult readInGridFS(String faceId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        GridFSFile gridFSFile=gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(faceId)));
        if (gridFSFile==null){
            throw new RuntimeException("No File with id:"+faceId);
        }
        System.out.println(gridFSFile.getFilename());
        //获取流对象
        GridFsResource resource=gridFsTemplate.getResource(gridFSFile);
        InputStream inputStream;
        String  content =null;
        byte[] bytes=new byte[(int) gridFSFile.getLength()];
        try {
            inputStream=resource.getInputStream();
            inputStream.read(bytes);
            inputStream.close();
            ServletOutputStream outputStream=response.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return GraceResult.ok(new String(bytes));
    }
}
