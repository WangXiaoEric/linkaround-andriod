package com.besttmt.linkaround.ui.fragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.besttmt.linkaround.R;

import com.microsoft.maps.MapRenderMode;
import com.microsoft.maps.MapView;


public class CovidFragment extends Fragment {

    private MapView mMapView;

    public CovidFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_covid, container, false);

        mMapView = new MapView(getActivity().getApplicationContext(), MapRenderMode.VECTOR);  // or use MapRenderMode.RASTER for 2D map
        mMapView.setCredentialsKey("Aptr6xbyc2DnDV_hBIrJqHbpGXl2VlI7Dkkt3zYpLYdDYZo_1zwPg8xzO4RNHDPp");
        ((FrameLayout)view.findViewById(R.id.map_view)).addView(mMapView);
        mMapView.onCreate(savedInstanceState);

        return view;
    }
}