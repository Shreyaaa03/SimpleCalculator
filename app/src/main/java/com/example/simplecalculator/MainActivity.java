package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView Screen;
    private Button AC, Power, Back, Div, Mul, Add, Sub, Zero, One, Two, Three, Four,
    Five, Six, Seven, Eight, Nine, Point, Equal;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Add = findViewById(R.id.add);
        Sub = findViewById(R.id.minus);
        Zero = findViewById(R.id.zero);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
       // Ans = findViewById(R.id.ans);
        Point = findViewById(R.id.point);
        Equal = findViewById(R.id.equal);

    }

    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC" :
                input="";
                break;
            case "Ans":
                input+=answer;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                answer=input;
                break;
            case "⬅":
                String newText=input.substring(0, input.length()-1);
                input= newText;
                break;
            default:
                if(input==null){
                    input= "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/") ){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }

    private void Solve(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            }
            catch(Exception e){

            }
        }
        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            }
            catch(Exception e){

            }
        }
        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double exp = Math.pow( Double.parseDouble(number[0]) ,Double.parseDouble(number[1]));
                input = exp + "";
            }
            catch(Exception e){

            }
        }
        else if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            }
            catch(Exception e){

            }
        }
        else if (input.split("-").length>1){
            String number[]=input.split("-");
            if(number[0]=="" && number.length==2){
                number[0] = 0+"";
            }
            try {
                double sub =0;
                if(number.length==2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                input = sub + "";
            }
            catch(Exception e){

            }
        }

        String r[]=input.split("\\.");
        if (r.length>1){
            if (r[1].equals("0")){
                input=r[0];
            }
        }
        Screen.setText(input);
    }

}