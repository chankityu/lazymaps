package com.example.mapwithmarker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.model.Marker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        TextView view = (TextView)findViewById(R.id.textView);
        EditText text = (EditText)findViewById(R.id.plain_text_input) ;

        view.setText(getIntent().getStringExtra("PLACE NAME"));
        final Markers mark = (Markers)MyPlace.getObjectForKey(getIntent().getStringExtra("PLACE NAME"));
        view.setText(mark.marker.getTitle());
        text.setText(mark.details);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MyPlace.addObjectForKey(mark.marker.getPosition().toString(),new Markers(mark.marker,charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
