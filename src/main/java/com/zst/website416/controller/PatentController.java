package com.zst.website416.controller;

import com.zst.website416.model.Patent;
import com.zst.website416.model.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zst.website416.service.PatentService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    private PatentService patentService;

    @GetMapping("/all")
    @ResponseBody
    public Result getAllPatents() {
        return Result.success(patentService.getPatentList());
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Result getPatentById(@PathVariable Integer id) {
        return Result.success(patentService.findById(id));
    }

    @GetMapping("/get/{title}")
    @ResponseBody
    public Result getPatentByTitle(@PathVariable String title) {
        return Result.success(patentService.findByTitle(title));
    }

    @GetMapping("add")
    @ResponseBody
    public Result addPatent(Patent patent) {
        patentService.insert(patent);
        return Result.success("添加成功");
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public Result updatePatent(@PathVariable Integer id, Patent patent) {
        patent.setPatent_id(id);
        patentService.updatePatentByTitle(patent);
        return Result.success("更新成功");
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Result deletePatent(@PathVariable Integer id) {
        patentService.deletePatentById(id);
        return Result.success("删除成功");
    }
}
