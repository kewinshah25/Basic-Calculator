package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> img_lv = new ArrayList<>();
    ArrayList<String> head_lv = new ArrayList<>();
    ArrayList<String> url_lv = new ArrayList<>();
    ArrayList<String> info_lv = new ArrayList<>();

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        img_lv.add(R.mipmap.dota2);
        img_lv.add(R.mipmap.gta);
        img_lv.add(R.mipmap.pubg);
        img_lv.add(R.mipmap.overwatch);
        img_lv.add(R.mipmap.fifa);
        img_lv.add(R.mipmap.tekken);
        img_lv.add(R.mipmap.nfs);

        head_lv.add("DOTA 2");
        head_lv.add("GTA V");
        head_lv.add("PUBG");
        head_lv.add("Overwatch");
        head_lv.add("FIFA 20");
        head_lv.add("Tekken 7");
        head_lv.add("NFS");

        info_lv.add("Strategic Game");
        info_lv.add("Action Game");
        info_lv.add("Battle Royale Game");
        info_lv.add("FPS Game");
        info_lv.add("Sports Game");
        info_lv.add("Sports Game");
        info_lv.add("Racing Game");

        url_lv.add("https://en.wikipedia.org/wiki/Dota_2");
        url_lv.add("https://en.wikipedia.org/wiki/Grand_Theft_Auto_V");
        url_lv.add("https://en.wikipedia.org/wiki/PlayerUnknown%27s_Battlegrounds");
        url_lv.add("https://en.wikipedia.org/wiki/Overwatch_(video_game)");
        url_lv.add("https://en.wikipedia.org/wiki/FIFA_20");
        url_lv.add("https://en.wikipedia.org/wiki/Tekken_7");
        url_lv.add("https://en.wikipedia.org/wiki/Need_for_Speed");

        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(new CustomAdapter());


    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return head_lv.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlistview,parent,false);
            ImageView imgv = view.findViewById(R.id.game_image);
            Glide.with(context).load(img_lv.get(position)).into(imgv);
            TextView textv = view.findViewById(R.id.game_text);
            TextView infoView = view.findViewById(R.id.info);
            textv.setText(head_lv.get(position));
            infoView.setText(info_lv.get(position));

            LinearLayout linearLayout = view.findViewById(R.id.custom_linear);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,Wiki.class);
                    i.putExtra("url",url_lv.get(position));
                    startActivity(i);
                }
            });
            return view;
        }
    }
}
