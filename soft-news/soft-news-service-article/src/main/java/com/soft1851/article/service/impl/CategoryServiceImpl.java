package com.soft1851.article.service.impl;

import com.soft1851.article.mapper.CategoryMapper;
import com.soft1851.article.service.CategoryService;
import com.soft1851.pojo.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/11/24
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryMapper categoryMapper;
    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }
}