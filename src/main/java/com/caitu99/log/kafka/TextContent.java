package com.caitu99.log.kafka;

import com.caitu99.log.util.AppConfig;
import org.junit.Test;

/**
 * Created by Lion on 2015/12/14 0014.
 */
public class TextContent {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content, AppConfig appConfig) {

        int i = 0;
        int j = 0;
        int x = 0;
        int lines = appConfig.lines;
        for (; i < lines; i++) {
            x = content.indexOf("\n", x + 1);
            if (x == -1) {
                break;
            } else {
                j = x;
            }
        }
        if (j > 0) {
            this.content = content.substring(0, j);
        } else {
            this.content = content;
        }

//        if (content.contains("\n\t")) {
//            content = content.substring(0, content.indexOf("\n\t"));
//        }
//        this.content = content;
    }

    @Test
    public void setContent2() {
        String content = "xxxxxxxxxxxxx\n\tafadf af asfsadf sfsdf asd \n\tsfsdfsdfdsfdsftytbhdfhdfh\n\tfdsafdsfdsfdsfdsfdsffdsfdsf\n\tfasfdsfdsfsdrttgasdf";
        int i = 0;
        int j = 0;
        int x = 0;
        for (; i < 10; i++) {
            x = content.indexOf("\n\t", x + 2);
            if (x == -1) {
                break;
            } else {
                j = x;
            }
        }
        if (j > 0) {
            this.content = content.substring(0, j);
        } else {
            this.content = content;
        }

//        if (content.contains("\n\t")) {
//            content = content.substring(0, content.indexOf("\n\t"));
//        }
//        this.content = content;
    }
}
