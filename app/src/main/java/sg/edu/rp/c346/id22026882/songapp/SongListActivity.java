package sg.edu.rp.c346.id22026882.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {
    ListView lvSongs;
    ArrayList<String> songList;
    ArrayAdapter<String> aa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lvSongs = findViewById(R.id.lvSongs);
        songList = new ArrayList<>();

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lvSongs.setAdapter(aa);

        Intent intent = getIntent();
        String song = intent.getStringExtra("song");
        String singer = intent.getStringExtra("singer");
        int year = intent.getIntExtra("year", 0);
        int numStars = intent.getIntExtra("numStars", 0);

        String songInfo = song + "\n" + singer + "\n" + year + "\n" + numStars;
        songList.add(songInfo);
        aa.notifyDataSetChanged();
    }

}