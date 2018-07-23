package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import com.example.tuosha.Util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;

import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.ImsXuanMixloanPosterEntity;
import com.example.tuosha.service.ImsXuanMixloanPosterService;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
@Controller
@RequestMapping("imsxuanmixloanposter")
public class ImsXuanMixloanPosterController extends BaseController {
    @Autowired
    private ImsXuanMixloanPosterService imsXuanMixloanPosterServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "imsxuanmixloanposter";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ImsXuanMixloanPosterEntity> imsXuanMixloanPosterList = imsXuanMixloanPosterServiceImpl.queryList(query);
        int total = imsXuanMixloanPosterServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, imsXuanMixloanPosterList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("id") Integer id) {
        ImsXuanMixloanPosterEntity imsXuanMixloanPoster = imsXuanMixloanPosterServiceImpl.queryObject(id);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanPoster);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute ImsXuanMixloanPosterEntity imsXuanMixloanPoster) {
        imsXuanMixloanPosterServiceImpl.save(imsXuanMixloanPoster);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanPoster);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute ImsXuanMixloanPosterEntity imsXuanMixloanPoster) {
        int result = imsXuanMixloanPosterServiceImpl.update(imsXuanMixloanPoster);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Integer[] ids) {
        int result = imsXuanMixloanPosterServiceImpl.deleteBatch(ids);
        return putMsgToJsonString(result, "", 0, "");
    }

}
