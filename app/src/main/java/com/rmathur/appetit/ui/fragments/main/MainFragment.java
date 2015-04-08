package com.rmathur.appetit.ui.fragments.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.rmathur.appetit.R;

public class MainFragment extends Fragment {

    @InjectView(R.id.layoutview)
    CardContainer mCardContainer;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);

        mCardContainer = (CardContainer) view.findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Disordered);

        CardModel card = new CardModel("Title1", "Description goes here", this.getActivity().getResources().getDrawable(R.drawable.swipe_icon));

        card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.d("Swipeable Card", "I liked it");
            }

            @Override
            public void onDislike() {
                Log.d("Swipeable Card", "I did not liked it");
            }
        });

        card.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swipeable Cards","I am pressing the card");
            }
        });

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this.getActivity());
        adapter.add(card);
        adapter.add(card);
        adapter.add(card);
        adapter.add(card);
        adapter.add(card);
        adapter.add(card);
        mCardContainer.setAdapter(adapter);

        return view;
    }
}
