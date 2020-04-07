package com.example.coursb3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    // Vues :
    private RecyclerView recyclerView = null;
    private EditText editTextMemo = null;

    // Adapter :
    private ListAdapter listeAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // init :
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // vues :
        recyclerView = findViewById(R.id.liste_memos);
        editTextMemo = findViewById(R.id.saisie_memo);

        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);

        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // contenu d'exemple :
        List<Liste> listeMemos = new ArrayList<>();
        for (int a = 0 ; a < 20 ; a++)
        {
            listeMemos.add(new Liste("Mémo n°" + (a + 1)));
        }

        // adapter :
        listeAdapter = new ListAdapter(listeMemos);
        recyclerView.setAdapter(listeAdapter);
    }

    /**
     * Listener clic bouton valider.
     * @param view Bouton valider
     */
    public void onClickBoutonValider(View view)
    {
        // ajout du mémo :
        listeAdapter.ajouterMemo(new Liste(editTextMemo.getText().toString()));

        // animation de repositionnement de la liste (sinon on ne voit pas l'item ajouté) :
        recyclerView.smoothScrollToPosition(0);

        // on efface le contenu de la zone de saisie :
        editTextMemo.setText("");
    }

}
