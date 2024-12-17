// 文件路径: D:\code\website416\src\main\java\com\zst\website416\service\impl\PaperServiceImpl.java
package com.zst.website416.service;

import com.zst.website416.mapper.PaperMapper;
import com.zst.website416.model.Paper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService{

    @Autowired
    private PaperMapper paperMapper;

    public List<Paper> findAll() {
        return paperMapper.findAll();
    }

    public Paper findById(Integer id) {
        return paperMapper.findById(id);
    }

    public Paper findByTitle(String title) {
        return paperMapper.findByTitle(title);
    }

    public void insert(Paper paper) {
        paperMapper.insert(paper);
    }

    public void update(Paper paper) {
        paperMapper.update(paper);
    }

    public void deleteById(Integer id) {
        paperMapper.deleteById(id);
    }
}
