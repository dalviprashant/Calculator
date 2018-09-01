package com.example.prashant.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    double num1,num2;
    double ans=0;
    double num=0;
    char op='#';
    int flag,dec_flag=0,div=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b;
       flag=0;


    }
    public void ondigit(View v)
    {
        TextView t=(TextView)findViewById(R.id.textView);
        String s=t.getText().toString();
        flag=1;
        //int num=Integer.parseInt(s);
        int n;
        String ss;
        if(t.getText().equals("0"))
            t.setText("");
        switch(v.getId())
        {
            case R.id.b0:
                if(dec_flag==0)
                num=num*10;
                else
                    num+=0/div;
                //ss=Integer.toString(num);
                t.setText(t.getText()+"0");
                break;
            case R.id.b1:
                if(dec_flag==0)
                    num=num*10+1;
                else
                    num+=1/div;
                 //ss=Integer.toString(num);
                t.setText(t.getText()+"1");
                break;
            case R.id.b2:
                if(dec_flag==0)
                    num=num*10+2;
                else
                    num+=2/div;
               //  ss=Integer.toString(n);
                t.setText(t.getText()+"2");
                break;
            case R.id.b3:
                if(dec_flag==0)
                    num=num*10+3;
                else
                    num+=3/div;
                 //ss=Integer.toString(n);
                t.setText(t.getText()+"3");
                break;
            case R.id.b4:
                if(dec_flag==0)
                    num=num*10+4;
                else
                    num+=4/div;
                //ss=Integer.toString(n);
                t.setText(t.getText()+"4");
                break;
            case R.id.b5:
                if(dec_flag==0)
                    num=num*10+5;
                else
                    num+=5/div;
               // ss=Integer.toString(n);
                t.setText(t.getText()+"5");
                break;
            case R.id.b6:
                if(dec_flag==0)
                    num=num*10+6;
                else
                    num+=6/div;
               // ss=Integer.toString(n);
                t.setText(t.getText()+"6");
                break;
            case R.id.b7:
                if(dec_flag==0)
                    num=num*10+7;
                else
                    num+=7/div;
              //  ss=Integer.toString(n);
                t.setText(t.getText()+"7");
                break;
            case R.id.b8:
                if(dec_flag==0)
                    num=num*10+8;
                else
                    num+=8/div;
               // ss=Integer.toString(n);
                t.setText(t.getText()+"8");
                break;
            case R.id.b9:
                if(dec_flag==0)
                    num=num*10+9;
                else
                    num+=9/div;
               // ss=Integer.toString(n);
                t.setText(t.getText()+"9");
                break;

        }
        if(dec_flag==1)
            div*=10;
    }
    public void on_operation(View v)
    {
        div=10;
        dec_flag=0;
        TextView t=(TextView)findViewById(R.id.textView);
        String ss=t.getText().toString();
        num1=num;
        num=0;
        switch(v.getId())
        {
            case R.id.b_op1:
                op='/';
                t.setText(t.getText()+"/");
                break;
            case R.id.b_op2:
                op='*';
                t.setText(t.getText()+"*");
                break;
            case R.id.b_op3:
                op='+';
                t.setText(t.getText()+"+");

                break;
            case R.id.b_op4:
                op='-';
                t.setText(t.getText()+"-");

        }
    }
    public void on_equals(View v)
    {
        div=10;
        dec_flag=0;
        TextView t=(TextView)findViewById(R.id.textView);
        num2=num;
        String s="";

        switch(op)
        {
            case '/':
                try {
                    ans = num1 / num2;
                    s = Double.toString(ans);
                    }catch(ArithmeticException e)

                    {
                      s="Divide by zero";
                    }
                break;
            case '*':
                ans=num1*num2;
                 s=Double.toString(ans);
                break;
            case '+':
                ans=num1+num2;
                 s=Double.toString(ans);
                break;
            case '-':
                ans=num1-num2;
                s=Double.toString(ans);
                break;
            case '#':
                ans=num2;
                s=Double.toString(ans);

        }
        num=ans;
        t.setText("="+s+"\n");
        op='#';
    }
    public void set_flag(View v)
    {
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText(t.getText()+".");
        dec_flag=1;
    }

    public void delete_all(View v)
    {
        div=10;
        dec_flag=0;
        num1=num2=num=0;
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText("0");
    }
    public void del_last(View v)
    {
        div/=10;

        TextView t=(TextView)findViewById(R.id.textView);
        String s=t.getText().toString();
        if (s == null || s.length() == 0)
                s="0";
        else {
            s = s.substring(0, s.length() - 1);
            num = (int) (num / 10);
        }
        if(s.length()==0)
            s="0";
        t.setText(s);
    }

}
