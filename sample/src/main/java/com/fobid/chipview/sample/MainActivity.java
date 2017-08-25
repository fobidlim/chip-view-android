package com.fobid.chipview.sample;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fobid.chipview.ui.widgets.ChipTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edit_text);
        final LinearLayout chipsContainer = (LinearLayout) findViewById(R.id.chips_container);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                final ChipTextView chipTextView = new ChipTextView(MainActivity.this);
                chipTextView.setText(editText.getText());
                chipTextView.setTextColor(Color.WHITE);
                chipTextView.setBackgroundColor(Color.BLACK);

                chipsContainer.addView(chipTextView);

                @SuppressLint("InflateParams")
                final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.i_chip, null);
                ChipTextView chipTextView2 = view.findViewById(R.id.chip_text_view);
                chipTextView2.setText(editText.getText());

                chipsContainer.addView(chipTextView2);

                editText.setText("");
                return false;
            }
        });
    }
}
