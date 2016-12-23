package com.weidu.salebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class bookdetail1Fragment extends Fragment {
    public static String author = "author";
    public static String description = "description";
    public static String price = "price";
    public static String opinion1 = "opinion";
    public static String id = "id";
    public bookdetail1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookdetail1, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView author10 = (TextView)getActivity().findViewById(R.id.author10);
        TextView description10 = (TextView)getActivity().findViewById(R.id.description10);
        TextView price10 = (TextView)getActivity().findViewById(R.id.price10);
        Button back = (Button)getActivity().findViewById(R.id.button11);
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            String author1 = bundle.getString(author);
            String description1 = bundle.getString(description);
            String price1 = bundle.getString(price);
            author10.setText(!TextUtils.isEmpty(author1)?author1:"Unknown");
            description10.setText(!TextUtils.isEmpty(description1)?description1:"Unknown");
            price10.setText(!TextUtils.isEmpty(price1)?price1:"Unknown");
        }
        Button like = (Button)getActivity().findViewById(R.id.button10);
        Button dislike = (Button)getActivity().findViewById(R.id.button12);
        like.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data0 = new Intent();
                data0.putExtra(id,"1");
                data0.putExtra(opinion1,true);
                getActivity().setResult(Activity.RESULT_OK, data0);
                getActivity().finish();
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data1 = new Intent();
                data1.putExtra(id,"1");
                data1.putExtra(opinion1,false);
                getActivity().setResult(Activity.RESULT_OK,data1);
                getActivity().finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent data = new Intent();
                getActivity().setResult(Activity.RESULT_OK,data);
                getActivity().finish();
            }
        });
    }
}
