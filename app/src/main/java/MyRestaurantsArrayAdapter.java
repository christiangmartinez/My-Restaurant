import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRestaurantsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }
}
