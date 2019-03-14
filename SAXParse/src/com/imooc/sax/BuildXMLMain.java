package com.imooc.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class BuildXMLMain {
    public static void main(String[] args) throws TransformerConfigurationException, SAXException {
        //创建保存XML的结果流对象
        Result resultXML = new StreamResult(new File("file/buildxml.xml"));
        //获取SAX生成工厂对象实例
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        //获取SAX生成的处理这对象实例
        TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
        transformerHandler.setResult(resultXML);
        //获取SAX生成器
        Transformer transformer = transformerHandler.getTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        //生成文档的开始
        transformerHandler.startDocument();
        AttributesImpl attriImp1 = new AttributesImpl();
//        attriImp1.addAttribute();//添加属性

        transformerHandler.startElement("", "", "书籍列表", attriImp1);

        //第一本书
        transformerHandler.startElement("", "", "计算机书籍", attriImp1);

        transformerHandler.startElement("", "", "书名", attriImp1);
        transformerHandler.characters("Java思想".toCharArray(), 0, "Java思想".length());
        transformerHandler.endElement("", "", "书名");

        transformerHandler.startElement("", "", "作者", attriImp1);
        transformerHandler.characters("小王".toCharArray(), 0, "小王".length());
        transformerHandler.endElement("", "", "作者");

        transformerHandler.startElement("", "", "价格", attriImp1);
        transformerHandler.characters("78.0".toCharArray(), 0, "78.0".length());
        transformerHandler.endElement("", "", "价格");

        transformerHandler.endElement("", "", "计算机书籍");

        //第二本书
        transformerHandler.startElement("", "", "计算机书籍", attriImp1);

        transformerHandler.startElement("", "", "书名", attriImp1);
        transformerHandler.characters("Sprint指南".toCharArray(), 0, "Sprint指南".length());
        transformerHandler.endElement("", "", "书名");

        transformerHandler.startElement("", "", "作者", attriImp1);
        transformerHandler.characters("小李".toCharArray(), 0, "小李".length());
        transformerHandler.endElement("", "", "作者");

        transformerHandler.startElement("", "", "价格", attriImp1);
        transformerHandler.characters("88.0".toCharArray(), 0, "88.0".length());
        transformerHandler.endElement("", "", "价格");

        transformerHandler.endElement("", "", "计算机书籍");

        transformerHandler.endElement("", "", "数据列表");

        //告诉handler文档生成以结束
        transformerHandler.endDocument();

        System.out.println("XML文档生成成功");
    }
}
