package com.gsonkeno.english.learn.model;

public class WordDescription {
    private Integer number;

    private String word;

    private String soundMark;

    private String meaning;

    private String listIndex;

    private Integer listNo;

    public WordDescription(Integer number, String word, String soundMark, String meaning, String listIndex, Integer listNo) {
        this.number = number;
        this.word = word;
        this.soundMark = soundMark;
        this.meaning = meaning;
        this.listIndex = listIndex;
        this.listNo = listNo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSoundMark() {
        return soundMark;
    }

    public void setSoundMark(String soundMark) {
        this.soundMark = soundMark;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getListIndex() {
        return listIndex;
    }

    public void setListIndex(String listIndex) {
        this.listIndex = listIndex;
    }

    public Integer getListNo() {
        return listNo;
    }

    public void setListNo(Integer listNo) {
        this.listNo = listNo;
    }

    @Override
    public String toString() {
        return "WordDescription{" +
                "number=" + number +
                ", word='" + word + '\'' +
                ", soundMark='" + soundMark + '\'' +
                ", meaning='" + meaning + '\'' +
                ", listIndex='" + listIndex + '\'' +
                ", listNo=" + listNo +
                '}';
    }
}
