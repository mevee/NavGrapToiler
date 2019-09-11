package com.vee.navgraptoiler.view.fragments.property_fragments;


import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.vee.navgraptoiler.R;
import com.vee.navgraptoiler.controller.utils.CommonUtils;
import com.vee.navgraptoiler.model.ListYourPropertyFormData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPropertyFormFragment extends Fragment {

    NavController navController =null;
    @BindView(R.id.sp_property_type)
    AppCompatSpinner sp_property_type;

    @BindView(R.id.sp_no_of_rooms)
    AppCompatSpinner sp_no_of_rooms;



    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.rg_listing_type)
    RadioGroup rg_listing_type;

    @BindView(R.id.signUp_tV)
    TextView signUp_tV;

    @BindView(R.id.et_address)
    EditText et_address;
    @BindView(R.id.et_city)
    EditText et_city;
    @BindView(R.id.et_state)
    EditText et_state;
    @BindView(R.id.et_zipcode)
    EditText et_zipcode;

    @BindView(R.id.et_sp_note)
    EditText et_sp_note;


    String  listingType ="",propType="",stringNoOfRooms="",address="",state="",city="",zipcode="",note="";

    final String visiblePropType = "---- Property Type ----";
    final String visibleNoOFRooms = "---- No Of Rooms ----";
    List<String> noOfRooms = new ArrayList<>();
    List<String> propertyType = new ArrayList<>();


    Context context;
    private ListYourPropertyFormData plotFormData;

    public AddPropertyFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_property_form, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        propertyType.add(visiblePropType);
        propertyType.add("Room");
        propertyType.add("Flat");
        propertyType.add("Shop");
        propertyType.add("Office");
        propertyType.add("Plot");
        propertyType.add("Bungalow");
        ArrayAdapter<String> spinnerAdapetr = new ArrayAdapter<>(context, R.layout.spinner_items, propertyType);
        sp_property_type.setAdapter(spinnerAdapetr);
        sp_property_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                propType = sp_property_type.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        noOfRooms.add(visibleNoOFRooms);
        noOfRooms.add("1BHK");
        noOfRooms.add("2BHK");
        noOfRooms.add("3BHK");
        noOfRooms.add("4BHK");
        noOfRooms.add("5BHK");
        noOfRooms.add("1 Room Set");
        noOfRooms.add("2 Room Set");

        ArrayAdapter<String> noOfRoomsAdapter = new ArrayAdapter<>(context, R.layout.spinner_items, noOfRooms);
        sp_no_of_rooms.setAdapter(noOfRoomsAdapter);
        sp_no_of_rooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stringNoOfRooms = sp_no_of_rooms.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        signUp_tV.setOnClickListener(v -> {
            String city = et_city.getText().toString();
            String state = et_state.getText().toString();
            String address = et_address.getText().toString();
            String zipcode = et_zipcode.getText().toString();
            String note = et_sp_note.getText().toString();
            saveDataForNextFrag();
            navController.navigate(R.id.action_addPropertyFormFragment_to_addImagesFragment);
        });


        rg_listing_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb_buy){
                    listingType="Buy";
                }else {
                    listingType="Rent";
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

            }
        });
        if (getArguments()!=null){
            String title = getArguments().getString("title");
            tv_title.setText(title);

        }
    }

    private void saveDataForNextFrag(){
        String city = et_city.getText().toString();
        String state = et_state.getText().toString();
        String address = et_address.getText().toString();
        String zipcode = et_zipcode.getText().toString();
        String note = et_sp_note.getText().toString();
        plotFormData.setAddress(address);
        plotFormData.setCity(city);
        plotFormData.setState(state);
        plotFormData.setZipCode(zipcode);
        plotFormData.setNoOffRooms(stringNoOfRooms);
        plotFormData.setListingType(listingType);
        plotFormData.setPropertyType(propType);
        plotFormData.setNote(note);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        plotFormData = CommonUtils.getFormData();

        if (plotFormData != null) {
            setPrevData();
        }
    }
    private void setPrevData() {

        if (plotFormData.getListingType() != null) {
           if (plotFormData.getListingType().equals("Rent")){
               rg_listing_type.check(R.id.rb_rent);
           }else {
               rg_listing_type.check(R.id.rb_buy);
           }
        }

        if (plotFormData.getNoOffRooms() != null) {
            for (String val : noOfRooms) {
                if (val.equals(plotFormData.getNoOffRooms())) {
                    int index = noOfRooms.indexOf(val);
                    sp_no_of_rooms.setSelection(index);
                 break;
                }
            }
        }

        if (plotFormData.getPropertyType() != null) {
            for (String val : propertyType) {
                if (val.equals(plotFormData.getPropertyType())) {
                    int index = propertyType.indexOf(val);
                    sp_property_type.setSelection(index);
                    break;
                }
            }
        }

        et_zipcode.setText(plotFormData.getZipCode());
        et_address.setText(plotFormData.getAddress());
        et_city.setText(plotFormData.getCity());
        et_state.setText(plotFormData.getState());
        et_sp_note.setText(plotFormData.getNote());
    }

}
