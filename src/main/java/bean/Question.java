package bean;

import java.io.Serializable;

public class Question implements Serializable {

    private static final long serialVersionUID=1L;
    private Integer id;
    private String genre;
    private String question;
    private String note1;
    private String note2;
    private String note3;
    private String note4;

    public Question(){}//コンストラクタ

    public Integer getId() {
        return id;
    }
    public String getGenre() {
        return genre;
    }
    public String getQuestion() {
        return question;
    }
    public String getNote1() {
        return note1;
    }
    public String getNote2() {
        return note2;
    }
    public String getNote3() {
        return note3;
    }
    public String getNote4() {
        return note4;
    }
    public void setQuizid(Integer id) {
        this.id=id;
    }
    public void setGenre(String genre) {
        this.genre=genre;
    }
    public void setQuestion(String question) {
        this.question=question;
    }
    public void setNote1(String note1) {
        this.note1=note1;
    }
    public void setNote2(String note2) {
        this.note2=note2;
    }
    public void setNote3(String note3) {
        this.note3=note3;
    }
    public void setNote4(String note4) {
        this.note4=note4;
    }
}