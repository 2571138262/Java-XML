package com.imooc.sax;

import com.sax.handler.MuKeHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //创建SAX解析器工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //创建SAX解析器
        SAXParser parse = factory.newSAXParser();
        //开始解析XML文档
        parse.parse("file/firstxml.xml", new MuKeHandler());
    }
}
