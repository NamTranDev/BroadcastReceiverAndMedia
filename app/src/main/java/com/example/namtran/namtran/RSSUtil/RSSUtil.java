package com.example.namtran.namtran.RSSUtil;


import com.example.namtran.namtran.Lớp_cơ_bản.News;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Nam Tran on 7/20/2015.
 */
public class RSSUtil {
    public static List<News> readRSSDanTri(InputStream inputStream)
    {
        List<News> newses = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            try {
                Document document = documentBuilder.parse(inputStream);
                if ( document!= null )
                {
                    NodeList items = document.getElementsByTagName(News.ITEM);
                    if (items != null)
                    {
                        News news ;
                        for (int i=0;i<items.getLength();i++)
                        {
                            news = new News();
                            NodeList childrend = items.item(i).getChildNodes();
                            if (childrend != null)
                            {
                                for (int j = 0 ; j< childrend.getLength();j++)
                                {
                                    Node child = childrend.item(j);
                                    switch (child.getNodeName())
                                    {
                                        case News.TITLE :
                                        String title = child.getTextContent();
                                          //  Log.d("NamTran",title);
                                        news.setTitle(title);
                                        break;
                                        case News.DECRIPTION :
                                            String decription = child.getTextContent();
                                            String[] temp = decription.split("\" ></a></br>");
                                            String image = temp[0];
                                            String[] Image = image.split("src=\"");
                                            news.setImage(Image[1].substring(0,Image[1].length()));
                                            news.setDecription(temp[1].substring(0));
                                            break;
                                        case News.LINK :
                                            String link = child.getTextContent();
                                           // Log.d("NamTran",link);
                                            news.setLink(link);
                                            break;
                                        case News.PUBDATE :
                                            String pubdate = child.getTextContent();
                                            //Log.d("NamTran",pubdate);
                                            news.setPubdate(pubdate);
                                            break;
                                    }
                                }
                            }
                            newses.add(news);
                        }
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        /*Log.d("TranNam", String.valueOf(newses));*/
        return newses;

    }
}
