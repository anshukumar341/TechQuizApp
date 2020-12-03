/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import techquizapp.dao.PerformanceDao;
import techquizapp.dao.QuestionDao;
import techquizapp.pojo.AnswerPojo;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.ExamPojo;
import techquizapp.pojo.PerformancePojo;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Aftab
 */
public class TakeTestFrame extends javax.swing.JFrame {
    
    private ExamPojo exam;
    private QuestionStore qstore;
    private AnswerStore astore;
    private int qno=1,pos=0;
   // Timer t;

    /**
     * Creates new form TakeTestFrame
     */
    public TakeTestFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsername.setText("Hello "+UserProfile.getUsername());
        qstore=new QuestionStore();
        astore=new AnswerStore();
        //qno=1;
        lblQno.setText(lblQno.getText()+qno);
    }
    
    public TakeTestFrame(ExamPojo exam)
    {
        this();
        this.exam=exam;
        lblTitle.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
        
//        t=new Timer(1000,new ActionListener()
//        {
//           public void actionPerformed(ActionEvent e)
//        {
//            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
//            lblTime.setText(sdf.format(new java.util.Date()));
//        }
//        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblQno = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 102, 0));
        lblTitle.setText("JAVA PAPER");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquizapp/gui/images/good luck2.jpg"))); // NOI18N

        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        lblQno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 102, 0));
        lblQno.setText("Question no:");

        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption1.setText("jRadioButton1");

        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption2.setText("jRadioButton2");

        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption3.setText("jRadioButton3");

        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(255, 102, 0));
        jrbOption4.setText("jRadioButton4");

        btnNext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 102, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 102, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 102, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 102, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(79, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevious)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblQno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jrbOption3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jrbOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrbOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jrbOption4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption1)
                    .addComponent(jrbOption2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption3)
                    .addComponent(jrbOption4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnCancel)
                    .addComponent(btnDone))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
        QuestionPojo question=qstore.getQuestion(pos);
        String correctAnswer=question.getCorrectAnswer();
       AnswerPojo newanswer=new AnswerPojo();//exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
       newanswer.setExamid(exam.getExamId());
       newanswer.setQno(qno);
       newanswer.setSubject(exam.getLanguage());
       newanswer.setChosenAnswer(chosenAnswer);
       newanswer.setCorrectAnswer(correctAnswer);
        System.out.println(newanswer);
        AnswerPojo answer=astore.getAnswerByQno(qno);
        if(answer==null)
            astore.addAnswer(newanswer);
        else{
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
     }
        pos++;
        if(pos>=qstore.getCount())
        {
            pos=0;
        }
         qno++;         
        if(qno>qstore.getCount())
                qno=1;
        lblQno.setText("Question no:"+qno);
        showQuestion();
    }   
public String getUserAnswer(){
        
        if(jrbOption1.isSelected())
            return "Answer1";
        else if(jrbOption2.isSelected())
            return "Answer2";
        else if(jrbOption3.isSelected())
            return "Answer3";
        else if(jrbOption4.isSelected())
            return "Answer4";
        else
            return null;

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
        QuestionPojo question=qstore.getQuestion(pos);
        String correctAnswer=question.getCorrectAnswer();
        AnswerPojo newanswer=new AnswerPojo();//exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
        newanswer.setExamid(exam.getExamId());
        newanswer.setSubject(exam.getLanguage());
        newanswer.setQno(qno);
        newanswer.setChosenAnswer(chosenAnswer);
        newanswer.setCorrectAnswer(correctAnswer);
        System.out.println(newanswer);
        AnswerPojo answer=astore.getAnswerByQno(qno);
        if(answer==null)
            astore.addAnswer(newanswer);
        else{
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
     }
        pos--;
        if(pos<0)
        {
            pos=qstore.getCount()-1;
        }
      qno--;
        if(qno<=0)
        qno=qstore.getCount();
        lblQno.setText("Question no:"+qno);
        showQuestion();

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        
       String userAnswer=getUserAnswer();
        if(userAnswer!=null){
        QuestionPojo question=qstore.getQuestion(pos);
        String correctAnswer=question.getCorrectAnswer();
        
                
        AnswerPojo newanswer=new AnswerPojo();//exam.getExamId(),exam.getLanguage(),qno,userAnswer,correctAnswer);
        
         newanswer.setExamid(exam.getExamId());
        newanswer.setSubject(exam.getLanguage());
        newanswer.setQno(qno);
        newanswer.setChosenAnswer(userAnswer);
        newanswer.setCorrectAnswer(correctAnswer);System.out.println(newanswer);
        AnswerPojo answer=astore.getAnswerByQno(qno);
        if(answer==null)
            astore.addAnswer(newanswer);
        else{
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
        }
        int right=0,wrong=0;
        for(QuestionPojo question:qstore.getAllQuestions()){
            int qno=question.getQno();
            AnswerPojo answer=astore.getAnswerByQno(qno);
            if(answer==null)
                continue;
            else
            {
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                if(chosenAnswer1.equals(correctAnswer))
                    ++right;
                else
                    ++wrong;
                    
            }
            
        }
        String reportCard="Total Questions:"+qstore.getCount();
        reportCard+="\nRight Answers:"+right;
        reportCard+="\nWrong Answers:"+wrong;
        reportCard+="\nUnAttempted  :"+(qstore.getCount()-(right+wrong));
        JOptionPane.showMessageDialog(null, reportCard,"Your Result!",JOptionPane.INFORMATION_MESSAGE);
 try{
            PerformancePojo performance=new PerformancePojo();//exam.getExamId(),exam.getLanguage(),UserProfile.getUsername(),right,wrong,(qstore.getCount()-(right+wrong)),(double)right/qstore.getCount()*100);
            performance.setExamId(exam.getExamId());
            performance.setLanguage(exam.getLanguage());
            performance.setUserId(UserProfile.getUsername());
            performance.setRight(right);
            performance.setWrong(wrong);
            performance.setUnattempted(qstore.getCount()-(right+wrong));
            performance.setPer((double)right/qstore.getCount()*100);
            PerformanceDao.addPerformance(performance);
            JOptionPane.showMessageDialog(null, "Your performance has been successfully added to the database"," Performance Added!",JOptionPane.INFORMATION_MESSAGE);
            PaperSelectionFrame paperFrame=new PaperSelectionFrame();
            paperFrame.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        PaperSelectionFrame psf=new PaperSelectionFrame();
        psf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
 
      
      public void loadQuestions()
      {
          try
          {
              ArrayList<QuestionPojo> questionList=QuestionDao.getQuestionByExamId(exam.getExamId());
              for(QuestionPojo obj:questionList)
              {
                  qstore.addQuestion(obj);
              }
          }
          catch(SQLException ex)
          {
              JOptionPane.showMessageDialog(null, "Error while connecting to DB!", "Exception!", JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
          }
      }
      
      public void showQuestion(){
        QuestionPojo question=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(question.getQuestion());
        txtQuestion.setEditable(false);
        jrbOption1.setText(question.getAnswer1());
        jrbOption2.setText(question.getAnswer2());
        jrbOption3.setText(question.getAnswer3());
        jrbOption4.setText(question.getAnswer4());
        AnswerPojo answer=astore.getAnswerByQno(qno);
        if(answer==null)
            return;
        String chosenAnswer=answer.getChosenAnswer();
        switch(chosenAnswer){
            case "Answer1":
                jrbOption1.setSelected(true);
                break;
            case "Answer2":
                jrbOption2.setSelected(true);
                break;
            case "Answer3":
                jrbOption3.setSelected(true);
                break;
            case "Answer4":
                jrbOption4.setSelected(true);
                break;
        }
        
    }

}