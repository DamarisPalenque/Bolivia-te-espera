package damaris.example.com.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.util.Log;

/**
 * Created by ARNOLD on 15/07/2015.
 */
public class MainActivity_ViewPager extends Activity {

    ViewPager viewPager;
    PagerAdapter adapter;
    String Ciudad;
    String descripcion;
    String provincia;
    int[] salar; int[] madidi; int[] titikaka; int[] misiones; int[] potosi; int[] sucre; int[] biocentro; int[] tiwanaku; int[] lapaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        salar = new int[] {R.drawable.salar1, R.drawable.salardeuyuni};
        madidi = new int[] {R.drawable.madidi, R.drawable.madidi2, R.drawable.madidi3};
        titikaka = new int[] {R.drawable.titikaka, R.drawable.titikaka2, R.drawable.titikaka3};
        misiones = new int[] {R.drawable.misiones, R.drawable.misiones2, R.drawable.misiones3};
        potosi = new int[] {R.drawable.potosi, R.drawable.potosi2, R.drawable.potosi3};
        sucre = new int[] {R.drawable.sucre, R.drawable.sucre2, R.drawable.sucre3};
        biocentro = new int[] {R.drawable.biocentro, R.drawable.biocentro, R.drawable.biocentro};
        tiwanaku = new int[] {R.drawable.tiwanaku, R.drawable.tiwanaku2, R.drawable.tiwanaku3};
        lapaz = new int[] {R.drawable.lapaz, R.drawable.lapaz2, R.drawable.lapz3};

        Intent intent = getIntent();
        Ciudad = intent.getStringExtra("Ciudad");
        provincia = intent.getStringExtra("Provincias");
        descripcion = intent.getStringExtra("Descripcion");


        Log.d("PROVINCIA", provincia);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        if(provincia.equals("Salar de Uyuni")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, salar);
        }else if(provincia.equals("Parque Nacional Madidi")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, madidi);
        }else if(provincia.equals("Lago Titikaka")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, titikaka);
        }else if(provincia.equals("Misiones Jesuiticas")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, misiones);
        }else if(provincia.equals("Ciudad de Potosi")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, potosi);
        }else if(provincia.equals("Ciudad de Sucre")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, sucre);
        }else if(provincia.equals("Biocentro Guembe")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, biocentro);
        }else if(provincia.equals("Tiwanaku")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, tiwanaku);
        }else if(provincia.equals("Ciudad de La Paz")){
            adapter = new ViewPagerAdapter(MainActivity_ViewPager.this, Ciudad, provincia, descripcion, lapaz);
        }
        viewPager.setAdapter(adapter);
    }

}
