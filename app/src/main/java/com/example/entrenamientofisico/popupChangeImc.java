package com.example.entrenamientofisico;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class popupChangeImc extends AppCompatDialogFragment {
    private EditText editAltura;
    private EditText editPeso;
    private dialogChangeImc listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_change_imc, null);
        builder.setView(view)
                .setTitle("Cambiar (Peso y Altura)")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String altura = editAltura.getText().toString();
                        String peso = editPeso.getText().toString();
                        listener.applyTexts(altura, peso);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        editAltura = view.findViewById(R.id.editAlturaText);
        editPeso = view.findViewById(R.id.editPesoText);
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
        void applyTexts(String altura, String peso);
    }
}
