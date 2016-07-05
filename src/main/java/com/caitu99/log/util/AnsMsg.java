package com.caitu99.log.util;

import com.caitu99.log.util.spring.SpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lion on 2015/12/12 0012.
 */
@Service
public class AnsMsg {
    private final Logger logger = LoggerFactory.getLogger(AnsMsg.class);
    public  String sendOrNot(String string) {

        Properties properties = SpringContext.getBean("properties");
        String temple= (String) properties.get("dingding.temple");
        if(temple==null || "".equals(temple))
        {
            logger.error("模板不存在");
            return "0";//未找到模板
        }
        String[] indexs = temple.split(":");
        for (String index : indexs) {
            String patternStr = (String) properties.get("pattern.regx" + index);
            if(patternStr==null || patternStr.equals("")) {
                if(!"x".equals(index)) {
                    logger.error("有正则表达式为空,{}", index);
                }
                return "0";
            }
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                if (temple.contains(":x")) {
                    return "x"; //自测
                }
                return index;
            }

        }
        return "0";
    }
}
