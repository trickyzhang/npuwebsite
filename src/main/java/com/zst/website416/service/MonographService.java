package com.zst.website416.service;

import com.zst.website416.mapper.MonographMapper;
import com.zst.website416.model.monograph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonographService {

    @Autowired
    private MonographMapper monographMapper;


    public monograph getMonographById(Integer monographId) {
        return monographMapper.findById(monographId);
    }

    public monograph getMonographByTitle(String title) {
        return monographMapper.findByTitle(title);
    }

    public List<monograph> getAllMonographs() {
        return monographMapper.selectAll();
    }

    public void addMonograph(monograph monograph) {
        monographMapper.insert(monograph);
    }

    public void updateMonograph(monograph monograph) {
        monographMapper.update(monograph);
    }

    public void deleteMonographById(Integer monographId) {
        monographMapper.deleteById(monographId);
    }
}
