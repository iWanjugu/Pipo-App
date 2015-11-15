package com.miniprojects.pipo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.FirebaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.miniprojects.pipo.R.layout.inner_card_layout;

public class PeopleDetails2 extends AppCompatActivity {

    private List<PeopleData> data_set;
    private RecyclerView rv;
    PeopleDataObject object;
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_details);

        //FIREBASE
        Firebase.setAndroidContext(this);

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

//        myFirebaseRef = new Firebase(getString(R.string.firebase_url));
        getData("https://pipo.firebaseio.com");
        initializeAdapter();

    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(data_set);
        rv.setAdapter(adapter);
    }

    private void getData(String url) {

        data_set = new ArrayList<>();
        myFirebaseRef = new Firebase(url);
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot data : snapshot.getChildren()) {
                    object = data.getValue(PeopleDataObject.class);

                    data_set.add(new PeopleData(
                            object.getId(),
                            object.getFirstName(),
                            object.getLastName(),
                            object.getEmail(),
                            object.getCountry(),
                            object.getCompanyName(),
                            object.getCreditCard()
                    ));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}

