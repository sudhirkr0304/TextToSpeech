package com.example.texttospeech;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static EditText text;
    private static Button button;
    private static int textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Talk");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darksky)));


           text = (EditText)findViewById(R.id.totaltext);
           button=(Button)findViewById(R.id.audiobutton);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();

        if(id == R.id.download_audio)
        {

        }
        else if( id == R.id.text_size)
        {
            //alert dialog

            alertdialog();


        }

        return super.onOptionsItemSelected(item);
    }

    public void alertdialog()
    {

        final Dialog dialog = new Dialog(this);
        LayoutInflater layoutInflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.custom_alert,(ViewGroup)findViewById(R.id.dialogrootelement));


        dialog.setContentView(layout);

         SeekBar seek = (SeekBar)layout.findViewById(R.id.seekbar);
        final TextView previewtext = (TextView)layout.findViewById(R.id.previewtext);
        Button applybutton = (Button)layout.findViewById(R.id.applybutton);
        Button cancelButton = (Button)layout.findViewById(R.id.cancelbutton);


       seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
           {
               previewtext.setTextSize((progress+30)/3);
               textSize =(progress+30)/3;

           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

       applybutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               text.setTextSize(textSize);
               dialog.dismiss();
           }
       });

       cancelButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });
        dialog.create();
        dialog.show();

    }



}
