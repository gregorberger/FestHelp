package com.example.gregor.festhelp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    ImageButton show_t;
    ImageButton techno_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        myDb =new DatabaseHelper(this);
        show_t =(ImageButton) findViewById(R.id.show_t);
        show_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor neki=myDb.getAllDataGlavni();
                viewAll(neki);
            }
        });
        techno_b =(ImageButton) findViewById(R.id.techno_b);
        techno_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor neki=myDb.getAllDataTechno();
                viewAll(neki);
            }
        });
    }
    public void viewAll(Cursor res)
    {

                if(res.getCount()==0)
                {
                    showMessage("Error","Ni podatkov");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Ime: "+ res.getString(2)+"\n");
                    buffer.append("Cas: "+ res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());
    }


    public void showMessage(String title,String Message) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
