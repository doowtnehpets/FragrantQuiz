package com.example.android.fragrantquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays a toast message telling the user to answer all the questions
     */
    private void incompleteToastMessage() {
        Toast.makeText(this, getString(R.string.all_questions), Toast.LENGTH_LONG).show();
    }

    /**
     * Goes through each of the questions answered by the user and gives them a score
     * @param view
     */
    public void submitAnswers(View view) {
        int score = 0;

/*------------------------------------------------------------------------------------------------*/

        // Question 1
        RadioButton question1_answer1_radiobutton = findViewById(R.id.question1_answer1_radiobutton),
                question1_answer2_radiobutton = findViewById(R.id.question1_answer2_radiobutton),
                question1_answer3_radiobutton = findViewById(R.id.question1_answer3_radiobutton),
                question1_answer4_radiobutton = findViewById(R.id.question1_answer4_radiobutton);

        if (!question1_answer1_radiobutton.isChecked() &&
                !question1_answer2_radiobutton.isChecked() &&
                !question1_answer3_radiobutton.isChecked() &&
                !question1_answer4_radiobutton.isChecked()) {
            incompleteToastMessage();
            return;
        }

        //Checks if correct answer is select and adds plus 1 to score if answer is correct
        if (question1_answer2_radiobutton.isChecked()) score++;

/*------------------------------------------------------------------------------------------------*/

        // Question 2
        EditText question2_answer_edittext = findViewById(R.id.question2_answer_edittext);

        //Compares text entered to correct answer and adds plus 1 to score if answer is correct
        if (question2_answer_edittext.getText().toString().equalsIgnoreCase(getString(R.string.question2_answer)))
            score++;

/*------------------------------------------------------------------------------------------------*/

        // Question 3
        RadioButton question3_answer1_radiobutton = findViewById(R.id.question3_answer1_radiobutton),
                question3_answer2_radiobutton = findViewById(R.id.question3_answer2_radiobutton),
                question3_answer3_radiobutton = findViewById(R.id.question3_answer3_radiobutton),
                question3_answer4_radiobutton = findViewById(R.id.question3_answer4_radiobutton);

        //Check if question was answered, if not, display error message
        if (!question3_answer1_radiobutton.isChecked() &&
                !question3_answer2_radiobutton.isChecked() &&
                !question3_answer3_radiobutton.isChecked() &&
                !question3_answer4_radiobutton.isChecked()) {
            incompleteToastMessage();
            return;
        }

        //Checks if correct answer was selected and adds plus 1 to score if answer is correct
        if (question3_answer3_radiobutton.isChecked()) score++;

/*------------------------------------------------------------------------------------------------*/

        // Question 4
        CheckBox question4_answer1 = findViewById(R.id.question4_answer1_checkbox),
                question4_answer2 = findViewById(R.id.question4_answer2_checkbox),
                question4_answer3 = findViewById(R.id.question4_answer3_checkbox),
                question4_answer4 = findViewById(R.id.question4_answer4_checkbox);

        //Count how many check boxes the user selected. If less than 2, display error
        int checkCount = 0;
        if (question4_answer1.isChecked()) checkCount++;
        if (question4_answer2.isChecked()) checkCount++;
        if (question4_answer3.isChecked()) checkCount++;
        if (question4_answer4.isChecked()) checkCount++;
        if (checkCount < 2) {
            incompleteToastMessage();
            return;
        } else {
            //Checks if the 2 correct answers are select and adds plus 1 to score if answer is correct
            if (question4_answer2.isChecked() && question4_answer4.isChecked() &&
                    !question4_answer1.isChecked() && !question4_answer3.isChecked()) score++;
        }

/*------------------------------------------------------------------------------------------------*/

        // Question 5
        RadioButton question5_answer1_radiobutton = findViewById(R.id.question5_answer1_radiobutton),
                question5_answer2_radiobutton = findViewById(R.id.question5_answer2_radiobutton),
                question5_answer3_radiobutton = findViewById(R.id.question5_answer3_radiobutton),
                question5_answer4_radiobutton = findViewById(R.id.question5_answer4_radiobutton);

        //Checks if an answer was selected, if not then an error message is displayed
        if (!question5_answer1_radiobutton.isChecked() &&
                !question5_answer2_radiobutton.isChecked() &&
                !question5_answer3_radiobutton.isChecked() &&
                !question5_answer4_radiobutton.isChecked()) {
            incompleteToastMessage();
            return;
        }

        //Checks if correct answer was select and adds plus 1 to score if answer is correct
        if (question5_answer4_radiobutton.isChecked()) score++;

/*------------------------------------------------------------------------------------------------*/

        //Toast message with score
        String toastMessage;

        //Set message based on total score out of 5
        if (score == 5) toastMessage = getString(R.string.grade_amazing, score);
        else if (score <= 2) toastMessage = getString(R.string.grade_bad, score);
        else toastMessage = getString(R.string.grade_good, score);

        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }
}
