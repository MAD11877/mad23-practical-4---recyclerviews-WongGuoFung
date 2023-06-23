package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userlist = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            User user1 = createUser();
            userlist.add(user1);
            Log.i(Title, "1");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        Adapter mAdapter = new Adapter(ListActivity.this,userlist);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
    private User createUser(){
        User randomUser = new User();
        int ran1 = randomOTP();
        int ran2 = randomOTP();
        randomUser.name = "Name" + ran1;
        randomUser.followed = false;
        randomUser.description = "Description " + ran2;
        return randomUser;
    }
    private static final String Title = "ListActivity";
}