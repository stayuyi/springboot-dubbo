package com.yy.provider1.controller;

import com.yy.provider1.model.BlackListQueryRequest;
import com.yy.provider1.model.IdType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class PerBlackListController {

    @ResponseBody
    @RequestMapping(value = "/black-information-detail", method = RequestMethod.POST)
    public BlackListQueryRequest qryDetailInfo(
             @RequestBody BlackListQueryRequest blackListQueryRequest) {
        System.out.println(blackListQueryRequest);
        return blackListQueryRequest;

    }
}
