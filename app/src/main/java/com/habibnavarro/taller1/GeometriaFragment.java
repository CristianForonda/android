package com.habibnavarro.taller1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GeometriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeometriaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    
    Button btn_cal_geometria2;

    TextView x1, y1, x2, y2, res1, res2;
    Button calcular;
    Spinner spinner;
    int valor= 0;
    double raiz = 0, pendiente = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0;
    String c1, c2;

    public GeometriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeometriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeometriaFragment newInstance(String param1, String param2) {
        GeometriaFragment fragment = new GeometriaFragment();
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
        View view = inflater.inflate(R.layout.fragment_geometria, container, false);

        x1 = view.findViewById(R.id.nx);
        y1 = view.findViewById(R.id.ny);
        x2 = view.findViewById(R.id.nx3);
        y2 = view.findViewById(R.id.ny3);
        res1 = view.findViewById(R.id.resultado);
        res2 = view.findViewById(R.id.resultado3);

        spinner = (Spinner) view.findViewById(R.id.spinner3);
        String[] items = new String[]{"Cuadrante","Pendiente","Distancia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        btn_cal_geometria2 = view.findViewById(R.id.btn_cal_geometria2);
        btn_cal_geometria2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x1.length() == 0 || y1.length() == 0 || x2.length() == 0 || y2.length() == 0) {
                    Toast.makeText(getContext(),"Faltan casillas por rellenar", Toast.LENGTH_LONG).show();
                } else {
                    if (valor == 0){
                        if(Double.parseDouble(x1.getText().toString()) == 0 || Double.parseDouble(y1.getText().toString()) == 0){
                            c1 = "La coordenada (x1,y1) esta en medio de dos cuadrantes";
                        } else {
                            if (Double.parseDouble(x1.getText().toString()) > 0 && Double.parseDouble(y1.getText().toString()) > 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 1";
                            }
                            if (Double.parseDouble(x1.getText().toString()) < 0 && Double.parseDouble(y1.getText().toString()) > 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 2";
                            }
                            if (Double.parseDouble(x1.getText().toString()) < 0 && Double.parseDouble(y1.getText().toString()) < 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 3";
                            }
                            if (Double.parseDouble(x1.getText().toString()) > 0 && Double.parseDouble(y1.getText().toString()) < 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 4";
                            }
                        }
                        if (Double.parseDouble(x2.getText().toString()) == 0 || Double.parseDouble(y2.getText().toString()) == 0) {
                            c2 = "La coordenada (x2,y2) esta en medio de dos cuadrantes";
                        } else {
                            if (Double.parseDouble(x2.getText().toString()) > 0 && Double.parseDouble(y2.getText().toString()) > 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 1";
                            }
                            if (Double.parseDouble(x2.getText().toString()) < 0 && Double.parseDouble(y2.getText().toString()) > 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 2";
                            }
                            if (Double.parseDouble(x2.getText().toString()) < 0 && Double.parseDouble(y2.getText().toString()) < 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 3";
                            }
                            if (Double.parseDouble(x2.getText().toString()) > 0 && Double.parseDouble(y2.getText().toString()) < 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 4";
                            }
                        }
                        res1.setText(c1);
                        res2.setText(c2);
                    }
                    if (valor == 2) {
                        r1 = (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString())) * (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString()));
                        r2 = (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString())) * (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString()));
                        r3 = Math.sqrt(r1+r2);

                        res1.setText(String.valueOf(r3));
                        res2.setText("");
                    }
                    if (valor == 1){
                        if((Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString())) == 0){
                            res1.setText("No tiene pendiente");
                            res2.setText("");
                        } else {
                            pendiente = (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString())) / (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString()));
                            res1.setText(String.valueOf(pendiente));
                            res2.setText("");
                        }
                    }
                }
            }
        });
        
        return view;
    }
    
    public void onClick() { }
}