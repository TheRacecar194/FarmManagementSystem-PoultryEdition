package com.example.farmingmanagemengsystempartial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView notification = findViewById(R.id.notificationTab);
        ImageView animalTrack = findViewById(R.id.trackingTab);
        ImageView product = findViewById(R.id.productTab);
        ImageView educationalResources = findViewById(R.id.eduResourceTab);
        ImageView settings = findViewById(R.id.settingsTab);
        Button buttonAddFarm = findViewById(R.id.button_add_farm); // Make sure this button is in your layout

        notification.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, NotificationActivity.class);
            startActivity(intent);
        });

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

        EditText editFarmName = dialogView.findViewById(R.id.edit_farm_name);
        EditText editNumberOfChickens = dialogView.findViewById(R.id.edit_number_of_chickens);
        EditText editAverageWeight = dialogView.findViewById(R.id.edit_average_weight);
        Button buttonAddFarm = dialogView.findViewById(R.id.button_add_farm);
        TextView textCancel = dialogView.findViewById(R.id.text_cancel);

        buttonAddFarm.setOnClickListener(v -> {
            String farmName = editFarmName.getText().toString();
            String numberOfChickensStr = editNumberOfChickens.getText().toString();
            String averageWeightStr = editAverageWeight.getText().toString();

            if (!farmName.isEmpty() && !numberOfChickensStr.isEmpty() && !averageWeightStr.isEmpty()) {
                int numberOfChickens = Integer.parseInt(numberOfChickensStr);
                float averageWeight = Float.parseFloat(averageWeightStr);
                FarmManager.getInstance().addFarm(farmName, numberOfChickens, averageWeight); // Add farm with data
                Toast.makeText(DashboardActivity.this, "Farm added: " + farmName, Toast.LENGTH_SHORT).show();

                // Clear fields after adding
                editFarmName.setText("");
                editNumberOfChickens.setText("");
                editAverageWeight.setText("");
            } else {
                Toast.makeText(DashboardActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        textCancel.setOnClickListener(v -> dialog.dismiss());
    }
}