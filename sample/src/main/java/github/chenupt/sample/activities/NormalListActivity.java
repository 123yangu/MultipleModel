package github.chenupt.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import github.chenupt.sample.CommonService;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description : Normal activity with a list.
 */
public class NormalListActivity extends ActionBarActivity {

    private ListView listView;
    private CommonService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_view);


    }
}
