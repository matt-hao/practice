package com.mario.blog.controller;

import com.mario.blog.service.interf.CardService;
import com.mario.blog.service.interf.ItemService;
import com.mario.blog.vo.CardVO;
import com.mario.blog.vo.ItemVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/11.
 */
@RequestMapping(value = "/card")
@Controller
public class CardAction {

    private static final Logger logger = Logger.getLogger(CardAction.class);
    @Autowired
    private ItemService itemService;

    @Autowired
    private CardService cardService;

    /**
     * 转入发帖页面
     *
     * @param itemId
     * @param model
     * @return
     */
    @RequestMapping(value = "/toPostCard")
    public String toPostCard(
            @RequestParam(value = "itemId", required = false, defaultValue = "0") int itemId,
            Model model
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = itemService.getItemInfoById(itemId);
        if ("-1".equals(map.get("code"))) {
            return "other/error";
        }
        model.addAttribute("categoryName", map.get("categoryName"));
        model.addAttribute("item", map.get("data"));
        return "card/postCard";
    }

    /**
     * 发帖接口
     *
     * @param itemId
     * @param title
     * @param content
     * @param request
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(value = "/postCard")
    public String postCard(
            @RequestParam(value = "itemId", required = false, defaultValue = "0") int itemId,
            @RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "content", required = false, defaultValue = "") String content,
            HttpServletRequest request, RedirectAttributes redirectAttributes, Model model
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = cardService.postCard(itemId, title, content, request);
        model.addAttribute("categoryName", map.get("categoryName"));
        model.addAttribute("item", map.get("data"));
        model.addAttribute("title", title);
        if ("-2".equals(map.get("code"))) {
            return "other/error";
        } else if ("-1".equals(map.get("code"))) {
            model.addAttribute("validateMessage", map.get("message"));
            model.addAttribute("content", content);
            return "card/postCard";
        } else {
            Map<String,Object> itemMap = new HashMap<String,Object>();
            itemMap = (Map<String, Object>) map.get("data");
            redirectAttributes.addAttribute("itemId", itemMap.get("id"));

            Map<String,Object> cardMap = new HashMap<String,Object>();
            cardMap = (Map<String, Object>) map.get("card");
            redirectAttributes.addAttribute("cardId", cardMap.get("uuid"));
            return "redirect:toCardDetails";
        }
    }

    /**
     * 得到该id下的帖子列表
     *
     * @param itemId
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getCardList")
    @ResponseBody
    public String getCardList(
            @RequestParam(value = "itemId", required = false, defaultValue = "0") int itemId,
            @RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return cardService.getCardList(itemId, curPage, pageSize);
    }


    /**
     * 提交成功后的跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/toCardDetails")
    public String toCardDetails(
            @RequestParam(value = "itemId", required = false, defaultValue = "0") int itemId,
            @RequestParam(value = "cardId", required = false, defaultValue = "") String cardId,
            Model model) {
            //根据itemId获取item信息以及category名字
            Map map = itemService.getItemInfoById(itemId);
            if ("-1".equals(map.get("code"))) {
                return "other/error";
            }
            model.addAttribute("categoryName", map.get("categoryName"));
            model.addAttribute("item", map.get("data"));
            //根据cardId获取帖子信息
            Map cardMap = cardService.getCardById(cardId);
            if ("-1".equals(cardMap.get("code"))) {
                return "other/error";
            }
            model.addAttribute("card", cardMap.get("data"));
        return "card/cardDetails";
    }

}
