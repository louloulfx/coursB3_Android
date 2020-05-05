package com.example.coursb3_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MainDialogBox extends DialogFragment {
    public static final String TAG = "TAG";
    public static final String NB_WORDS = "WORDS";
    public static final String NB_PAGE = "PAGE";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        int nbWords = getArguments().getInt(NB_WORDS);
        int nbPage = getArguments().getInt(NB_PAGE);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.main_dialogue_message, nbWords, nbPage))
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }
}
