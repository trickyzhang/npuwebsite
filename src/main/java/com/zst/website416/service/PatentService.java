package com.zst.website416.service;

import com.zst.website416.mapper.PatentMapper;
import com.zst.website416.model.Patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {
    @Autowired
    private PatentMapper patentMapper;

    public List<Patent> getPatentList() {
        return patentMapper.findAll();
    }

    public Patent findById(Integer id) {
        return patentMapper.findById(id);
    }

    public Patent findByTitle(String title) {
        return patentMapper.findByTitle(title);
    }

    public void insert(Patent patent) {
        patentMapper.insert(patent);
    }

    public boolean isPatentExists(String title) {
        return patentMapper.findByTitle(title) != null;
    }

    public void updatePatentByTitle(Patent patent) {
        patentMapper.update(patent);
    }

    public void deletePatentById(Integer id) {
        patentMapper.deleteById(id);
    }

}
