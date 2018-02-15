/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nam.loda.vn.toiec.web.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author loda
 */
public class Word implements Serializable {
    public static final int FAIL = 1;
    public static final int HARD = 2;
    public static final int GOOD = 3;
    public static final int EASY = 4;
    
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("rawText")
    @Expose
    private String rawText;
    @SerializedName("phonetic")
    @Expose
    private String phonetic;
    @SerializedName("explain")
    @Expose
    private String explain;
    @SerializedName("meaningInVietNam")
    @Expose
    private String meaningInVietNam;
    @SerializedName("exampleEng")
    @Expose
    private String exampleEng;
    @SerializedName("exampleVi")
    @Expose
    private String exampleVi;
    @SerializedName("audioUrl")
    @Expose
    private String audioUrl;
    public int level;
    public int count;
    
    public void increase(){
        count++;
    }
    public Word(){
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getMeaningInVietNam() {
        return meaningInVietNam;
    }

    public void setMeaningInVietNam(String meaningInVietNam) {
        this.meaningInVietNam = meaningInVietNam;
    }

    public String getExampleEng() {
        return exampleEng;
    }

    public void setExampleEng(String exampleEng) {
        this.exampleEng = exampleEng;
    }

    public String getExampleVi() {
        return exampleVi;
    }

    public void setExampleVi(String exampleVi) {
        this.exampleVi = exampleVi;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", imageUrl=" + imageUrl + ", rawText=" + rawText + ", phonetic=" + phonetic + ", explain=" + explain + ", meaningInVietNam=" + meaningInVietNam + ", exampleEng=" + exampleEng + ", exampleVi=" + exampleVi + ", audioUrl=" + audioUrl + ", level=" + level + ", count=" + count + '}';
    }



    void reset() {
        this.level = 0;
        this.count = 0;
    }

    boolean isDelAvailable() {
        if(level == EASY && count > 1) {
            return true;
        }
        if(level == GOOD && count > 3){
            return true;
        }
        return false;
    }

    void setLevel(int level) {
        if(level == this.level){
            count++;
        }else{
            this.level = level;
            this.count = 0;
        }
    }
    
}
