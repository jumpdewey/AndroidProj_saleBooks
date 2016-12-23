package com.weidu.salebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class UsedBooksFragment extends Fragment {
    static final int Request = 1;
    ImageView good0;
    ImageView bad0;
    ImageView good1;
    ImageView bad1;
    ImageView good2;
    ImageView bad2;
    public static String ID = "id";
    public UsedBooksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_used_books, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ImageView image0 = (ImageView)getActivity().findViewById(R.id.image0);
        ImageView image1 = (ImageView)getActivity().findViewById(R.id.image1);
        ImageView image2 = (ImageView)getActivity().findViewById(R.id.image2);
        good0 = (ImageView)getActivity().findViewById(R.id.good0);
        good0.setVisibility(View.INVISIBLE);
        bad0 = (ImageView)getActivity().findViewById(R.id.bad0);
        bad0.setVisibility(View.INVISIBLE);
        good1 = (ImageView)getActivity().findViewById(R.id.good1);
        good1.setVisibility(View.INVISIBLE);
        bad1 = (ImageView)getActivity().findViewById(R.id.bad1);
        bad1.setVisibility(View.INVISIBLE);
        good2 = (ImageView)getActivity().findViewById(R.id.good2);
        good2.setVisibility(View.INVISIBLE);
        bad2 = (ImageView)getActivity().findViewById(R.id.bad2);
        bad2.setVisibility(View.INVISIBLE);
        image0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDetails(0);
            }
        });
        image1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showDetails(1);
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showDetails(2);
            }
        });
    }
    public void showDetails(int i){
        Intent myintent = null;
        if(i==0){
            myintent = new Intent(getActivity(),bookdetail0.class);
            myintent.putExtra(bookdetail0Fragment.author,"Leo Tolstoy");
            myintent.putExtra(bookdetail0Fragment.description,"Tolstoy himself said that War and Peace was \"not a novel, even less is it a poem, and still less a historical chronicle\". ");
            myintent.putExtra(bookdetail0Fragment.price, "$20");
        }
        if(i==1){
            myintent = new Intent(getActivity(),bookdetail1.class);
            myintent.putExtra(bookdetail1Fragment.author,"Stendhal");
            myintent.putExtra(bookdetail1Fragment.description,"It chronicles the attempts of a provincial young man to rise socially beyond his modest upbringing through a combination of talent, hard work, deception, and hypocrisy. He ultimately allows his passions to betray him.");
            myintent.putExtra(bookdetail1Fragment.price,"$25");
        }
        if(i==2){
            myintent = new Intent(getActivity(),bookdetail2.class);
            myintent.putExtra(bookdetail2Fragment.author,"Hemingway");
            myintent.putExtra(bookdetail2Fragment.description,"The book, published in 1929, is a first-person account of American Frederic Henry, serving as a Lieutenant (\"Tenente\") in the ambulance corps of the Italian Army. The title is taken from a poem by 16th-century English dramatist George Peele.");
            myintent.putExtra(bookdetail2Fragment.price,"$27");
        }
        startActivityForResult(myintent, Request);
    }

    @Override
    public void onActivityResult(int RequestCode,int ResultCode, Intent data) {
        boolean like = false;

        Bundle bundle = data.getExtras();
        if (data.hasExtra(ID)) {
            String id = bundle.getString(ID);
            if (RequestCode == Request) {
                if (ResultCode == Activity.RESULT_OK) {
                    if (!TextUtils.isEmpty(id)) {
                        if (id.equals("0")) {
                            like = bundle.getBoolean(bookdetail0Fragment.opinion0);
                            if (like) {
                                good0.setVisibility(View.VISIBLE);
                                bad0.setVisibility(View.INVISIBLE);
                            } else {
                                bad0.setVisibility(View.VISIBLE);
                                good0.setVisibility(View.INVISIBLE);
                            }
                        }
                        if (id.equals("1")) {
                            like = data.getBooleanExtra(bookdetail1Fragment.opinion1, false);
                            if (like) {
                                good1.setVisibility(View.VISIBLE);
                                bad1.setVisibility(View.INVISIBLE);
                            } else {
                                bad1.setVisibility(View.VISIBLE);
                                good1.setVisibility(View.INVISIBLE);
                            }
                        }
                        if (id.equals("2")) {
                            like = data.getBooleanExtra(bookdetail2Fragment.opinion2, false);
                            if (like) {
                                good2.setVisibility(View.VISIBLE);
                                bad2.setVisibility(View.INVISIBLE);
                            } else {
                                bad2.setVisibility(View.VISIBLE);
                                good2.setVisibility(View.INVISIBLE);
                            }

                        }
                    }
                }
            }
        }
        }


    }

