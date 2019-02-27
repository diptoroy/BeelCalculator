package com.example.beelcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText entervalueEditText,vatEditText,aitEditText;
    private TextView vatText,afterVatText,aitText,afterAitText,netIncomeText;
    private Button resultButton,refreshButton;
    private double pamount,amount,pvat,vat,pait,ait,aftervat,afterait;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logic();



    }



    public void math(){

        pamount = Double.parseDouble(entervalueEditText.getText().toString());
        pvat = Double.parseDouble(vatEditText.getText().toString());
        pait = Double.parseDouble(aitEditText.getText().toString());
        vat = (pvat * pamount)/100;
        aftervat = (pamount - vat);
        ait = (pait * pamount)/100;
        afterait = (pamount - ait);
        amount =pamount - (vat + ait);

    }

    public void logic(){
        entervalueEditText = findViewById(R.id.enteramount);
        vatEditText = findViewById(R.id.vatedittext);
        aitEditText = findViewById(R.id.aitedittext);
        vatText = findViewById(R.id.vat);
        afterVatText = findViewById(R.id.aftervat);
        aitText = findViewById(R.id.ait);
        afterAitText = findViewById(R.id.afterait);
        netIncomeText = findViewById(R.id.netincome);
        resultButton = findViewById(R.id.resultbutton);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               try {
                   if (!entervalueEditText.getText().toString().equals("") && !vatEditText.getText().toString().equals("") && !aitEditText.getText().toString().equals("")){
                       math();
                       vatText.setText(String.format("%.2f",vat));


                       afterVatText.setText(String.format("%.2f",aftervat));


                       aitText.setText(String.format("%.2f",ait));


                       afterAitText.setText(String.format("%.2f",afterait));


                       netIncomeText.setText(String.format("%.2f",amount));
                   }

                   else{
                       try {
                           if (entervalueEditText.getText().toString().equals("")){
                               entervalueEditText.setText("Error");
                           }else if(vatEditText.getText().toString().equals("")){
                               vatEditText.setText("Error");
                           }else if (aitEditText.getText().toString().equals("")){
                               aitEditText.setText("Error");
                           }

                       }catch (Exception e){

                           Toast.makeText(getApplicationContext(),"PLease enter the value",Toast.LENGTH_LONG).show();
                       }

                   }
               }catch (Exception e){

               }




            }
        });

        refreshButton = findViewById(R.id.refreshbutton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entervalueEditText.setText("");
                vatEditText.setText("");
                aitEditText.setText("");
                vatText.setText("VAT : ");
                aitText.setText("AIT : ");
                afterVatText.setText("After VAT : ");
                afterAitText.setText("After AIT : ");
                netIncomeText.setText("NET INCOME : ");
            }
        });
    }


}
