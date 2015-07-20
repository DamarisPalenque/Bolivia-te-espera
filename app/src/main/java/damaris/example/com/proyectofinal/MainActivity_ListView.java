package damaris.example.com.proyectofinal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARNOLD on 15/07/2015.
 */
public class MainActivity_ListView extends Activity {


    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<City> cityList = null;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        new RemoteDataTask().execute();

    }
    //http://www.androidbegin.com/tutorial/android-viewpager-gallery-images-and-texts-tutorial/
    //http://www.learn2crack.com/2013/10/android-custom-listview-images-text-example.html

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity_ListView.this);
            mProgressDialog.setTitle("Bolivia te Espera");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            cityList = new ArrayList<City>();
            try {
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Cities");
                //query.orderByAscending("");
                ob = query.find();
                for (ParseObject bte : ob) {
                    ParseFile image = (ParseFile) bte.get("image");

                    City map = new City();
                    map.setCity((String) bte.get("city"));
                    map.setProvince((String) bte.get("province"));
                   // map.setDescription((String) country.get("population"));
                    map.setPhoto(image.getUrl());
                    cityList.add(map);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            listview = (ListView) findViewById(R.id.listview);
            adapter = new ListViewAdapter(MainActivity_ListView.this,cityList);
            listview.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
}
