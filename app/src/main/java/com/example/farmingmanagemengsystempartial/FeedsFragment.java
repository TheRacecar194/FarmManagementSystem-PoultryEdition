package com.example.farmingmanagemengsystempartial;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FeedsFragment extends Fragment {
    Dialog dialog;
    Button addFeedingDataBtn;
    TextView currentFeedTypeTextView; // Reference to the current feed type TextView
    TextView todaysValueTextView; // Reference to today's value TextView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        addFeedingDataBtn = view.findViewById(R.id.Add_Feeding_Data_Btn);
        currentFeedTypeTextView = view.findViewById(R.id.CurrentFeedTypes); // Initialize TextView reference
        todaysValueTextView = view.findViewById(R.id.TodaysValue); // Initialize today's value TextView reference

        addFeedingDataBtn.setOnClickListener(v -> showAddFeedingDataDialog());

        return view;
    }

    private void showAddFeedingDataDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_feed); // Layout for the dialog
        dialog.getWindow().setLayout(1000, ViewGroup.LayoutParams.WRAP_CONTENT); // Set dialog width

        EditText feedTypeEdit = dialog.findViewById(R.id.editTextNumber); // Feed type input
        EditText amountInKgEdit = dialog.findViewById(R.id.editTextNumber3); // Weight input
        Button applyChanges = dialog.findViewById(R.id.ApplyChangesBTN);

        applyChanges.setOnClickListener(v -> {
            String feedType = feedTypeEdit.getText().toString().trim();
            String amountInKg = amountInKgEdit.getText().toString().trim();

            if (!feedType.isEmpty() && !amountInKg.isEmpty()) {
                // Update the current feed type TextView
                currentFeedTypeTextView.setText(feedType);

                // Update the Today's Value TextView
                todaysValueTextView.setText(amountInKg + "kg");

                // Display a message or handle the data as needed
                Toast.makeText(getActivity(), "Data Added: " + feedType + " - " + amountInKg, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            } else {
                Toast.makeText(getActivity(), "Please fill all required fields.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}