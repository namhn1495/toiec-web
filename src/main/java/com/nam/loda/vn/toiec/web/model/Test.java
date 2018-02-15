/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nam.loda.vn.toiec.web.model;

import com.google.gson.Gson;
import static com.nam.loda.vn.toiec.web.model.Helper.list;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loda
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Word w[] = gson.fromJson(new FileReader(new File("dataset.json")), Word[].class);
        List<Word> list = new ArrayList<>();
        for (Word g : w) {
            list.add(g);
//            URL u = new URL(g.getAudioUrl());
//            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
//            huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD"); 
//            huc.connect();
//            int code = huc.getResponseCode();
////            System.out.println(code);
//            if (code == 404) {
//
//                u = new URL(g.getAudioUrl().replaceAll("_", "%20"));
//                huc = (HttpURLConnection) u.openConnection();
//                huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD"); 
//                huc.connect();
//                if (huc.getResponseCode() == 200) {
//                    g.setAudioUrl(g.getAudioUrl().replaceAll("_", "%20"));
//                } else {
//                    System.out.println(g.getId() + " " + g.getRawText());
//                    System.out.println(g.getAudioUrl());
//                }
//            }
//            if(g.getId() == 380){
//                g.setAudioUrl("http://600tuvungtoeic.com/audio/mix%20up.mp3");
//            }
        }
//        System.out.println(gson.toJson(list));
        PrintWriter pw  = new PrintWriter(new File("dataset.json"));
        pw.println(gson.toJson(list));
        pw.close();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dataset.n"));
        out.writeObject(list);
        out.close();
    }
}
