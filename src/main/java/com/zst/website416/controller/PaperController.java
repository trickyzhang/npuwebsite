package com.zst.website416.controller;

import com.zst.website416.model.Paper;
import com.zst.website416.model.util.Result;
import com.zst.website416.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping("/all")
    @ResponseBody
    public Result getAllPapers() {
        List<Paper> papers = paperService.findAll();
        return Result.success(papers);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Result getPaperById(@PathVariable Integer id) {
        Paper paper = paperService.findById(id);
        if (paper != null) {
            return Result.success(paper);
        } else {
            return Result.fail("论文未找到");
        }
    }

    @GetMapping("/get/{title}")
    @ResponseBody
    public Result getPaperByTitle(@PathVariable String title) {
        Paper paper = paperService.findByTitle(title);
        if (paper != null) {
            return Result.success(paper);
        } else {
            return Result.fail("论文未找到");
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addPaper(@RequestBody Paper paper) {
        paperService.insert(paper);
        return Result.success("添加成功");
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Result updatePaper(@PathVariable Integer id, @RequestBody Paper paper) {
        paper.setId(id);
        paperService.update(paper);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result deletePaper(@PathVariable Integer id) {
        paperService.deleteById(id);
        return Result.success("删除成功");
    }
}
