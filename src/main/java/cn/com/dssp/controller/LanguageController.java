package cn.com.dssp.controller;

import cn.com.dssp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * cwy 2020/2/13 16:27
 **/
@Controller
@RequestMapping(value = "/language")
public class LanguageController {


    @Autowired
    private LanguageService languageService;

    @RequestMapping("/change")
    public String change(String locale, HttpSession session){
        if ("zh".equals(locale)) {
            Locale locale1 = new Locale("zh","CN");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale1);
        } else if ("en".equals(locale)) {
            Locale locale1 = new Locale("en","US");
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale1);
        } else {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    LocaleContextHolder.getLocale());
        }
        return "login";
    }



}
