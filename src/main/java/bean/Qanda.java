package bean;

import java.io.Serializable;

public class Qanda implements Serializable {

    private static final long serialVersionUID=1L;
    private Integer quizid;
    private String genre;
    private String orderno;
    private String issue;
    private String note1;
    private String note2;
    private String note3;
    private String note4;
    private String judge;
    private String description;

    public Qanda(){}//コンストラクタ

    public Integer getQuizid() {
        return quizid;
    }
    public String getGenre() {
        return genre;
    }
    public String getOrderno() {
        return orderno;
    }
    public String getIssue() {
        return issue;
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
    public String getJudge() {
        return judge;
    }
    public String getDescription() {
        return description;
    }
    public void setQuizid(Integer quizid) {
        this.quizid=quizid;
    }
    public void setGenre(String genre) {
        this.genre=genre;
    }
    public void setOrderno(String orderno) {
        this.orderno=orderno;
    }
    public void setIssue(String issue) {
        this.issue=issue;
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
    public void setJudge(String judge) {
        this.judge=judge;
    }
    public void setDescription(String description) {
        this.description=description;
    }   
}