import cn.com.dssp.pojo.Language;
import cn.com.dssp.service.LanguageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * cwy 2019/7/19 22:05
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext-mapper.xml",
        "classpath:applicationContext-service.xml",
        "classpath:spring-common.xml"
})
public class AcTests {


    @Autowired
    private LanguageService languageService;

    @Test
    public void test(){
        List<Language> languageAll = languageService.getLanguageAll();
        System.out.println(languageAll);
    }
}
