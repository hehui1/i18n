package cn.com.dssp.mapper;

import cn.com.dssp.pojo.Language;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * cwy 2020/2/13 16:20
 **/
@Component
public interface LanguageMapper  {

    List<Language> getLanguageAll();

}
