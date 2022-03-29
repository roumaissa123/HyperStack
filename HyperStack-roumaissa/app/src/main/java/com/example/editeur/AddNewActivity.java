package com.example.editeur;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

public class AddNewActivity extends AppCompatActivity {
    private EditText descriptionInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        EditText titleInput = findViewById(R.id.titleinput);
        EditText descriptionInput = findViewById(R.id.descriptioninput);
        MaterialButton saveBtn = findViewById(R.id.savebtn);


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                long createdTime = System.currentTimeMillis();

                realm.beginTransaction();
                editeur texte = realm.createObject(editeur.class);
                texte.setTitle(title);
                texte.setDescription(description);
                texte.setCreatedTime(createdTime);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(),"Page saved",Toast.LENGTH_SHORT).show();
                finish();


            }
        });
    }
    public void buttonBold(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        Spannable spannableString = new SpannableStringBuilder(descriptionInput.getText());
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                descriptionInput.getSelectionStart(),
                descriptionInput.getSelectionEnd(),
                0);

        descriptionInput.setText(spannableString);
    }

    public void buttonUnderline(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        Spannable spannableString = new SpannableStringBuilder(descriptionInput.getText());
        spannableString.setSpan(new UnderlineSpan(),
                descriptionInput.getSelectionStart(),
                descriptionInput.getSelectionEnd(),
                0);

        descriptionInput.setText(spannableString);
    }
    public void buttonAlignmentLeft(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        descriptionInput.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        Spannable spannableString = new SpannableStringBuilder(descriptionInput.getText());
        descriptionInput.setText(spannableString);
    }

    public void buttonAlignmentCenter(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        descriptionInput.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Spannable spannableString = new SpannableStringBuilder(descriptionInput.getText());
        descriptionInput.setText(spannableString);
    }

    public void buttonAlignmentRight(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        descriptionInput.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        Spannable spannableString = new SpannableStringBuilder(descriptionInput.getText());
        descriptionInput.setText(spannableString);
    }

    public void buttonClear(View view){
        descriptionInput = findViewById(R.id.descriptioninput);
        String stringText = descriptionInput.getText().toString();
        descriptionInput.setText(stringText);
    }
}
