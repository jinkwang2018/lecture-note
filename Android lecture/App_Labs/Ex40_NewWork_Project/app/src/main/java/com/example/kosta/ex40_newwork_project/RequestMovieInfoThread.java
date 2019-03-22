package com.example.kosta.ex40_newwork_project;

import android.content.Context;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by KOSTA on 2015-07-03.
 */
public class RequestMovieInfoThread implements Runnable{

    private Context context;

    public RequestMovieInfoThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {

        try {
            URL urlForHttp = new URL("http://openapi.naver.com/search?key=c1b406b32dbbbbeee5f2a36ddc14067f&query=벤허&display=10&start=1&target=movie ");

            // URL로 연결을 준비함.
            HttpURLConnection conn = (HttpURLConnection)urlForHttp.openConnection();
            conn.setConnectTimeout(1000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            InputStream inputStream = null;

            // conn.getResponseCode() 호출 됬을 때 URL로 연결함
            if( conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                // byte로 되있는 html tag 들
                inputStream = conn.getInputStream();
            }
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            DocumentUtil.processDocument(document);

            //TODO 계속 작성해야 함
            ((MainActivity)context).getHandler().post(new Runnable() {
                @Override
                public void run() {
                    // 외부에서 데이터를 받아와서 listView를 갱신한다.
                    ((MainActivity)context).getAdapter().setMovieInfoList(DocumentUtil.getMovieInfoList());
                    ((MainActivity)context).getAdapter().notifyDataSetChanged();
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

}
