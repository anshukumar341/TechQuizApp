/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

/**
 *
 * @author Aftab
 */
public class QuestionPojo {
    private String examid;

    @Override
    public String toString() {
        return "QuestionPojo{" + "examid=" + examid + ", qno=" + qno + ", language=" + language + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer + ", question=" + question + '}';
    }
    private int qno;
    private String language;
    private String answer1,answer2,answer3,answer4;
    private String correctAnswer;
    private String question;

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.examid);
        hash = 43 * hash + this.qno;
        hash = 43 * hash + Objects.hashCode(this.language);
        hash = 43 * hash + Objects.hashCode(this.answer1);
        hash = 43 * hash + Objects.hashCode(this.answer2);
        hash = 43 * hash + Objects.hashCode(this.answer3);
        hash = 43 * hash + Objects.hashCode(this.answer4);
        hash = 43 * hash + Objects.hashCode(this.correctAnswer);
        hash = 43 * hash + Objects.hashCode(this.question);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionPojo other = (QuestionPojo) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examid, other.examid)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.answer1, other.answer1)) {
            return false;
        }
        if (!Objects.equals(this.answer2, other.answer2)) {
            return false;
        }
        if (!Objects.equals(this.answer3, other.answer3)) {
            return false;
        }
        if (!Objects.equals(this.answer4, other.answer4)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionPojo(String examid, int qno, String language, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String question) {
        this.examid = examid;
        this.qno = qno;
        this.language = language;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.question = question;
    }
    public QuestionPojo()
    {
        
    }
    
    
    
}
