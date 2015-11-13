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

import static com.miniprojects.pipo.R.layout.inner_card_layout;

public class PeopleDetails extends AppCompatActivity {

    Firebase myFirebaseRef;
    ListView peopleListView;
    FirebaseListAdapter mAdapter;
    FirebaseRecyclerViewAdapter recAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_details);

        //FIREBASE

        // populate view method
        peopleListView = (ListView) findViewById(R.id.people_list);
        Firebase.setAndroidContext(this);

        myFirebaseRef = new Firebase(getString(R.string.firebase_url));

        mAdapter = new FirebaseListAdapter<PeopleData>(this, PeopleData.class,
                inner_card_layout, myFirebaseRef) {
            @Override
            protected void populateView(View view, PeopleData peopleData) {
                ((TextView)view.findViewById(R.id.company_name)).setText(peopleData.getCompanyName());
                ((TextView)view.findViewById(R.id.country)).setText(peopleData.getCountry());
                ((TextView)view.findViewById(R.id.credit_card)).setText(peopleData.getCreditCard());
                ((TextView)view.findViewById(R.id.email)).setText(peopleData.getEmail());
                ((TextView)view.findViewById(R.id.first_name)).setText(peopleData.getFirstName());
                ((TextView)view.findViewById(R.id.person_id)).setText(peopleData.getId());
                ((TextView)view.findViewById(R.id.last_name)).setText(peopleData.getLastName());
            }
        };
        peopleListView.setAdapter(mAdapter);

        // Recycler Adapter

        RecyclerView recycler = (RecyclerView) findViewById(R.id.people_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recAdapter = new FirebaseRecyclerViewAdapter<PeopleData, PeopleDataViewHolder>
                (PeopleData.class, inner_card_layout, PeopleDataViewHolder.class, myFirebaseRef) {

            @Override
            public void populateViewHolder(PeopleDataViewHolder peopleDataViewHolder,
                                           PeopleData peopleData) {

                peopleDataViewHolder.idText.setText(peopleData.getId());
                peopleDataViewHolder.first_nameText.setText(peopleData.getFirstName());
                peopleDataViewHolder.last_nameText.setText(peopleData.getLastName());
                peopleDataViewHolder.emailText.setText(peopleData.getEmail());
                peopleDataViewHolder.countryText.setText(peopleData.getCountry());
                peopleDataViewHolder.company_nameText.setText(peopleData.getCompanyName());
                peopleDataViewHolder.credit_cardText.setText(peopleData.getCreditCard());
            }
        };

        recycler.setAdapter(recAdapter);


//        // EventListener Method
//        new Firebase(getString(R.string.firebase_url))
//                .addChildEventListener(new ChildEventListener() {
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        mAdapter.add((String)dataSnapshot.child("first_name").getValue());
//                        mAdapter.add((String)dataSnapshot.child("last_name").getValue());
//                        mAdapter.add((String) dataSnapshot.child("email").getValue());
//                        mAdapter.add((String) dataSnapshot.child("country").getValue());
//                        mAdapter.remove((String) dataSnapshot.child("company_name").getValue());
//                    }
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//                        mAdapter.add((String)dataSnapshot.child("first_name").getValue());
//                        mAdapter.add((String)dataSnapshot.child("last_name").getValue());
//                        mAdapter.add((String) dataSnapshot.child("email").getValue());
//                        mAdapter.add((String) dataSnapshot.child("country").getValue());
//                        mAdapter.remove((String) dataSnapshot.child("company_name").getValue());
//                    }
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
//                    public void onCancelled(FirebaseError firebaseError) { }
//                });

//        //reading first 5 lines data
//        //setting event listener to retrieve data
//        myFirebaseRef.limitToLast(5).addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    PeopleData data = dataSnapshot.getValue(PeopleData.class);
//                    Log.i("Names", data.getFirstName() + ": " + data.getLastName());
//                }
//            }
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Log.e("Chat", "The read failed: " + firebaseError.getMessage());
//            }
//        });

        //FAB
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//
//                    }

                    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

