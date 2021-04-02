package com.habibnavarro.taller1;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FisicaFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FisicaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String function;

    View view;
    Button btn_cal_velocidad, btn_speed, btn_power, btn_voltaje1, btn_cal_voltaje;
    TextView inp_v_1, inp_v_2, txt_res, txt_title, txt_v_1, txt_v_2;
    TextView amperaje, resistencia1, resistencia2, resistencia3, voltaje;
    ConstraintLayout cont_1, cont_2;
    Spinner spinner;
    Switch switch1;
    int valor = 0;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FisicaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FisicaFragment newInstance(String param1, String param2) {
        FisicaFragment fragment = new FisicaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FisicaFragment() {
        // Required empty public constructor
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
        view = inflater.inflate(R.layout.fragment_fisica, container, false);

        inp_v_1 = view.findViewById(R.id.inp_v_1);
        inp_v_2 = view.findViewById(R.id.inp_v_2);
        txt_res = view.findViewById(R.id.txt_res);
        txt_title = view.findViewById(R.id.txt_title);
        txt_v_1 = view.findViewById(R.id.txt_v_1);
        txt_v_2 = view.findViewById(R.id.txt_v_2);

        btn_speed = view.findViewById(R.id.btn_speed);
        btn_power = view.findViewById(R.id.btn_power);
        btn_voltaje1 = view.findViewById(R.id.btn_voltaje1);
        btn_cal_velocidad = view.findViewById(R.id.btn_cal_velocidad);
        btn_cal_voltaje = view.findViewById(R.id.btn_cal_voltaje2);
        cont_1 = view.findViewById(R.id.cont_1);
        cont_2 = view.findViewById(R.id.cont_2);

        amperaje = view.findViewById(R.id.val_amperaje2);
        resistencia1 = view.findViewById(R.id.val_resistencia);
        resistencia2 = view.findViewById(R.id.val_resistencia4);
        resistencia3 = view.findViewById(R.id.val_resistencia5);
        voltaje = view.findViewById(R.id.val_voltaje2);
        switch1 = view.findViewById(R.id.switch1);

        spinner = (Spinner) view.findViewById(R.id.spinner4);
        Integer[] items = new Integer[]{2,3};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor = items[position];
                if (valor == 2)
                    resistencia3.setEnabled(false);
                else
                    resistencia3.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        btn_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont_1.setVisibility(View.VISIBLE);
                cont_2.setVisibility(View.INVISIBLE);
                function = "velocidad";
                txt_title.setText("Calcular velocidad");
                txt_v_1.setText("Ingrese la distancia:");
                txt_v_2.setText("Ingrese el tiempo:");
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont_1.setVisibility(View.VISIBLE);
                cont_2.setVisibility(View.INVISIBLE);
                function = "fuerza";
                txt_title.setText("Calcular fuerza");
                txt_v_1.setText("Ingrese la masa:");
                txt_v_2.setText("Ingrese la aceleración:");
            }
        });
        btn_voltaje1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont_1.setVisibility(View.INVISIBLE);
                cont_2.setVisibility(View.VISIBLE);
                txt_title.setText("Calcular voltaje");
                txt_v_1.setText("Ingrese la resistencia:");
                txt_v_2.setText("Ingrese la corriente eléctrica:");
            }
        });
        btn_cal_velocidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inp_v_1.getText().toString().length() == 0 || inp_v_2.getText().toString().length() == 0)
                    Toast.makeText(getContext(), "Campo incompleto", Toast.LENGTH_SHORT).show();
                else
                    switch (function) {
                        case "velocidad":
                            txt_res.setText("Resultado: " + (Double.parseDouble(inp_v_1.getText().toString()) / Double.parseDouble(inp_v_2.getText().toString())));
                            break;
                        case "fuerza":
                            txt_res.setText("Resultado: " + (Double.parseDouble(inp_v_1.getText().toString()) * Double.parseDouble(inp_v_2.getText().toString())));
                            break;
                    }
            }
        });

        btn_cal_voltaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amperaje.length() == 0 || resistencia1.length() == 0 || resistencia2.length() == 0){
                    Toast.makeText(getContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                    voltaje.setText("");
                } else {
                    if (switch1.isChecked()){
                        if (valor == 2 ){
                            voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (1/Double.parseDouble(resistencia1.getText().toString()) + 1/Double.parseDouble(resistencia2.getText().toString())))+"");
                        }else{
                            if (resistencia3.length() == 0){
                                Toast.makeText(getContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                                voltaje.setText("");
                            }else{
                                voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (1/Double.parseDouble(resistencia1.getText().toString()) + 1/Double.parseDouble(resistencia2.getText().toString()) + 1/Double.parseDouble(resistencia3.getText().toString())))+"");
                            }
                        }
                    } else {
                        if (valor == 2 ){
                            voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (Double.parseDouble(resistencia1.getText().toString()) + Double.parseDouble(resistencia2.getText().toString())))+"");
                        }else{
                            if(resistencia3.length() == 0){
                                Toast.makeText(getContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                                voltaje.setText("");
                            } else {
                                voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (Double.parseDouble(resistencia1.getText().toString()) + Double.parseDouble(resistencia2.getText().toString()) + Double.parseDouble(resistencia3.getText().toString())))+"");
                            }
                        }
                    }
                }
            }
        });
        return view;
    }

    public void onClick_btn_calcular() {

    }
}