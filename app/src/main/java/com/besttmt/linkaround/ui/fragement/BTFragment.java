package com.besttmt.linkaround.ui.fragement;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.besttmt.linkaround.MainActivity;
import com.besttmt.linkaround.R;

import java.util.ArrayList;
import java.util.Set;


public class BTFragment extends Fragment {

    Button scanButton;

    Button resetButton;

    ListView scanListView;

    ArrayList<String> stringList = new ArrayList<String>();

    ArrayAdapter<String> arrayAdapter;

    BluetoothAdapter bt;

    public BTFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b_t, container, false);

        scanButton = view.findViewById(R.id.scanbutton);
        resetButton = view.findViewById(R.id.resetbutton);
        scanListView = view.findViewById(R.id.scanListView);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt = BluetoothAdapter.getDefaultAdapter();
                Log.i("BTFragment", "doing bt.startDiscovery()");
                bt.startDiscovery();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringList.clear();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        getActivity().getApplicationContext().registerReceiver(myReceiver, intentFilter);

        //封裝ListView數據；
        arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, stringList);
        scanListView.setAdapter(arrayAdapter);


//        stringList.add("test1");
//        stringList.add("test2");
//        arrayAdapter.notifyDataSetChanged();
//        stringList.add("test3");
//        arrayAdapter.notifyDataSetChanged();



        return view;
    }

    BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Log.i("BTFragment", intent.toString());
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if(device.getName() != null && device.getName() != ""){
                    Log.i("BTFragment", device.getName());
                    if(!stringList.contains(device.getName())){
                        stringList.add(device.getName());
                    }

                }
                arrayAdapter.notifyDataSetChanged();
            }
        }
    };
}