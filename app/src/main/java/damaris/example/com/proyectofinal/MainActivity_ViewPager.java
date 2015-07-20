package damaris.example.com.proyectofinal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARNOLD on 15/07/2015.
 */
public class MainActivity_ViewPager extends Activity {


    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    //ViewPagerAdapter adapter;
    private List<City> cityList = null;

    ViewPager viewPager;
    PagerAdapter adapter;
     private String provincia;
    int[] salar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        salar = new int[] {R.drawable.salar1, R.drawable.salardeuyuni};


        Intent intent = getIntent();
        //ciudad = intent.getStringExtra("Ciudad");
        provincia = intent.getStringExtra("province");
        Log.d("PROVINCIA",provincia );

        new  RemoteDataTask().execute();
    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity_ViewPager.this);
            mProgressDialog.setTitle("Loading Imagens");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            cityList = new ArrayList<City>();
            try {



            // create a relation based on the authors key
                //ParseRelation relation = cities.getRelation("Images");

            // generate a query based on that relation
                //ParseQuery query = relation.getQuery();

                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Images");
                query.whereEqualTo("province", provincia);
                ob = query.find();
                for (ParseObject country : ob) {

                    ParseFile image = (ParseFile) country.get("image");

                    City city = new City();
                    city.setTitle((String)provincia);
                    city.setName((String) country.get("name"));
                    city.setDescription((String) country.get("description"));
                    city.setPhoto(image.getUrl());
                    cityList.add(city);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, cityList);
            viewPager.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }

}
