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

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter{

    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<City> cityList = null;
    private ArrayList<City> arraylist;

    //String title;

    public ViewPagerAdapter(Context context, List<City> cityList){
        this.context = context;
        this.cityList = cityList;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<City>();
        this.arraylist.addAll(cityList);
        imageLoader = new ImageLoader(context);

        //this.title = title;
    }
    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == ((ScrollView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtTile;
        TextView txtName;
        TextView txtDescripcion;
        ImageView image;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,false);

        txtTile = (TextView) itemView.findViewById(R.id.txttile);
        txtName = (TextView) itemView.findViewById(R.id.txtname);
        txtDescripcion = (TextView) itemView.findViewById(R.id.txtdescripcion);

        txtTile.setText(cityList.get(position).getTitle());
        txtName.setText(cityList.get(position).getName());
        txtDescripcion.setText(cityList.get(position).getDescription());


        image = (ImageView) itemView.findViewById(R.id.image);
        imageLoader.DisplayImage(cityList.get(position).getPhoto(),image);

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
