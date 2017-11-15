package com.dpaulb.paul.ribbonandyoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dpaulb.paul.ribbonandyoutube.Adapter.CustomAdapter;
import com.dpaulb.paul.ribbonandyoutube.Handler.RecyclerItemClickListener;
import com.dpaulb.paul.ribbonandyoutube.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    List<Item> items;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        initItem();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(getApplicationContext(),position+"번 째 아이템 클릭",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, YoutubeVideoActivity.class);
                intent.putExtra("videoID", getResources().getStringArray(R.array.videoID));
                intent.putExtra("pos", position + "");
                MainActivity.this.startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),position+"번 째 아이템 롱 클릭",Toast.LENGTH_SHORT).show();

            }
        }));

    }

    private void initItem() {

        items = new ArrayList<>();

        items.add(new Item(0, "Music", "MELVINS / Boston, MA / 8.2.17 / The Paradise", "https://i.ytimg.com/vi/XQb6Jl9H6Zs/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLB41Vp-KTLw3u4rFE8YLBxnLGD2Rw"));
        items.add(new Item(2, "Movie", "세상의 모든 몬스터들이 한자리에 모인다면?", "https://i.ytimg.com/vi/dGx4Qv4Aecc/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLAkc9Y9TyCcX_5p-jXKOluwdx6iog"));
        items.add(new Item(0, "Music", "Muse - Live at Earls Court 2004 [Full Performance]", "https://i.ytimg.com/vi/paz48hGEgdM/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLAKiiIcBSmmAIR1f-4kTqQy8FEjUw"));
        items.add(new Item(2, "Movie", "Everything Wrong With Kingsman: The Secret Service -Deja Vu", "https://i.ytimg.com/vi/gdOuglUpVrk/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLB0dnPXe5b6rsWJoaALyMB5OgRC_A"));


        adapter = new CustomAdapter(this, items);
        recyclerView.setAdapter(adapter);


    }
}
