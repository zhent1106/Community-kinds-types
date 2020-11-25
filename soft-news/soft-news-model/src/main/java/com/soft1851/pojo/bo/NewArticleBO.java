package com.soft1851.pojo.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName NewArticleBO
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewArticleBO {
    @NotBlank(message = "文章标题不能为空")
    @Length(max = 30,message = "文章标题长度不能超过30")
    private String title;

    @NotBlank(message = "文章内容不能为空")
    @Length(max = 9999,message = "文章内容长度不能超过10000")
    private String content;

    @NotNull(message = "请选择文章领域")
    private Integer categoryId;

    @NotNull(message = "请选择正确的文章封面类型")
    @Min(value = 1,message = "请选择正确的文章封面类型")
    @Max(value = 2,message = "请选择正确的文章封面类型")
    private Integer articleType;

    private String articleCover;

    @NotNull(message = "文章发布类型不正确")
    @Min(value = 0,message = "文章发布类型不正确")
    @Max(value = 1,message = "文章发布类型不正确")
    private Integer isAppoint;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    @NotBlank(message = "用户未登录")
    private String publishUserId;


}