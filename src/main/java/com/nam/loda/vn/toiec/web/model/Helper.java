/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nam.loda.vn.toiec.web.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author loda
 */
public class Helper {

    public static List<Word> list;
    public static LinkedList<Word> queue;
    public static int limit = 20;
    public static Word now;
    public static boolean isInit = false;
    public static Map<Integer,Integer> mapCounter;

    public static void init() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Path-: " + System.getProperty("java.class.path"));

        System.out.println("Path: " + Helper.class.getClassLoader().getResource(".").getPath());
        ObjectInputStream inputstream = new ObjectInputStream(new FileInputStream("/home/loda/NetBeansProjects/toiec-web/dataset.n"));
        list = (List<Word>) inputstream.readObject();
        inputstream.close();
        mapCounter = new HashMap<Integer, Integer>();
        queue = new LinkedList<>();
        getWords();
        isInit = true;
    }

    public static void getWords() {
        Collections.shuffle(list);
        for (Word w : list) {
            if (queue.size() == limit) {
                break;
            }
            if (!w.isDelAvailable()) {
                queue.add(w);
            }
        }
        if (queue.size() == 0) {
            for (Word w : list) {
                w.reset();
                if (queue.size() < limit) {
                    queue.add(w);
                }
            }

        }

    }

    public static void resetWords() {
        for (Word w : list) {
            w.reset();
        }
    }

    public static Word nextWord() {
        now = queue.get(0);
        if(mapCounter.get(now.getId())== null){
            mapCounter.put(now.getId(), 1);
        }else{
            mapCounter.put(now.getId(), mapCounter.get(now.getId())+1);
        }
        return now;
    }

    public static void setAnswer(int level) {
        now.setLevel(level);
        System.out.println(now.getRawText() + " " + now.level + " " + now.count);
        System.out.println(now.isDelAvailable());
        if (now.isDelAvailable()) {
            queue.remove(now);
            getWords();
        } else {
            queue.offer(queue.poll());
        }
    }

    public static void setLimit(Integer valueOf) {
        limit = valueOf;
        queue = new LinkedList<>();
        resetWords();
        getWords();
    }

}
