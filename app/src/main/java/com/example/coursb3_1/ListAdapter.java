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

    private MainActivity mainActivity;
    private List<ListDTO> listDTO = null;


    public ListAdapter(MainActivity mainActivity, List<ListDTO> listDTO)
    {
        this.mainActivity = mainActivity;
        this.listDTO = listDTO;
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
        holder.textViewIntitule.setText(listDTO.get(position).intitule);
    }

    @Override
    public int getItemCount()
    {
        return listDTO.size();
    }


    public void ajouterMemo(List<ListDTO> listDTO)
    {
        this.listDTO = listDTO;
        notifyDataSetChanged();
    }


    public ListDTO getListDTOByPosition(int position)
    {
        return listDTO.get(position);
    }

    /**
     * ViewHolder.
     */
    class ListViewHolder extends RecyclerView.ViewHolder
    {

        // Vue intitulé mémo :
        TextView textViewIntitule = null;


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
                    mainActivity.onClickItem(getAdapterPosition());
                }
            });
        }

    }

}
