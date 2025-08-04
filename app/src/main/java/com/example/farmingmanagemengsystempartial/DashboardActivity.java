package com.example.farmingmanagemengsystempartial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView animalTrack = findViewById(R.id.trackingTab);
        ImageView product = findViewById(R.id.productTab);
        ImageView educationalResources = findViewById(R.id.eduResourceTab);
        ImageView settings = findViewById(R.id.settingsTab);
        Button buttonAddFarm = findViewById(R.id.button_add_farm); // Make sure this button is in your layout


        animalTrack.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AnimalTrackActivity.class);
            startActivity(intent);
        });

        product.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProductActivity.class);
            startActivity(intent);
        });

        educationalResources.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, EducationalResourcesActivity.class);
            startActivity(intent);
        });

        settings.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        buttonAddFarm.setOnClickListener(v -> showAddFarmDialog());
    }

    private void showAddFarmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_farm, null);
        builder.setView(dialogView);

        TextView FarmOne = findViewById(R.id.farm_1);

        EditText editFarmName = dialogView.findViewById(R.id.edit_farm_name);
        Button buttonAddFarm = dialogView.findViewById(R.id.button_add_farm);
        TextView textCancel = dialogView.findViewById(R.id.text_cancel);

        buttonAddFarm.setOnClickListener(v -> {
            String farmName = editFarmName.getText().toString();

            //special character check
            Pattern specialCheck = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
            Matcher specialMatch = specialCheck.matcher(farmName);
            Boolean specialFind = specialMatch.find();

            if (!farmName.isEmpty()) {
                if(specialFind){
                    Toast.makeText(DashboardActivity.this, "No special characters.", Toast.LENGTH_SHORT).show();
                    editFarmName.setText("");
                }else{
                    FarmManager.getInstance().addFarm(farmName); // Add farm with data
                    Toast.makeText(DashboardActivity.this, "Farm added: " + farmName, Toast.LENGTH_SHORT).show();
                    // Clear fields after adding
                    editFarmName.setText("");

                    //display farm name
                    FarmOne.setText(farmName);
                }
            } else {
                Toast.makeText(DashboardActivity.this, "Please fill in the field.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        textCancel.setOnClickListener(v -> dialog.dismiss());
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("GrowthPrefs", MODE_PRIVATE);
        float averageWeight = prefs.getFloat("averageWeight", 0); // Default to 0 if not set
        // Update rectangle_11 based on averageWeight
        View rectangle11 = findViewById(R.id.rectangle_11);
        // Assuming the height of rectangle_11 is proportional to averageWeight
        float newHeight = averageWeight * 10; // Example scaling factor
        ViewGroup.LayoutParams params = rectangle11.getLayoutParams();
        params.height = (int) newHeight; // Set new height
        rectangle11.setLayoutParams(params);
    }
}