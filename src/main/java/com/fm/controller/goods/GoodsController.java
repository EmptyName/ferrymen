package com.fm.controller.goods;

import com.fm.dto.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aiyi on 2017/5/13.
 */
@RestController
@RequestMapping("/fm/goods")
public class GoodsController {


    @PostMapping("/post")

    public ResultJson post(){



        return ResultJson.ok();
    }


    @GetMapping("/index")
    public ResultJson index() {
        return ResultJson.ok();
    }

    @GetMapping("/get/{id}")
    public ResultJson getPostById(@PathVariable("id") Long id) {



        return ResultJson.ok();
    }



}
