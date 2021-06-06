package com.besttmt.linkaround.ui.fragement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.besttmt.linkaround.R;

import java.util.ArrayList;

public class RecommendFragment extends Fragment {

    ListView scanListView;

    ArrayList<String> stringList = new ArrayList<String>();

    ArrayAdapter<String> arrayAdapter;


    public RecommendFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_recommend, container, false);

        scanListView = view.findViewById(R.id.scanListViewrecommend);
        //封裝ListView數據；
        arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, stringList);
        scanListView.setAdapter(arrayAdapter);
        stringList.clear();
        stringList.add("LiHao:他與你都修了物聯網課" );
        stringList.add("Mike: 他與你都喜歡編程");
        stringList.add("Bob:  他與你都是資工系就讀");
        stringList.add("Lina:  你們曾在同一時間段在操場");
        stringList.add("Sophia:  你們都喜歡看電影");
        stringList.add("Lynn: 你們曾在清大校門口擦肩而過");
        arrayAdapter.notifyDataSetChanged();

        return view;
    }
}