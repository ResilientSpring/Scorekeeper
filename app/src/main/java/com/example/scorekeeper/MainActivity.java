package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for holding the score.
    private int mScore1 = 0;
    private int mScore2 = 0;

    // Member variables for holding the score
    private TextView mScoreText1;
    private TextView mScoreText2;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        // Save the score.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextViews by ID
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        if (savedInstanceState != null){
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            // Set the score text views.
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode){

            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            // Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            // Recreate the activity for the theme change to take effect.
            recreate();
        }

        // TODO: Get the night mode state of the app.

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES)
            menu.findItem(R.id.night_mode).setTitle("Day Mode");
        else menu.findItem(R.id.night_mode).setTitle("Night Mode");

        return true;
    }

    public void decreaseScore(View view) {

        // Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){

            // IF it was on Team 1
            case R.id.decreaseTeam1:

                // Decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            // If it was Team 2
            case R.id.decreaseTeam2:

                // Decrement the score and update the TextView
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View view) {

        int viewID = view.getId();
        switch (viewID){

            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }


    }
}