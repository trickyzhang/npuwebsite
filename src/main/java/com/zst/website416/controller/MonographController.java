package com.zst.website416.controller;

import com.zst.website416.model.monograph;
import com.zst.website416.model.util.Result;
import com.zst.website416.service.MonographService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monograph")
public class MonographController {

    @Autowired
    private MonographService monographService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public Result getMonographById(@PathVariable Integer id) {
        monograph monograph = monographService.getMonographById(id);
        if (monograph != null) {
            return Result.success(monograph);
        } else {
            return Result.fail("专著未找到");
        }
    }

    @GetMapping("/get/{title}")
    @ResponseBody
    public Result getMonographByTitle(@PathVariable String title) {
        monograph monograph = monographService.getMonographByTitle(title);
        if (monograph != null) {
            return Result.success(monograph);
        } else {
            return Result.fail("专著未找到");
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public Result getAllMonographs() {
        List<monograph> monographs = monographService.getAllMonographs();
        return Result.success(monographs);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addMonograph(@RequestBody monograph monograph) {
        monographService.addMonograph(monograph);
        return Result.success("添加成功");
    }

    @PutMapping("/update")
    @ResponseBody
    public Result updateMonograph(@RequestBody monograph monograph) {
        monographService.updateMonograph(monograph);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result deleteMonographById(@PathVariable Integer id) {
        monographService.deleteMonographById(id);
        return Result.success("删除成功");
    }
}
