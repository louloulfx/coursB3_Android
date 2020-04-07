package com.example.coursb3_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>
{

    // Liste d'objets métier :
    private List<Liste> listeMemos = null;


    /**
     * Constructeur.
     * @param listeMemos Liste de mémos
     */
    public ListAdapter(List<Liste> listeMemos)
    {
        this.listeMemos = listeMemos;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liste, parent, false);
        return new ListViewHolder(viewList);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position)
    {
        holder.textViewIntitule.setText(listeMemos.get(position).intitule);
    }

    @Override
    public int getItemCount()
    {
        return listeMemos.size();
    }

    /**
     * Ajout d'un mémo à la liste.
     * @param memo Mémo
     */
    public void ajouterMemo(Liste memo)
    {
        listeMemos.add(0, memo);
        notifyItemInserted(0);
    }


    /**
     * ViewHolder.
     */
    class ListViewHolder extends RecyclerView.ViewHolder
    {

        // Vue intitulé mémo :
        TextView textViewIntitule = null;


        /**
         * Constructeur.
         * @param itemView Vue item
         */
        ListViewHolder(final View itemView)
        {
            super(itemView);
            textViewIntitule = itemView.findViewById(R.id.memo_intitule);

            // listener :
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    // récupération du context depuis une vue :
                    Context context = itemView.getContext();

                    // affichage du toast :
                    Toast.makeText(context, context.getString(R.string.main_message_position, getAdapterPosition()), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

}
