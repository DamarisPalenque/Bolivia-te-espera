package damaris.example.com.proyectofinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ARNOLD on 15/07/2015.
 */
public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] ciudad;
    private final String[] provincia;
    private final String[] descripcion;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] ciudad, String[] provincia, String[] descripcion, Integer[] imageId) {
        super(context, R.layout.list_single, ciudad);
        this.context = context;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.imageId = imageId;

    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtCiudad = (TextView) rowView.findViewById(R.id.ciudad);
        TextView txtProvincia = (TextView) rowView.findViewById(R.id.provincia);
        TextView txtDescripcion = (TextView) rowView.findViewById(R.id.descripcion);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imagen);

        txtCiudad.setText(ciudad[position]);
        txtProvincia.setText(provincia[position]);
        txtDescripcion.setText(descripcion[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
