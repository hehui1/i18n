package cn.com.dssp.utils;
import cn.com.dssp.pojo.Language;
import cn.com.dssp.service.LanguageService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * cwy 2020/2/13 15:58
 **/

public class MessageResource extends AbstractMessageSource implements ResourceLoaderAware , InitializingBean {

    @SuppressWarnings("unused")
    private ResourceLoader resourceLoader;

//    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-common.xml");

    @Autowired
    LanguageService languageService;

    /**
     * Map切分字符
     */
    protected final String MAP_SPLIT_CODE = "|";
    private final Map<String, String> properties = new HashMap<String, String>();

    public MessageResource() {
//        reload();
    }

//    public void reload() {
//        properties.clear();
//        properties.putAll(loadTexts());
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        properties.clear();
        properties.putAll(loadTexts());
    }

    /**
     * 获取数据库数据
     * @return
     */
    private List<Language> getResource() {
//        LanguageService languageService = (LanguageService) applicationContext.getBean("languageServiceImpl");
        List<Language> resources = languageService.getLanguageAll();
        System.out.println(resources.toString());
        return resources;
    }

    /**
     * 加载数据
     * @return
     */
    protected Map<String, String> loadTexts() {
        Map<String, String> mapResource = new HashMap<String, String>();
        List<Language> resources = this.getResource();
        for (Language item : resources) {
            String code = item.getMessageKey() + MAP_SPLIT_CODE + item.getLocale();
            mapResource.put(code, item.getMessageValue());
        }
        return mapResource;
    }

    /**
     * @param code
     * @param locale
     * 本地化语言
     * @return
     */
    private String getText(String code, Locale locale) {
        String localeCode = locale.getLanguage();
        String key = code + MAP_SPLIT_CODE + localeCode;
        String localeText = properties.get(key);
        String resourceText = code;

        if (localeText != null) {
            resourceText = localeText;
        } else {
            localeCode = Locale.ENGLISH.getLanguage();
            key = code + MAP_SPLIT_CODE + localeCode;
            localeText = properties.get(key);
            if (localeText != null) {
                resourceText = localeText;
            } else {
                try {
                    if (getParentMessageSource() != null) {
                        resourceText = getParentMessageSource().getMessage(code, null, locale);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resourceText;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = (resourceLoader != null ? resourceLoader : new DefaultResourceLoader());
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = getText(code, locale);
        MessageFormat result = createMessageFormat(msg, locale);
        return result;
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        String result = getText(code, locale);
        return result;
    }


}