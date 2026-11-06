package com.example.gittest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> photoIds = new ArrayList<>();
    int photoId = 0;
    Random rnd = new Random();
    Button nextButton, randomButton, prevButton;
    ImageView currentPhoto;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        currentPhoto = findViewById(R.id.imageView2);
        prevButton = findViewById(R.id.button);
        randomButton = findViewById(R.id.button2);
        nextButton = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);

        photoIds.add(R.drawable.leaves);
        photoIds.add(R.drawable.patryk);
        photoIds.add(R.drawable.shroom);
        photoIds.add(R.drawable.waterfall);

        currentPhoto.setImageResource(photoIds.get(photoId));

        nextButton.setOnClickListener(view -> {
            if (photoId < photoIds.size()-1){
                textView.setText("");
                photoId++;
                currentPhoto.setImageResource(photoIds.get(photoId));
            }
            else{
                textView.setText("To jest ostatnie zdjęcie");
            }
        });
        prevButton.setOnClickListener(view -> {
            if (photoId > 0){
                photoId--;
                currentPhoto.setImageResource(photoIds.get(photoId));
                textView.setText("");
            }
            else{
                textView.setText("To jest pierwsze zdjęcie");
            }
        });

        randomButton.setOnClickListener(view -> {
            currentPhoto.setImageResource(photoIds.get(rnd.nextInt(4)));
        });
    }
}