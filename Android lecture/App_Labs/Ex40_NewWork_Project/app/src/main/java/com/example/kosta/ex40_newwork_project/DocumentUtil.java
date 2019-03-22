package com.example.kosta.ex40_newwork_project;

import android.util.Log;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOSTA on 2015-07-03.
 */
public class DocumentUtil {

    private static List<MovieInfo> movieInfoList;

    public static List<MovieInfo> getMovieInfoList(){
        List<MovieInfo> tempList = new ArrayList<MovieInfo>();

        if(movieInfoList != null){
            tempList.addAll(movieInfoList);
        }

        return tempList;
    }

    public static void processDocument(Document document){

        // 초기화
        movieInfoList = new ArrayList<MovieInfo>();

        // XML을 얻어화서 변환한 Document 객체를 Element로 받아온다.
        // Element는 Document에 포함되는 객체를 말한다.
        // 이 Element는 여러개의 Node를 가진다.

        Element docElement = document.getDocumentElement();

        // item이라는 이름의 Element를 가져온다.
        // 이 Element는 여러개의 Node를 가지고 있다.
        NodeList nodeList = document.getElementsByTagName("item");

        MovieInfo movieInfo = null;
        if(nodeList != null && nodeList.getLength() >0){
            for(int i=0; i<nodeList.getLength(); i++){

                // 각각의 Item Node에서 Movie 정보를 가져온다.
                movieInfo = getConvertNodeToMovieInfo((Element)nodeList.item(i));
                if(movieInfo != null){
                    movieInfoList.add(movieInfo);
                }
            }
        }

    }

    private static MovieInfo getConvertNodeToMovieInfo(Element entry){

        MovieInfo movieInfo = null;

        try{
            // 데이터 꺼내오기
            Element image = (Element) entry.getElementsByTagName("image").item(0);
            Element subject = (Element) entry.getElementsByTagName("title").item(0);
            Element pubDate = (Element) entry.getElementsByTagName("pubDate").item(0);
            Element director = (Element) entry.getElementsByTagName("director").item(0);
            Element actors = (Element) entry.getElementsByTagName("actor").item(0);
            Element userRating = (Element) entry.getElementsByTagName("userRating").item(0);

            // 데이터 채우기
            movieInfo = new MovieInfo();
            movieInfo.setImageUrl( getValue(image) );
            movieInfo.setSubject( getValue(subject) );
            movieInfo.setPubDate( getValue(pubDate) );
            movieInfo.setDirector( getValue(director) );
            movieInfo.setActors( getValue(actors) );
            movieInfo.setUserRating(Float.parseFloat( getValue(userRating) ));

        }catch (DOMException dome){
            // throw new ~~ 이거 안드로이드에서는 절대 하지마
            // 로그 사용해라.
            dome.printStackTrace();
            Log.d("ERROR", dome.getMessage());
        }

        return movieInfo;
    }

    private static String getValue(Element element){

        String value = "";

        if(element != null && element.getFirstChild() != null){
            value = element.getFirstChild().getNodeValue();
        }
        return value;
    }

}