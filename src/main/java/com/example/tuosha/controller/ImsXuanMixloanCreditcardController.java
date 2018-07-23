package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.model.ImsXuanMixloanCreditcardEntity;
import com.example.tuosha.service.ImsXuanMixloanCreditcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
@Controller
@RequestMapping("imsxuanmixloancreditcard")
public class ImsXuanMixloanCreditcardController extends BaseController {
    @Autowired
    private ImsXuanMixloanCreditcardService imsXuanMixloanCreditcardServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "imsxuanmixloancreditcard";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ImsXuanMixloanCreditcardEntity> imsXuanMixloanCreditcardList = imsXuanMixloanCreditcardServiceImpl.queryList(query);
        int total = imsXuanMixloanCreditcardServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, imsXuanMixloanCreditcardList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("id") Integer id) {
        ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard = imsXuanMixloanCreditcardServiceImpl.queryObject(id);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanCreditcard);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard) {
        imsXuanMixloanCreditcardServiceImpl.save(imsXuanMixloanCreditcard);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanCreditcard);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard) {
        int result = imsXuanMixloanCreditcardServiceImpl.update(imsXuanMixloanCreditcard);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Integer[] ids) {
        int result = imsXuanMixloanCreditcardServiceImpl.deleteBatch(ids);
        return putMsgToJsonString(result, "", 0, "");
    }

}
