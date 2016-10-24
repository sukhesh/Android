package com.sukhesh.texttospeach;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener, View.OnClickListener {

    EditText etInput;
    Button clear,speak;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.input);
        clear=(Button) findViewById(R.id.btnClear);
        speak=(Button) findViewById(R.id.btnSpeak);

        clear.setOnClickListener(this);
        speak.setOnClickListener(this);

        tts = new TextToSpeech(this,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnClear:
                etInput.setText("");
                break;

            case R.id.btnSpeak:
                String text = etInput.getText().toString();
                if(text.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Text is empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
        }
    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS)
        {
            Locale lang = tts.getLanguage();
            int result = tts.setLanguage(lang);

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTS","This Language is not supported");
            }
            else
            {
                // Do Nothing
            }

        }
        else
        {
            Log.e("TTS","initialisation failed");
        }
    }
}
