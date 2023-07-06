package sg.edu.rp.c346.id22026882.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etSingers;
    EditText etYear;
    RadioGroup rgStars;
    RadioButton selectedStar;
    Button buttonInsert;
    Button buttonView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonView = findViewById(R.id.buttonView);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                selectedStar = findViewById(rgStars.getCheckedRadioButtonId());
                String stars = selectedStar.getText().toString();
                db.insertSong(etTitle.getText().toString(), etSingers.getText().toString(), Integer.parseInt(etYear.getText().toString()), Integer.parseInt(stars));
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongListActivity.class);
            }
        });

    }
}