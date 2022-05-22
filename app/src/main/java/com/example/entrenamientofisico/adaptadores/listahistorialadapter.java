package com.example.entrenamientofisico.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entrenamientofisico.R;
import com.example.entrenamientofisico.entidades.historial;

import java.util.ArrayList;

public class listahistorialadapter extends RecyclerView.Adapter<listahistorialadapter.ContactViewHolder>{

    ArrayList<historial> listaView;

    public listahistorialadapter(ArrayList<historial> listaView){
        this.listaView = listaView;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_item_historial, null, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.viewTitulo.setText(listaView.get(position).getTitleEjercicio());
        holder.showdatetime.setText(listaView.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return listaView.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView viewTitulo;
        TextView showdatetime;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTitulo = itemView.findViewById(R.id.viewTitulo);
            showdatetime = itemView.findViewById(R.id.datetimeshow);
        }
    }
}
