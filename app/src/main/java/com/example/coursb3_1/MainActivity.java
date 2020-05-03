package com.example.coursb3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.Header;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coursb3_1.json.RetourWS;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String LINK = "https://httpbin.org/post";
    private static final String LISTE_NAME = "liste";
    private static final String POSITION = "position";

    private RecyclerView recyclerView = null;
    private EditText editTextMemo = null;

    private ListAdapter listeAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.liste_memos);
        editTextMemo = findViewById(R.id.saisie_memo);

        List<ListDTO> listeListDTO = ListeDatabaseHelper.getDatabase(this).listeDAO().getListeListe();


        recyclerView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listeAdapter = new ListAdapter(this, listeListDTO);
        recyclerView.setAdapter(listeAdapter);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int dernierePosition = preferences.getInt(POSITION, -1);
        if (dernierePosition > -1)
        {
            Toast.makeText(this, getString(R.string.main_message_derniere_position, dernierePosition), Toast.LENGTH_LONG).show();
        }

    }

    public void onClickItem(int position) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(POSITION, position);
        editor.apply();

        ListDTO listDTO = listeAdapter.getListDTOByPosition(position);

        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams requestParams = new RequestParams();
        requestParams.put(LISTE_NAME, listDTO.intitule);

        client.post(LINK, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                String retour = new String(response);
                Gson gson = new Gson();
                RetourWS retourWS = gson.fromJson(retour, RetourWS.class);
                Toast.makeText(MainActivity.this, retourWS.form.liste, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Log.e(TAG, e.toString());
            }
        });
    }

    /**
     * Listener clic bouton valider.
     * @param view Bouton valider
     */
    public void onClickBoutonValider(View view)
    {
        ListDTO listDTO = new ListDTO(editTextMemo.getText().toString());
        ListeDatabaseHelper.getDatabase(this).listeDAO().insert(listDTO);

        List<ListDTO> listeListDTO = ListeDatabaseHelper.getDatabase(this).listeDAO().getListeListe();

        listeAdapter.ajouterMemo(listeListDTO);

        recyclerView.smoothScrollToPosition(0);

        editTextMemo.setText("");
    }

}
