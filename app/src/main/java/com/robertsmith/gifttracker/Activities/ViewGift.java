package com.robertsmith.gifttracker.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.robertsmith.gifttracker.Data_Sources.Gift;
import com.robertsmith.gifttracker.Data_Sources.Person;
import com.robertsmith.gifttracker.R;
import com.squareup.picasso.Picasso;

public class ViewGift extends Activity
{

    private ImageView imageView;
    private TextView nameTV;
    private TextView priceTV;
    private TextView storeTV;
    private CheckBox checkBox;
    public Gift mGift;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gift);

        imageView = (ImageView) findViewById(R.id.picIV);
        nameTV = (TextView) findViewById(R.id.nameTV);
        priceTV = (TextView) findViewById(R.id.priceTV);
        storeTV = (TextView) findViewById(R.id.storeTV);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        Intent i = getIntent();
        if (i != null)
        {
            mGift = (Gift)i.getSerializableExtra("GIFT");
        }

        Picasso.with(this).load(mGift.getGiftPic()).into(imageView);
        nameTV.setText(mGift.getGiftName());
        priceTV.setText(mGift.getGiftPrice());
        storeTV.setText(mGift.getGiftStore());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_gift, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}