package com.example.coursb3_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements View.OnClickListener {

    public static final String TEXT = "TEXTE";

    private TextView textView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        // init :
        super.onActivityCreated(savedInstanceState);
        if (getView() != null && getContext() != null)
        {
            // vues :
            textView = getView().findViewById(R.id.texte_view);
            textView.setText(getArguments().getString(TEXT));

            // listeners :
            textView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view)
    {
        // création de la boîte de dialogue :
        MainDialogBox mainDialogBox = new MainDialogBox();

        // arguments pour la boîte de dialogue :
        Bundle bundle = new Bundle();
        bundle.putInt(MainDialogBox.NB_WORDS, ((MainActivity) getActivity()).getNbCaracteres());
        bundle.putInt(MainDialogBox.NB_PAGE, ((MainActivity) getActivity()).getNbPage());
        mainDialogBox.setArguments(bundle);

        // affichage de la boîte de dialogue :
        mainDialogBox.show(getActivity().getSupportFragmentManager(), MainDialogBox.TAG);
    }
}
