package com.caitu99.log.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Lion on 2015/12/14 0014.
 */

@Service
public class AppConfig {

    @Value("${dingding.corpid}")
    public String corpid;

    @Value("${dingding.corpsecret}")
    public String corpsecret;

    @Value("${dingding.agentid}")
    public String agentId;

    @Value("${dingding.lines}")
    public Integer lines;

}
