package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;

public class httpJson {

    public String jsonRequest(String url) {
        String response = null;

        try {
            URL u = new URL(url);
            HttpURLConnection hr = (HttpURLConnection) u.openConnection();
            if (hr.getResponseCode() == 200) {
                InputStream im = hr.getInputStream();
                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                response = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    
     public String jsonRequest1(String url) {
        String response = null;

        try {
            URL u = new URL(url);
            HttpURLConnection hr = (HttpURLConnection) u.openConnection();
            hr.setRequestMethod("POST");
            if (hr.getResponseCode() == 200) {
                InputStream im = hr.getInputStream();
                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                response = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
