package com.mario.blog.controller;

import com.mario.blog.service.interf.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
@Controller
@RequestMapping("/reply")
public class ReplyAction {

    @Autowired
    private ReplyService replyService;

    /**
     * 插入回复信息
     * @param itemId
     * @param cardId
     * @param content
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/insertReply",method = RequestMethod.POST)
    public String insertReply(
            @RequestParam(value = "itemId", required = false, defaultValue = "0")int itemId,
            @RequestParam(value = "cardId", required = false, defaultValue = "") String cardId,
            @RequestParam(value = "content", required = false, defaultValue = "") String content,
            HttpServletRequest request,RedirectAttributes redirectAttributes) {
        Map<String, Object> map = replyService.insertReply(cardId, content, request);
        System.out.println("map=" + map);
        if ("-1".equals(map.get("code"))) {
            return "other/error";
        }
        redirectAttributes.addAttribute("itemId",itemId);
        redirectAttributes.addAttribute("cardId", cardId);
        return "redirect:../../v/card/toCardDetails";
    }

    @RequestMapping(value = "/getReplyListById")
    @ResponseBody
    public String getReplyListById(
            @RequestParam(value = "cardId",required = false,defaultValue = "")String cardId,
            @RequestParam(value = "curPage",required = false,defaultValue = "1")int curPage,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20")int pageSize
    ){
        return replyService.getReplyListById(cardId,curPage,pageSize);
    }
}
