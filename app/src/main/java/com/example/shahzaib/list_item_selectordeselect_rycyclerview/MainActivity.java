package com.example.shahzaib.list_item_selectordeselect_rycyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnRecyclerViewItemClickListener {


    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<String> itemTitles = new ArrayList<>();
    ActionMode actionMode;
    int selectedItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Select Items");
        recyclerView = findViewById(R.id.recyclerView);
        selectedItemCount = 0;

        addingTitles_In_ItemTitlesList();
        recyclerViewAdapter = new RecyclerViewAdapter(itemTitles,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        recyclerView.setAdapter(recyclerViewAdapter);

        /****** Adding divider between items in recyclerView list*/
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);







    }






    public void addingTitles_In_ItemTitlesList()
    {
        itemTitles.add("item 1");
        itemTitles.add("item 2");
        itemTitles.add("item 3");
        itemTitles.add("item 4");
        itemTitles.add("item 5");
        itemTitles.add("item 6");
        itemTitles.add("item 7");
        itemTitles.add("item 8");
        itemTitles.add("item 9");
        itemTitles.add("item 10");
        itemTitles.add("item 11");
        itemTitles.add("item 12");
        itemTitles.add("item 13");
        itemTitles.add("item 14");
        itemTitles.add("item 15");
        itemTitles.add("item 16");
        itemTitles.add("item 17");
        itemTitles.add("item 18");
        itemTitles.add("item 19");
        itemTitles.add("item 20");
        itemTitles.add("item 21");
        itemTitles.add("item 22");
        itemTitles.add("item 23");
        itemTitles.add("item 24");
        itemTitles.add("item 25");
    }


    // when user click the item in RecyclerView list then our created adapter will invoke the following function and pass postion in it
    @Override
    public void selectedItemCount(int count) {
        selectedItemCount = count;
        createActionModeToolbar();
        increamentTextOnActionModeToolbar();

    }


    public void createActionModeToolbar()
    {
        if(actionMode == null)
        {
            actionMode = startSupportActionMode(callback);
        }
        if(selectedItemCount==0)
        {
            actionMode.finish();
        }

    }

    public void increamentTextOnActionModeToolbar()
    {
        if(actionMode != null)
        {
            actionMode.setTitle(""+selectedItemCount);
        }

    }





    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            mode.getMenuInflater().inflate(R.menu.action_mood_toolbar_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };



}
