package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.service.ImsXuanMixloanMemberService;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
@Controller
@RequestMapping("imsxuanmixloanmember")
public class ImsXuanMixloanMemberController extends BaseController {
    @Autowired
    private ImsXuanMixloanMemberService imsXuanMixloanMemberServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "imsxuanmixloanmember";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ImsXuanMixloanMemberEntity> imsXuanMixloanMemberList = imsXuanMixloanMemberServiceImpl.queryList(query);
        int total = imsXuanMixloanMemberServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, imsXuanMixloanMemberList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("id") Integer id) {
        ImsXuanMixloanMemberEntity imsXuanMixloanMember = imsXuanMixloanMemberServiceImpl.queryObject(id);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanMember);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute ImsXuanMixloanMemberEntity imsXuanMixloanMember) {
        imsXuanMixloanMemberServiceImpl.save(imsXuanMixloanMember);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, imsXuanMixloanMember);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute ImsXuanMixloanMemberEntity imsXuanMixloanMember) {
        int result = imsXuanMixloanMemberServiceImpl.update(imsXuanMixloanMember);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Integer[] ids) {
        int result = imsXuanMixloanMemberServiceImpl.deleteBatch(ids);
        return putMsgToJsonString(result, "", 0, "");
    }

}
