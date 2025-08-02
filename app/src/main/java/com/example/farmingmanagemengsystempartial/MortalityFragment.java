//package com.example.farmingmanagemengsystempartial;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class AnimalTrackMortality extends AppCompatActivity {
//    Dialog dialog;
//    ImageView Back, AddReportData, applyChanges;
//    TextView Feeds, Growth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_animal_track_mortality);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        AddReportData = findViewById(R.id.add_feeding_box2);
//        AddReportData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog = new Dialog(AnimalTrackMortality.this);
//                dialog.setContentView(R.layout.add_report_data);
//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//
//                applyChanges = dialog.findViewById(R.id.imageView38);
//
//                applyChanges.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        dialog.dismiss();
//                    }
//                });
//
//                dialog.show();
//            }
//        });
//
//
//        Back = findViewById(R.id.imageView31);
//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AnimalTrackMortality.this, DashboardActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Feeds = findViewById(R.id.feeds3);
//        Feeds.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AnimalTrackMortality.this, AnimalTrackFeeds.class);
//                startActivity(intent);
//            }
//        });
//
//        Growth = findViewById(R.id.growth3);
//        Growth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AnimalTrackMortality.this, AnimalTrackActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}