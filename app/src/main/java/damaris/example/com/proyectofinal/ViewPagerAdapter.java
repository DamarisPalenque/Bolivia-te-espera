package damaris.example.com.proyectofinal;

/**
 * Created by ARNOLD on 15/07/2015.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter{

    String ciudad;
    String provincia;
    String descripcion;
    int [] foto;
    Context context;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String ciudad, String provincia, String descripcion, int[] foto){
        this.context = context;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.foto = foto;
    }
    @Override
    public int getCount() {
        return foto.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == ((ScrollView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtCiudad;
        TextView txtProvinvia;
        TextView txtDescripcion;
        ImageView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtCiudad = (TextView) itemView.findViewById(R.id.txtciudad);
        txtProvinvia = (TextView) itemView.findViewById(R.id.txtprovincia);
        txtDescripcion = (TextView) itemView.findViewById(R.id.txtdescripcion);

        // Capture position and set to the TextViews
        txtCiudad.setText(ciudad);
        txtProvinvia.setText(provincia);
        txtDescripcion.setText(descripcion);

        // Locate the ImageView in viewpager_item.xml
        imgflag = (ImageView) itemView.findViewById(R.id.image);
        // Capture position and set to the ImageView
        imgflag.setImageResource(foto[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((ScrollView) object);

    }
}
