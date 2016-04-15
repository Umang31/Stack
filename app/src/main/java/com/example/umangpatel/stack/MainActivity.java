package com.example.umangpatel.stack;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    public EditText text;
    int top = -1;
    //int[] a = new int[3];
    String a[] = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.input_number);
        button1 = (Button) findViewById(R.id.button_push);
        button2 = (Button) findViewById(R.id.button_pop);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String push;
                push = text.getText().toString();
                if(text.getText().toString().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(),"Please enter a value",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    int value = Integer.parseInt(push);

                    pushOperation(value);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popOperation();
            }
        });

        Button button_exit = (Button) findViewById(R.id.button_exit);

        button_exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openAlert(v);
            }
        });



    }

    private void openAlert(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Exit StackApp?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                MainActivity.this.finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.cancel();
                Toast.makeText(getApplicationContext(), "You chose no",
                        Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void pushOperation(int value){
        if(top == 2){
            Toast toast = Toast.makeText(getApplicationContext(),"Stack is full",Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(value>=10){
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter correct integer value",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            top = top + 1;
            a[top] = "" +value;
            Toast toast = Toast.makeText(getApplicationContext(), value + " is pushed", Toast.LENGTH_SHORT);
            toast.show();
            text.setText("");
        }
        TextView displayMessageView = (TextView) findViewById(R.id.result_text_view);
        String str = "";
        for(int i=0; i<=top; i++){
            str = str+ " "+a[i];
        }
        displayMessageView.setText("[" + str + " ]");
    }
    public void popOperation(){
        if(top == -1){
            Toast toast = Toast.makeText(getApplicationContext(),"Stack is empty",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),a[top] + " is popped",Toast.LENGTH_SHORT);
            toast.show();

            a[top] = " ";
            top = top -1;

        }
        TextView displayMessageView = (TextView) findViewById(R.id.result_text_view);
        String str = " ";
        for (int i = 0; i <= top; i++) {

            str = str +" " +a[i];
        }
        displayMessageView.setText("[" + str + " ]");

    }
}
