package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.TbUsersEntity;
import com.example.tuosha.service.TbUsersService;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
@Controller
@RequestMapping("tbusers")
public class TbUsersController extends BaseController {
    @Autowired
    private TbUsersService tbUsersServiceImpl;

    /**
     * 页面
     */
    @RequestMapping("/page")
    public String page(@RequestParam Map<String, Object> params) {
        return "tbusers";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<TbUsersEntity> tbUsersList = tbUsersServiceImpl.queryList(query);
        int total = tbUsersServiceImpl.queryTotal(query);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", total, tbUsersList);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{uid}", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object info(@PathVariable("uid") Long uid) {
        TbUsersEntity tbUsers = tbUsersServiceImpl.queryObject(uid);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbUsers);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@ModelAttribute TbUsersEntity tbUsers) {
        tbUsersServiceImpl.save(tbUsers);
        return putMsgToJsonString(Constants.WebSite.SUCCESS, "", 0, tbUsers);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@ModelAttribute TbUsersEntity tbUsers) {
        int result = tbUsersServiceImpl.update(tbUsers);
        return putMsgToJsonString(result, "", 0, "");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam Long[] uids) {
        int result = tbUsersServiceImpl.deleteBatch(uids);
        return putMsgToJsonString(result, "", 0, "");
    }

}
