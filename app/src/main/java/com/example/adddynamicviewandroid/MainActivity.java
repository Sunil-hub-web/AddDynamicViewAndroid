package com.example.adddynamicviewandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    Button button_add,button_submited_list;

    List<String> teamList = new ArrayList<>();
    ArrayList<TranningModel> tranningModels_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.layout_list);
        button_add = findViewById(R.id.button_add);
        button_submited_list = findViewById(R.id.button_submited_list);

        button_add.setOnClickListener(this);
        button_submited_list.setOnClickListener(this);

        teamList.add("tranning1");
        teamList.add("tranning2");
        teamList.add("tranning3");
        teamList.add("tranning4");
        teamList.add("tranning5");
        teamList.add("tranning6");
        teamList.add("tranning7");

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.button_add:

                addView();

                break;

            case R.id.button_submited_list:

                if(checkifvalidandRead()){

                    Log.d("hsdgbeu",tranningModels_List.toString());

                    Toast.makeText(this, "Data Added In The List", Toast.LENGTH_SHORT).show();

                }

                break;
        }

    }

    public Boolean checkifvalidandRead(){

        tranningModels_List.clear();

        boolean result = true;

        for(int i=0;i<linearLayout.getChildCount();i++){

            View createView = linearLayout.getChildAt(i);

            EditText editText = createView.findViewById(R.id.edittext_trainning);
            AutoCompleteTextView auto_caste = createView.findViewById(R.id.auto_caste);

            TranningModel tranningModel1 = new TranningModel();

            if(!editText.getText().toString().trim().equals("")){

                tranningModel1.setWhereTranning(editText.getText().toString().trim());

            }else{

                result = false;
                break;
            }

            if(!auto_caste.getText().toString().equals("")){

                tranningModel1.setTranningName(auto_caste.getText().toString().trim());
            }else{

                result = false;
                break;
            }

            tranningModels_List.add(tranningModel1);

        }

        if(tranningModels_List.size() == 0){

            result = false;

            Toast.makeText(this, "Add the Tranning!", Toast.LENGTH_SHORT).show();

        }else if(!result){

            Toast.makeText(this, "Enter All the Details Correctly", Toast.LENGTH_SHORT).show();

        }

        return result;
    }

    public void addView(){

        View createView = getLayoutInflater().inflate(R.layout.row_add_cricket,null,false);

        EditText editText = createView.findViewById(R.id.edittext_trainning);
        AutoCompleteTextView auto_caste = createView.findViewById(R.id.auto_caste);
        Button image_remove = createView.findViewById(R.id.image_remove);

        ArrayAdapter<String> bankaccountadapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, teamList);
        bankaccountadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        auto_caste.setAdapter(bankaccountadapter);

        image_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeView(createView);
            }
        });

        auto_caste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                (auto_caste).showDropDown();
            }
        });


        linearLayout.addView(createView);
    }

    public void removeView(View view){

        linearLayout.removeView(view);
    }
}