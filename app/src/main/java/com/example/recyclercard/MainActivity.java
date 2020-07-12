package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FloatingActionButton fabInsert;
    FloatingActionButton fabDelete;
    EditText etInsert;
    EditText etDelete;
    ImageView del;
    ArrayList<Ex_item_java> ex_items;
    RecyclerView.LayoutManager mLayoutManager;
    Example_Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();

        fabInsert=findViewById(R.id.add);
        fabDelete=findViewById(R.id.minus);
        etInsert=findViewById(R.id.etAdd);
        etDelete=findViewById(R.id.etMinus);
        del=findViewById(R.id.del);


    }

    public void createExampleList() {
        ex_items=new ArrayList<>();
        ex_items.add(new Ex_item_java(R.drawable.icon1,"IceCream","Kwality"));
        ex_items.add(new Ex_item_java(R.drawable.icon2,"Mixed Fruit Jam","Kissan"));
        ex_items.add(new Ex_item_java(R.drawable.icon3,"Faluda Mix","V V puram "));
        ex_items.add(new Ex_item_java(R.drawable.icon4,"Chocolate Muffins","Iyrngar Bakery"));
        ex_items.add(new Ex_item_java(R.drawable.icon5,"Doughnuts","Swastika"));
        ex_items.add(new Ex_item_java(R.drawable.icon1,"IceCream","Kwality"));
        ex_items.add(new Ex_item_java(R.drawable.icon2,"Mixed Fruit Jam","Kissan"));
        ex_items.add(new Ex_item_java(R.drawable.icon3,"Faluda Mix","V V puram "));
        ex_items.add(new Ex_item_java(R.drawable.icon4,"Chocolate Muffins","Iyrngar Bakery"));
        ex_items.add(new Ex_item_java(R.drawable.icon5,"Doughnuts","Swastika"));
    }
    public void buildRecyclerView() {
        mRecyclerView=findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new Example_Adapter(ex_items);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new Example_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ChangeItem(position,"Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                deleteItem(position);
            }
        });
    }

    public void ChangeItem(int position,String text)
    {
        ex_items.get(position).chageText("Clicked");
        mAdapter.notifyItemChanged(position);
    }

    public void Add(View view) {
        int position=Integer.parseInt(etInsert.getText().toString());
        insertItem(position);
    }

    private void insertItem(int position) {
//        ex_items.add(position,new Ex_item_java(R.drawable.icon3,
//                "Item at position ","BottomLine at position "));
        mAdapter.notifyItemInserted(position);
    }

    public void Minus(View view) {
        int position=Integer.parseInt(etDelete.getText().toString());
        deleteItem(position);
    }
    private void deleteItem(int position) {
        ex_items.remove(position);
        mAdapter.notifyDataSetChanged();
    }
}