package ro.mirodone.muliplechoicedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;

    CharSequence[] items = {"USA", "Germany", "Italy", "Spain"};

    boolean[] selectedItems = {false, false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn_1);
        mTextView = findViewById(R.id.tv_text);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setCancelable(true);
                alertDialog.setTitle("Select country/s");
                alertDialog.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        selectedItems[i] = isChecked;
                    }
                });
                alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mTextView.setText(itemToString());

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialogShow = alertDialog.create();
                alertDialogShow.setCanceledOnTouchOutside(true);
                alertDialogShow.show();
            }
        });
    }

    private String itemToString() {

        String text ="";

        for( int i=0; i<selectedItems.length; i++){
            if( selectedItems[i]){
                text =text+ items[i] +" ";
            }
        }
        return text.trim();
    }
}
