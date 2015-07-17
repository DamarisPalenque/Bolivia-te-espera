package damaris.example.com.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ARNOLD on 15/07/2015.
 */
public class MainActivity_ListView extends Activity {

    ListView list;
    String[] Ciudades = {
            "Potosi",
            "La Paz",
            "La Paz",
            "Santa Cruz",
            "Potosi",
            "Chuquisaca",
            "Santa Cruz",
            "La Paz",
            "La Paz"
    } ;

    String[] Provincias = {
            "Salar de Uyuni",
            "Parque Nacional Madidi",
            "Lago Titikaka",
            "Misiones Jesuiticas",
            "Ciudad de Potosi",
            "Ciudad de Sucre",
            "Biocentro Guembe",
            "Tiwanaku",
            "Ciudad de La Paz"
    };
    Integer[] imageId = {
            R.drawable.salar1,
            R.drawable.madidi,
            R.drawable.titikaka,
            R.drawable.misiones,
            R.drawable.potosi,
            R.drawable.sucre,
            R.drawable.biocentro,
            R.drawable.tiwanaku,
            R.drawable.lapaz

    };

    String[] descripcion = {
            "Ubicado al suroeste de Bolivia, El Salar de Uyuni es el mas grande del mundo. Esta region semidesertica y de tierras volcanicas encierra en su interior recursos de gran importancia economica como la reserva de 9 millones de toneladas de litio y otros minerales; y paisajes de extraordinaria belleza natural. El Salar y las Lagunas Colorada, Verde, Amarilla y Celeste son sus mejor exponentes y sus nombres se atribuyen a las distintas tonalidades de colores que ostentan.",
            "El Parque Nacional y Area Natural de Manejo Integrado Madidi es un destino de incomparable belleza natural donde 3,235 especies conviven en perfecta armonia con el ser humano. Es sin duda, el area protegida de mayor relevancia ecologica y biogeografica de Bolivia, y una de las mas importantes del planeta por la alta biodiversidad y variedad de ecosistemas que presenta.",
            "El lago Titikaka comienza a 70 kilometros al oeste de la ciudad de La Paz, el cual es alimentado por los glaciares de Apolobamba y las Cordilleras de La Paz, constituyendose en la superficie navegable mas alta del mundo. Se divide en dos cuencas: El Lago Mayor y el Lago Menor.",
            "San Javier, fundada en 1691, se constituye en la primera mision jesuitica instalada en Chiquitos. Al estilo barroco, su iglesia fue construida entre 1749 y 1752, posteriormente restaurada entre 1987 y 1993. Esta hermosa construcción nos invita a recorrerla, disfrutando de su arquitectura con tallados ornamentales de columnas y dibujos en madera con vistosos tonos amarillo y cafe. Actualmente esta construcción es un Monumento Nacional y Patrimonio Histórico de la Humanidad.",
            "Situada a los pies del Cerro Rico (Sumaj Orcko) a mas de 4,000 m.s.n.m., su historia esta estrechamente ligada a la plata. En 1650, Potosi era la ciudad mas poblada del mundo con unos 160,000 habitantes; mas que Londres, Paris o Madrid, dada la generosidad del imponente Cerro Rico de Potosí que albergó en su interior las más codiciadas vetas de plata del mundo, con cuya produccion se podria haber construido un puente entre Potosí y Madrid.",
            "Sucre, Capital del Departamento de Chuquisaca, es tambien la capital constitucional del Estado Plurinacional de Bolivia; ubicada al sur del pais, posee un clima agradable del que se goza todo el año.",
            "Biocentro Guembe le brinda nada menos que 24 hectareas, rodeado de plantas exoticas, bosques exuberantes y animales propios de la región. Es un lugar en plena armonía entre el hombre y la naturaleza, en el que encontrará una variedad de flora y fauna en su hábitat natural.",
            "Este sitio arqueológico está entre los mas antiguos de las culturas andinas y sus restos sorprenden por su monumentalidad, por la perfección de la técnica constructiva y decorativa. Dentro de su entorno se encuentra una planicie altiplanica entre dos serranias, algunos campos de cultivo y comunidades nativas.",
            "La Paz, sede de gobierno y capital político-administrativa de Bolivia, es la ciudad más indígena y a la vez la más cosmopolita del país. Confluyen en ella gente de todas las regiones, así como inmigrantes de otros lugares del mundo, siendo que existen diversas concepciones culturales y expresiones étnicas que le imprimen la singular fisonomía que la distingue."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        CustomList adapter = new CustomList(MainActivity_ListView.this, Ciudades, Provincias, descripcion, imageId);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity_ListView.this, Ciudades[+position]+ " "+Provincias[+position], Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(MainActivity_ListView.this, MainActivity_ViewPager.class);
                intent.putExtra("Ciudad",(Ciudades[position]));
                intent.putExtra("Provincias", (Provincias[position]));
                intent.putExtra("Imagen", (imageId[position]));
                intent.putExtra("Descripcion",(descripcion[position]));

                startActivity(intent);

            }
        });

    }
    //http://www.androidbegin.com/tutorial/android-viewpager-gallery-images-and-texts-tutorial/
    //http://www.learn2crack.com/2013/10/android-custom-listview-images-text-example.html
}
