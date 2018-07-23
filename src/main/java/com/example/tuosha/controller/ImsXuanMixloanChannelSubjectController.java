package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.model.ImsXuanMixloanChannelSubjectEntity;
import com.example.tuosha.service.ImsXuanMixloanChannelSubjectService;
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
@RequestMapping("imsxuanmixloanchannelsubject")
public class ImsXuanMixloanChannelSubjectController extends BaseController {
    @Autowired
    private ImsXuanMixloanChannelSubjectService imsXuanMixloanChannelSubjectServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "imsxuanmixloanchannelsubject";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ImsXuanMixloanChannelSubjectEntity> imsXuanMixloanChannelSubjectList = imsXuanMixloanChannelSubjectServiceImpl.queryList(query);
        int total = imsXuanMixloanChannelSubjectServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, imsXuanMixloanChannelSubjectList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("id") Integer id) {
        ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject = imsXuanMixloanChannelSubjectServiceImpl.queryObject(id);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanChannelSubject);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject) {
        imsXuanMixloanChannelSubjectServiceImpl.save(imsXuanMixloanChannelSubject);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanChannelSubject);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject) {
        int result = imsXuanMixloanChannelSubjectServiceImpl.update(imsXuanMixloanChannelSubject);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Integer[] ids) {
        int result = imsXuanMixloanChannelSubjectServiceImpl.deleteBatch(ids);
        return putMsgToJsonString(result, "", 0, "");
    }

}
