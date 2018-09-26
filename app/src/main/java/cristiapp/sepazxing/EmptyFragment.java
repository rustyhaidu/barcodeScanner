package cristiapp.sepazxing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmptyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
       return inflater.inflate(R.layout.fragment_layout_empty,container,false);
    }
}
