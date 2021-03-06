package com.example.android.egyptlandmarks;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    private RadioGroup radio1Group;
    private RadioGroup radio2Group;
    private RadioGroup radio3Group;
    private RadioGroup radio4Group;


    private EditText enterName;


    boolean resultQ1;
    boolean resultQ2;
    boolean resultQ3;
    boolean resultQ4;
    boolean resultQ5;
    boolean resultQ6;
    boolean resultQ7;
    boolean resultQ8;


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * display toast in Question 1
     */

    public void onRadioButtonClickedQ1(View view) {

        /**
         * Check if the Radio Button is checked
         */
        boolean checked = ((RadioButton) view).isChecked();

        /**
         *Check which radio button was clicked in Question 1. Right answer updates to true, wrong to false.
         */
        switch (view.getId()) {
            case (R.id.radio1a):
                if (checked)
                    resultQ1 = false;
                break;
            case R.id.radio1b:
                if (checked)
                    resultQ1 = true;
                break;
            case R.id.radio1c:
                if (checked)
                    resultQ1 = false;
                break;
            case R.id.radio1d:
                if (checked)
                    resultQ1 = false;
                break;
        }

    }

    /**
     *display toast in Question 4
     */
    public void onRadioButtonClickedQ2(View view) {

        /**
         *Check if the Radio Button is checked
         */
        boolean checked = ((RadioButton) view).isChecked();

        /**
         *Check which radio button was clicked in Question 4. Right answer updates to true, wrong to false.
         */
        switch (view.getId()) {
            case (R.id.radio4a):
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radio4b:
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radio4c:
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radio4d:
                if (checked)
                    resultQ4 = true;
                break;
        }
    }

    /**
     *display toast in Question 7
     */
    public void onRadioButtonClickedQ7(View view) {

        /**
         *Check if the Radio Button is checked
         */
        boolean checked = ((RadioButton) view).isChecked();

        /**
         *Check which radio button was clicked in Question 5. Right answer updates to true, wrong to false.
         */
        switch (view.getId()) {
            case (R.id.radio5a):
                if (checked)
                    resultQ7 = false;
                break;
            case R.id.radio5b:
                if (checked)
                    resultQ7 = false;
                break;
            case R.id.radio5c:
                if (checked)
                    resultQ7 = true;
                break;
            case R.id.radio5d:
                if (checked)
                    resultQ7 = false;
                break;
        }
    }

    /**
     *display toast in Question 8
     */
    public void onRadioButtonClickedQ8(View view) {

        /**
         *Check if the Radio Button is checked
         */
        boolean checked = ((RadioButton) view).isChecked();

        /**
         *Check which radio button was clicked in Question 5. Right answer updates to true, wrong to false.
         */
        switch (view.getId()) {
            case (R.id.radio6a):
                if (checked)
                    resultQ8 = false;
                break;
            case R.id.radio6b:
                if (checked)
                    resultQ8 = true;
                break;
            case R.id.radio6c:
                if (checked)
                    resultQ8 = false;
                break;
            case R.id.radio6d:
                if (checked)
                    resultQ8 = false;
                break;
        }
    }
    public void onClear(View v) {

        /**
         *Clears all selected radio buttons, checkboxes, edit texts to default
         */

        enterName = findViewById(R.id.enter_name);
        enterName.setText("");

        radio1Group = findViewById(R.id.radioGroup1);
        radio1Group.clearCheck();
        radio2Group = findViewById(R.id.radioGroup2);
        radio2Group.clearCheck();
        radio3Group = findViewById(R.id.radioGroup3);
        radio3Group.clearCheck();
        radio4Group = findViewById(R.id.radioGroup4);
        radio4Group.clearCheck();

        CheckBox checkBox2_1 = findViewById(R.id.checkbox2a);
        checkBox2_1.setChecked(false);
        CheckBox checkBox2_2 = findViewById(R.id.checkbox2b);
        checkBox2_2.setChecked(false);
        CheckBox checkBox2_3 = findViewById(R.id.checkbox2c);
        checkBox2_3.setChecked(false);
        CheckBox checkBox2_4 = findViewById(R.id.checkbox2d);
        checkBox2_4.setChecked(false);


        CheckBox checkBox3_1 = findViewById(R.id.checkbox3a);
        checkBox3_1.setChecked(false);
        CheckBox checkBox3_2 = findViewById(R.id.checkbox3b);
        checkBox3_2.setChecked(false);
        CheckBox checkBox3_3 = findViewById(R.id.checkbox3c);
        checkBox3_3.setChecked(false);
        CheckBox checkBox3_4 = findViewById(R.id.checkbox3d);
        checkBox3_4.setChecked(false);



        EditText question5 = findViewById(R.id.edittext1);
        question5.setText("");
        EditText question6 = findViewById(R.id.edittext2);
        question6.setText("");

        resultQ1 = false;
        resultQ2 = false;
        resultQ3 = false;
        resultQ4 = false;
        resultQ5 = false;
        resultQ6 = false;
        resultQ7 = false;
        resultQ8 = false;

        score = 0;
    }
    /**
     *Method called when Submit Button is clicked.
     */
    public void onSubmit(View view) {

        // User add his name for quiz
        EditText nameInput = (EditText) findViewById(R.id.enter_name);
        String userName = nameInput.getText().toString();

        CheckBox question2__1 = (CheckBox) findViewById(R.id.checkbox2a);
        boolean question2_1 = question2__1.isChecked();
        CheckBox question2__2 = (CheckBox) findViewById(R.id.checkbox2b);
        boolean question2_2 = question2__2.isChecked();
        CheckBox question2__3 = (CheckBox) findViewById(R.id.checkbox2c);
        boolean question2_3 = question2__3.isChecked();
        CheckBox question2__4 = (CheckBox) findViewById(R.id.checkbox2d);
        boolean question2_4 = question2__4.isChecked();

        /**
         *Warning if RadioGroup is empty in question 1
         */
        RadioGroup radio1Group = findViewById(R.id.radioGroup1);
        if (radio1Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ1, Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         *Warning if CheckBox is empty in question 2
         */
        if ((!question2_2) && (!question2_3) && (!question2_1) && (!question2_4)) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ2, Toast.LENGTH_SHORT).show();
            return;
        }
        if ((question2_1) && (question2_4) && (!question2_2) && (!question2_3)) {
            resultQ2 = true;
        }
        CheckBox question3__1 = (CheckBox) findViewById(R.id.checkbox3a);
        boolean question3_1 = question3__1.isChecked();
        CheckBox question3__2 = (CheckBox) findViewById(R.id.checkbox3b);
        boolean question3_2 = question3__2.isChecked();
        CheckBox question3__3 = (CheckBox) findViewById(R.id.checkbox3c);
        boolean question3_3 = question3__3.isChecked();
        CheckBox question3__4 = (CheckBox) findViewById(R.id.checkbox3d);
        boolean question3_4 = question3__4.isChecked();


        /**
         *Warning if CheckBox is empty in question 3
         */
        if ((!question3_2) && (!question3_3) && (!question3_1) && (!question3_4)) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ3, Toast.LENGTH_SHORT).show();
            return;
        }
        if ((question3_1) && (question3_3) && (!question3_2) && (!question3_4)) {
            resultQ3 = true;
        }

        /**
         *Warning if RadioGroup is empty in question 4
         */
        RadioGroup radio2Group = findViewById(R.id.radioGroup2);
        if (radio2Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ4, Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         *Warning if RadioGroup is empty in question 7
         */
        RadioGroup radio3Group = findViewById(R.id.radioGroup3);
        if (radio3Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ7, Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         *Warning if RadioGroup is empty in question 8
         */
        RadioGroup radio4Group = findViewById(R.id.radioGroup4);
        if (radio4Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ1, Toast.LENGTH_SHORT).show();
            return;
        }


        /**
         *Question 5 correct answer is 25 Jan 2011
         */
        EditText question_5 = findViewById(R.id.edittext1);
        String question5 = question_5.getText().toString();

        /**
         *Warning if EditText is empty in question 5
         */
        if (question5.isEmpty()) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ5, Toast.LENGTH_SHORT).show();
            return;
        }
        if (question5.equals(getString(R.string.Jan_25))) {
            resultQ5 = true;
        }

        /**
         *Question 6 correct answer is Mount Musa
         */
        EditText question_6 = findViewById(R.id.edittext2);
        String question6 = question_6.getText().toString();

        /**
         *Warning if EditText is empty in question 6
         */
        if (question6.isEmpty()) {
            score = 0;
            Toast.makeText(this, R.string.missinganwserQ6, Toast.LENGTH_SHORT).show();
            return;
        }
        if (question6.equals(getString(R.string.Mount_Musa))) {
            resultQ6 = true;
        }

        /**
         *Calls method to calculate the score.
         */
        int finalScore = calculateScore(score, resultQ1, resultQ2, resultQ3, resultQ4 , resultQ5 , resultQ6 , resultQ7 , resultQ8 );

        /**
         *Create a toast message, displayed when a user fills in an answer.
         */
        CharSequence textToast = "\n" + getString(R.string.thanks);

        /**
         *Message if Questions is Correct or Wrong
         */
        String message = "";
        if (resultQ1) { message += "\n" + getString(R.string.Q1isCorrect);}
        else {message += "\n" + getString(R.string.Q1isWrong);}
        if (resultQ2) { message += "\n" + getString(R.string.Q2isCorrect);}
        else {message += "\n" + getString(R.string.Q2isWrong);}
        if (resultQ3) { message += "\n" + getString(R.string.Q3isCorrect);}
        else {message += "\n" + getString(R.string.Q3isWrong);}
        if (resultQ4) { message += "\n" + getString(R.string.Q4isCorrect);}
        else {message += "\n" + getString(R.string.Q4isWrong);}
        if (resultQ5) { message += "\n" + getString(R.string.Q5isCorrect);}
        else {message += "\n" + getString(R.string.Q5isWrong);}
        if (resultQ6) { message += "\n" + getString(R.string.Q6isCorrect);}
        else {message += "\n" + getString(R.string.Q6isWrong);}
        if (resultQ7) { message += "\n" + getString(R.string.Q7isCorrect);}
        else {message += "\n" + getString(R.string.Q7isWrong);}
        if (resultQ8) { message += "\n" + getString(R.string.Q8isCorrect);}
        else {message += "\n" + getString(R.string.Q8isWrong);}
        Toast.makeText(this,  textToast +" "+ userName + "\n" + getString(R.string.score) + " " + finalScore +"\n" + message, Toast.LENGTH_SHORT).show();
    }
    public int calculateScore(int score, boolean resultQ1, boolean resultQ2, boolean resultQ3, boolean resultQ4 , boolean resultQ5 , boolean resultQ6 ,boolean resultQ7 , boolean resultQ8) {
        if (resultQ1) {
            score += 1;
        }
        if (resultQ2) {
            score += 1;
        }
        if (resultQ3) {
            score += 1;
        }
        if (resultQ4) {
            score += 1;
        }
        if (resultQ5) {
            score += 1;
        }
        if (resultQ6) {
            score += 1;
        }
        if (resultQ7) {
            score += 1;
        }
        if (resultQ8) {
            score += 1;
        }
        return (score);
    }
}


