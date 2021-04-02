package com.habibnavarro.taller1;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn_negrita, btn_italica, btnrayado;
    TextView txt, mensajeEditText;
    boolean negrita = false, italica = false, rayado = false;

    public TextoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextoFragment newInstance(String param1, String param2) {
        TextoFragment fragment = new TextoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_texto, container, false);

        txt = view.findViewById(R.id.txt);
        mensajeEditText = view.findViewById(R.id.mensajeEditText);
        btn_negrita = view.findViewById(R.id.btn_negrita);
        btn_italica = view.findViewById(R.id.btn_italica);
        btnrayado = view.findViewById(R.id.btnrayado);

        btn_negrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negrita = !negrita;
                setMensajeEditText();
            }
        });
        btn_italica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                italica = !italica;
                setMensajeEditText();
            }
        });
        btnrayado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rayado = !rayado;
                setMensajeEditText();
            }
        });
        return view;
    }

    private void setMensajeEditText () {
        if (rayado)
            txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        else
            txt.setPaintFlags(0);

        if (negrita && italica)
            txt.setTypeface(null, Typeface.BOLD_ITALIC);
        else if (negrita)
            txt.setTypeface(null, Typeface.BOLD);
        else if (italica)
            txt.setTypeface(null, Typeface.ITALIC);

        txt.setText(mensajeEditText.getText().toString());
    }

    public void onClick() { }
}