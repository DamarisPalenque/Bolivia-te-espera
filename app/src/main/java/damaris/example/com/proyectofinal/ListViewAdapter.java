package damaris.example.com.proyectofinal;

/**
 * Created by ARNOLD on 18/07/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<City> cityList = null;
    private ArrayList<City> arraylist;

    public ListViewAdapter(Context context, List<City> cityList) {
        this.context = context;
        this.cityList = cityList;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<City>();
        this.arraylist.addAll(cityList);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder {
        TextView city;
        TextView province;
        TextView description;
        ImageView image;
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public Object getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_single, null);

            holder.city = (TextView) view.findViewById(R.id.ciudad);
            holder.province = (TextView) view.findViewById(R.id.provincia);
            //holder.description = (TextView) view.findViewById(R.id.descripcion);

            holder.image = (ImageView) view.findViewById(R.id.imagen);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.city.setText(cityList.get(position).getCity());
        holder.province.setText(cityList.get(position).getProvince());
        //holder.description.setText(cityList.get(position).getDescription());
        imageLoader.DisplayImage(cityList.get(position).getPhoto(),holder.image);


        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity_ViewPager .class);

                intent.putExtra("city",(cityList.get(position).getCity()));

                intent.putExtra("province",(cityList.get(position).getProvince()));

                //intent.putExtra("image",(cityList.get(position).getPhoto()));

                context.startActivity(intent);
            }
        });
        return view;
    }

}
