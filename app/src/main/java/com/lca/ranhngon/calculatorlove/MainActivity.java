package com.lca.ranhngon.calculatorlove;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    String math, sxuat = "";
    TextView etGiatri;
    Float fthamso1, fthamso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGiatri = (TextView) findViewById(R.id.edtKq);
        int[] idbutton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btnAdd, R.id.btnDel, R.id.btnDivide, R.id.btnT, R.id.btnNhan, R.id.btnEqual, R.id.btnDot};
        for (int id : idbutton) {
            View v1 = findViewById(id);
            v1.setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                math = "+";
                TOperation();
                break;
            case R.id.btnT:
                math = "-";
                TOperation();
                break;
            case R.id.btnNhan:
                math = "*";
                TOperation();
                break;
            case R.id.btnDivide:
                math = "/";
                TOperation();
                break;
            case R.id.btnEqual:
                Float kq = null;
                fthamso2 = Float.parseFloat(etGiatri.getText().toString());
                if (math == "+") {
                    kq = fthamso1 + fthamso2;
                }
                if (math == "-") {
                    kq = fthamso1 - fthamso2;
                }
                if (math == "*") {
                    kq = fthamso1 * fthamso2;
                }
                if (math == "/") {
                    kq = fthamso1 / fthamso2;
                }
                if (math == "=") {
                    kq = fthamso1;
                }
                etGiatri.setText(String.valueOf(kq));
                fthamso1 = 0.0f;
                fthamso2 = 0.0f;
                sxuat = "0";

                break;
            case R.id.btnDel:
                etGiatri.setText("");
                break;

            default:
                if (sxuat.equals("0")) {
                    sxuat = "";
                }
//                fthamso1 = Float.parseFloat(etGiatri.getText().toString());
                sxuat += ((Button) v).getText().toString();
                etGiatri.setText(sxuat);

        }

    }

    public void TOperation() {
        fthamso1 = Float.parseFloat(etGiatri.getText().toString());
        sxuat = "0";
        etGiatri.setText(sxuat);
    }
}
