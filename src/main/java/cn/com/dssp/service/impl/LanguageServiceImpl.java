package cn.com.dssp.service.impl;

import cn.com.dssp.mapper.LanguageMapper;
import cn.com.dssp.pojo.Language;
import cn.com.dssp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cwy 2020/2/13 16:25
 **/
@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageMapper languageMapper;

    @Override
    public List<Language> getLanguageAll() {
        System.out.println("111");

        return languageMapper.getLanguageAll();
    }
}
