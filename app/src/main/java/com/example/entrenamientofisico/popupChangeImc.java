package com.example.entrenamientofisico;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.entrenamientofisico.db.dbinsert;

public class popupChangeImc extends AppCompatDialogFragment {
    private EditText editAltura, editPeso;
    private dialogChangeImc listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_change_imc, null);
        builder.setView(view)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String altura = editAltura.getText().toString();
                        String peso = editPeso.getText().toString();


                        listener.applyTexts(peso, altura);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        editPeso = view.findViewById(R.id.editPesoText);
        editAltura = view.findViewById(R.id.editAlturaText);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (dialogChangeImc) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + "Error");
        }
    }

    public interface dialogChangeImc{
        void applyTexts(String peso, String altura);
    }
}
