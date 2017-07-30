package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Declare the several Views that will be used in various methods
    */
    private RadioGroup mQ1;
    private RadioGroup mQ2;
    private RadioGroup mQ3;
    private RadioGroup mQ4;
    private RadioGroup mQ5;
    private RadioGroup mQ6;
    private CheckBox mQ71;
    private CheckBox mQ72;
    private CheckBox mQ73;
    private CheckBox mQ74;
    private CheckBox mQ75;
    private EditText mQ8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQ1 = (RadioGroup) findViewById(R.id.RG_P1);
        mQ2 = (RadioGroup) findViewById(R.id.RG_P2);
        mQ3 = (RadioGroup) findViewById(R.id.RG_P3);
        mQ4 = (RadioGroup) findViewById(R.id.RG_P4);
        mQ5 = (RadioGroup) findViewById(R.id.RG_P5);
        mQ6 = (RadioGroup) findViewById(R.id.RG_P6);
        mQ71 = (CheckBox) findViewById(R.id.correct71);
        mQ72 = (CheckBox) findViewById(R.id.incorrect72);
        mQ73 = (CheckBox) findViewById(R.id.correct73);
        mQ74 = (CheckBox) findViewById(R.id.incorrect74);
        mQ75 = (CheckBox) findViewById(R.id.correct75);
        mQ8 = (EditText) findViewById(R.id.question_8);
    }

    /**
     * Evaluates the quiz result, if all questions are answered.
     * @param view: the submit button
     */
    public void submitAnswers(View view){

       if(!checkCompleted())
        {
            Toast.makeText(this, getString(R.string.incomplete_quiz), Toast.LENGTH_LONG).show();
        }
        else{
            if(checkAnswers() == 8){
                Toast.makeText(this, getString(R.string.complete_quiz_total), Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, getString(R.string.complete_partial, checkAnswers()), Toast.LENGTH_LONG).show();
            }
        }
    }
    /**
     * Checks if all the questions are answered.
     * @return  true if all the questions are answered, false otherwise
     */
   public boolean checkCompleted(){

        if(checkCompletedRadiogroups()&&checkCompletedCheckBoxes()&&
                checkCompletedEditBoxes()){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    * Checks if all the radiougroups are checked.
    * @return true if all the rediogroups are checked
    */
    public boolean checkCompletedRadiogroups(){
        if(mQ1.getCheckedRadioButtonId() != -1 &&
                mQ2.getCheckedRadioButtonId() != -1 &&
                mQ3.getCheckedRadioButtonId() != -1 &&
                mQ4.getCheckedRadioButtonId() != -1 &&
                mQ5.getCheckedRadioButtonId() != -1 &&
                mQ6.getCheckedRadioButtonId() != -1) {
            return true;
        }else{
            return false;
        }
    }

    /*
    * Checks if questions with checkboxes are checked.
    * @return true if at least one checkbox for question is checked
    */
    public boolean checkCompletedCheckBoxes(){
        if(mQ71.isChecked() || mQ72.isChecked() ||
                mQ73.isChecked() || mQ74.isChecked() ||
                mQ75.isChecked()){
            return true;
        } else {
            return false;
        }
    }

    /*
   * Checks if questions with Editboxes are answered.
   * @return true if some there has been text input
   */
    public boolean checkCompletedEditBoxes(){
        String q8Answer = mQ8.getText().toString();
        if(!TextUtils.isEmpty(q8Answer)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Checks the number of correct answers
     * @return  the number of correct answers
     */
    public int checkAnswers(){
        int countCorrectAnswers = 0;

        RadioButton correctRadioButton1 = (RadioButton)findViewById(R.id.correct1);
        if(correctRadioButton1.isChecked()){
            countCorrectAnswers += 1;
        }
        RadioButton correctRadioButton2 = (RadioButton)findViewById(R.id.correct2);
        if(correctRadioButton2.isChecked()){
            countCorrectAnswers += 1;
        }
        RadioButton correctRadioButton3 = (RadioButton)findViewById(R.id.correct3);
        if(correctRadioButton3.isChecked()){
            countCorrectAnswers += 1;
        }
        RadioButton correctRadioButton4 = (RadioButton)findViewById(R.id.correct4);
        if(correctRadioButton4.isChecked()){
            countCorrectAnswers += 1;
        }
        RadioButton correctRadioButton5 = (RadioButton)findViewById(R.id.correct5);
        if(correctRadioButton5.isChecked()){
            countCorrectAnswers += 1;
        }
        RadioButton correctRadioButton6 = (RadioButton)findViewById(R.id.correct6);
        if(correctRadioButton6.isChecked()){
            countCorrectAnswers += 1;
        }

        if(mQ71.isChecked() && mQ73.isChecked() && mQ75.isChecked() ){
            countCorrectAnswers +=1;
        }

        String q8Answer = mQ8.getText().toString();
        if(q8Answer.equals("5")){
            countCorrectAnswers +=1;
        }
        return countCorrectAnswers;
    }

    /**
     * Clears all the answers
     * @param view - the Reset Button
     */
    public void resetAnswers(View view){
        mQ1.clearCheck();
        mQ2.clearCheck();
        mQ3.clearCheck();
        mQ4.clearCheck();
        mQ5.clearCheck();
        mQ6.clearCheck();
        mQ71.setChecked(false);
        mQ72.setChecked(false);
        mQ73.setChecked(false);
        mQ74.setChecked(false);
        mQ75.setChecked(false);
        mQ8.setText("");
    }
}
