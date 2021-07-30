package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.faendir.rhino_android.RhinoAndroidHelper;
import com.faendir.rhino_android.RhinoAndroidHelper;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;
public class MainActivity extends AppCompatActivity {Button
        btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnminus,btnmultiply,btndividsion,btnequa
    l,btnclear,btndot,btnbracket,btnpercentage;
    TextView tvinput,tvoutput;
    String process;
    boolean checkbracket = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnplus =findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnsubstract);
        btndividsion = findViewById(R.id.btndivision);
        btnmultiply = findViewById(R.id.btnmultiply);
        btnequal = findViewById(R.id.btnequalto);btnclear = findViewById(R.id.btnclear);
        btndot = findViewById(R.id.btndot);
        btnpercentage = findViewById(R.id.btnpercentage);
        btnbracket = findViewById(R.id.btnbrackets);
        tvinput = findViewById(R.id.tvinput);
        tvoutput = findViewById(R.id.tvoutput);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvinput.setText("");
                tvoutput.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();tvinput.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "5");}
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "9");
            }});
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "+");
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "-");
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "*");
            }
        });
        btndividsion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "/");}
        });
        btnpercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "%");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + ".");
            }
        });
        btnbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbracket)
                {
                    process = tvinput.getText().toString();
                    tvinput.setText(process + ")");
                    checkbracket = false;
                }
                else{
                    process = tvinput.getText().toString();
                    tvinput.setText(process + "(");
                    checkbracket = true;}
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                process = process.replaceAll("%","/100");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }tvoutput.setText(finalResult);
            }
        });
    }
}