package com.example.lenovo.myapplication.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;


import com.example.lenovo.myapplication.entity.HotNews;
import com.example.lenovo.myapplication.entity.LatestNews;
import com.example.lenovo.myapplication.entity.RecommendNews;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utility {

    /**
     * 解析热门新闻
     * @param response
     * @return
     */
    public static List<HotNews> handleHotNewsResponse(String response) {
        List<HotNews> hotNewsList = new ArrayList<>();
        HotNews hotNews = null;
        if (!TextUtils.isEmpty(response)) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new StringReader(response));

                String id="";
                String title="";
                String summary="";
                String sourceName="";
                String published="";
                String views="";
                String comments="";
                String diggs="";

                int eventType = parser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String nodeName = parser.getName();

                    switch (eventType) {
                        case XmlPullParser.START_TAG://开始解析
                            if("id".equals(nodeName)){
                                id=parser.nextText();
                            }
                            if("title".equals(nodeName)){
                                title=parser.nextText();
                            }
                            if("sourceName".equals(nodeName)){
                                sourceName=parser.nextText();
                            }
                            if("summary".equals(nodeName)){
                                summary=parser.nextText();
                            }
                            if("published".equals(nodeName)){
                                published=parser.nextText();
                            }
                            if("views".equals(nodeName)){
                                views=parser.nextText();
                            }
                            if("comments".equals(nodeName)){
                                comments=parser.nextText();
                            }
                            if("diggs".equals(nodeName)){
                                diggs=parser.nextText();
                            }
                            break;
                        case XmlPullParser.END_TAG://完成解析
                            if("entry".equals(nodeName)){
                                hotNews = new HotNews();
                                hotNews.setId(id);
                                hotNews.setNewTitle(title);
                                hotNews.setSummary(summary);
                                Date date=new SimpleDateFormat("yyyy-MM-dd").parse(published);
                                hotNews.setPublishedTime(date);
                                hotNews.setNumberOfView(Integer.parseInt(views));
                                hotNews.setNumberOfComments(Integer.parseInt(comments));
                                hotNews.setSourceName(sourceName);
                                hotNews.setNumberOfDiggs(Integer.parseInt(diggs));
                                hotNewsList.add(hotNews);
                            }
                            break;
                        default:
                            break;

                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("TAG", "handleHotNewsResponse: " + e.getMessage());
            }
        }
        return hotNewsList;
    }


    /**
     * 解析最近新闻
     * @param response
     * @return
     */
    public static List<LatestNews> handleLatestNewsResponse(String response) {
        List<LatestNews> latestNewsList = new ArrayList<>();
        LatestNews latestNews = null;
        if (!TextUtils.isEmpty(response)) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new StringReader(response));

                String id="";
                String title="";
                String summary="";
                String published="";
                String views="";
                String comments="";
                String diggs="";
                String sourceName="";

                int eventType = parser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String nodeName = parser.getName();

                    switch (eventType) {
                        case XmlPullParser.START_TAG://开始解析
                            if("id".equals(nodeName)){
                                id=parser.nextText();
                            }
                            if("title".equals(nodeName)){
                                title=parser.nextText();
                            }
                            if("summary".equals(nodeName)){
                                summary=parser.nextText();
                            }
                            if("sourceName".equals(nodeName)){
                                sourceName=parser.nextText();
                            }
                            if("published".equals(nodeName)){
                                published=parser.nextText();
                            }
                            if("views".equals(nodeName)){
                                views=parser.nextText();
                            }
                            if("comments".equals(nodeName)){
                                comments=parser.nextText();
                            }
                            if("diggs".equals(nodeName)){
                                diggs=parser.nextText();
                            }
                            break;
                        case XmlPullParser.END_TAG://完成解析
                            if("entry".equals(nodeName)){
                                latestNews = new LatestNews();
                                latestNews.setId(id);
                                latestNews.setNewTitle(title);
                                latestNews.setSummary(summary);
                                Date date=new SimpleDateFormat("yyyy-MM-dd").parse(published);
                                latestNews.setPublishedTime(date);
                                latestNews.setNumberOfView(Integer.parseInt(views));
                                latestNews.setNumberOfComments(Integer.parseInt(comments));
                                latestNews.setSourceName(sourceName);
                                latestNews.setNumberOfDiggs(Integer.parseInt(diggs));
                                latestNewsList.add(latestNews);
                            }
                            break;
                        default:
                            break;

                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("TAG", "handleLatestNewsResponse: " + e.getMessage());
            }
        }
        return latestNewsList;
    }


    /**
     * 解析推荐新闻
     * @param response
     * @return
     */

    public static List<RecommendNews> handleRecommendNewsResponse(String response) {
        List<RecommendNews> recommendNewsList = new ArrayList<>();
        RecommendNews recommendNews = null;
        if (!TextUtils.isEmpty(response)) {
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new StringReader(response));

                String id="";
                String title="";
                String summary="";
                String published="";
                String views="";
                String comments="";
                String diggs="";
                String sourceName="";

                int eventType = parser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String nodeName = parser.getName();

                    switch (eventType) {
                        case XmlPullParser.START_TAG://开始解析
                            if("id".equals(nodeName)){
                                id=parser.nextText();
                            }
                            if("title".equals(nodeName)){
                                title=parser.nextText();
                            }
                            if("sourceName".equals(nodeName)){
                                sourceName=parser.nextText();
                            }

                            if("summary".equals(nodeName)){
                                summary=parser.nextText();
                            }
                            if("published".equals(nodeName)){
                                published=parser.nextText();
                            }
                            if("views".equals(nodeName)){
                                views=parser.nextText();
                            }
                            if("comments".equals(nodeName)){
                                comments=parser.nextText();
                            }
                            if("diggs".equals(nodeName)){
                                diggs=parser.nextText();
                            }
                            break;
                        case XmlPullParser.END_TAG://完成解析
                            if("entry".equals(nodeName)){
                                recommendNews = new RecommendNews();
                                recommendNews.setId(id);
                                recommendNews.setNewTitle(title);
                                recommendNews.setSummary(summary);
                                Date date=new SimpleDateFormat("yyyy-MM-dd").parse(published);
                                recommendNews.setPublishedTime(date);
                                recommendNews.setNumberOfView(Integer.parseInt(views));
                                recommendNews.setNumberOfComments(Integer.parseInt(comments));
                                recommendNews.setSourceName(sourceName);
                                recommendNews.setNumberOfDiggs(Integer.parseInt(diggs));
                                recommendNewsList.add(recommendNews);
                            }
                            break;
                        default:
                            break;

                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("TAG", "handleRecommendNewsResponse: " + e.getMessage());
            }
        }
        return recommendNewsList;
    }


}
