package com.github.jzohndev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InfoCalculator extends AppCompatActivity {
    EditText editText;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_calculator);
        editText =(EditText) findViewById(R.id.editText);
        textView =(TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
    }

    public void writeMessage(View view) throws IOException {
        String message = editText.getText().toString();
        File fileName = new File(getFilesDir(),"text");




        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter writer = new OutputStreamWriter(fos);
        BufferedWriter br = new BufferedWriter(writer);
        br.write(message);
        writer.close();
        fos.close();





        Toast.makeText(getApplicationContext(), "Message Saved", Toast.LENGTH_LONG).show();
        editText.setText("");
    }

    public void readMessage(View view) throws IOException {
        String message;
        File fileName = new File(getFilesDir(),"text");

        FileInputStream fileInput = new FileInputStream(fileName);
        InputStreamReader inputStream = new InputStreamReader(fileInput);

        BufferedReader bufferedReader = new BufferedReader(inputStream);
        StringBuilder stringBuffer = new StringBuilder();
        while ((message = bufferedReader.readLine()) != null);
        {
            stringBuffer.append(message + "\n");
        }
        textView.setText(stringBuffer);
        textView.setVisibility(View.VISIBLE);


    }
}
