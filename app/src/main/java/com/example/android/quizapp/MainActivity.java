package com.example.android.quizapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.android.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*
    * Declare the several bindings that will be used in various methods
    */

    ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

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

        if(binding.question1.rgP1.getCheckedRadioButtonId() != -1 &&
                binding.question2.rgP2.getCheckedRadioButtonId() != -1 &&
                binding.question3.rgP3.getCheckedRadioButtonId() != -1 &&
                binding.question4.rgP4.getCheckedRadioButtonId() != -1 &&
                binding.question5.rgP5.getCheckedRadioButtonId() != -1 &&
                binding.question6.rgP6.getCheckedRadioButtonId() != -1) {
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
        if(binding.question7.question71.isChecked() || binding.question7.question72.isChecked() ||
                binding.question7.question73.isChecked() || binding.question7.question74.isChecked() ||
                binding.question7.question75.isChecked()){
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
        String q8Answer = binding.question8.question8.getText().toString();
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

        if(binding.question1.correct1.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question2.correct2.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question3.correct3.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question4.correct4.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question5.correct5.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question6.correct6.isChecked()){
            countCorrectAnswers += 1;
        }

        if(binding.question7.question71.isChecked() && binding.question7.question73.isChecked() && binding.question7.question75.isChecked() ){
            countCorrectAnswers +=1;
        }

        String q8Answer = binding.question8.question8.getText().toString();
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
        binding.question1.rgP1.clearCheck();
        binding.question2.rgP2.clearCheck();
        binding.question3.rgP3.clearCheck();
        binding.question4.rgP4.clearCheck();
        binding.question5.rgP5.clearCheck();
        binding.question6.rgP6.clearCheck();
        binding.question7.question71.setChecked(false);
        binding.question7.question72.setChecked(false);
        binding.question7.question73.setChecked(false);
        binding.question7.question74.setChecked(false);
        binding.question7.question75.setChecked(false);
        binding.question8.question8.setText("");
    }
}
