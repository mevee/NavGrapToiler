package com.vee.navgraptoiler.view.fragments.property_fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vee.navgraptoiler.R;
import com.vee.navgraptoiler.controller.utils.CommonUtils;
import com.vee.navgraptoiler.model.ListYourPropertyFormData;
import com.vee.navgraptoiler.view.adapters.SelectedImagesAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddImagesFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = AddImagesFragment.class.getName();
    NavController navController = null;

    private List<String> bitmapsList;

    private final int CODE_FOR_READ_PERMISSION_MULTI = 103;
    private final int CODE_FOR_READ_PERMISSION = 101;
    private final int CODE_FOR_WRITE_PERMISSION = 102;
    private String userImagePath = "";
    private int SELECT_IMAGE_REQ = 100;
    private ArrayList<String> filepath = new ArrayList<>();
    private SelectedImagesAdapter adapter;
    Context context;


    ImageView iv_add_images;

    TextView previous_tV;

    TextView submit_tV;

    RecyclerView rv_images_list;

    private ListYourPropertyFormData plotFormData;

    public AddImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_images, container, false);
        context = getContext();

        plotFormData = CommonUtils.getFormData();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        iv_add_images = view.findViewById(R.id.iv_add_images);
        previous_tV = view.findViewById(R.id.previous_tV);
        rv_images_list = view.findViewById(R.id.rv_images_list);
        submit_tV = view.findViewById(R.id.submit_tV);

        iv_add_images.setOnClickListener(this);
        previous_tV.setOnClickListener(this);
        rv_images_list.setOnClickListener(this);
        submit_tV.setOnClickListener(this);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataFromPrevious();
    }

    public void setDataFromPrevious() {
        if (plotFormData != null) {
            if (plotFormData.getImagesSelectedPath() != null)
                setBitMapAdapter(plotFormData.getImagesSelectedPath());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FilePickerConst.REQUEST_CODE_PHOTO:
                if (resultCode == Activity.RESULT_OK && data != null) {
//                    List<Bitmap> bitmapList = new ArrayList<>();
//                    ClipData clipData = data.getClipData();
//                    if (clipData != null) {
//                        for (int i = 0; i < clipData.getItemCount(); i++) {
//                            Log.d(TAG, "Loop value : " + i);
//                            Uri uri = clipData.getItemAt(i).getUri();
//                            try {
//                                InputStream inputStream = context.getContentResolver().openInputStream(uri);
//                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                                bitmapList.add(bitmap);
//
//                            } catch (IOException error) {
//                                error.printStackTrace();
//                            }
//                        }
//
//                        Log.d(TAG, "Bitmap Array : " + bitmapList);
//                    } else {
//                        Log.d(TAG, "Bitmap ArrayElse ");
//                    }
                    filepath.clear();
                    filepath.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
                    setBitMapAdapter(filepath);
                    Glide.with(Objects.requireNonNull(this)).load(filepath.get(0)).into(iv_add_images);
                    userImagePath = filepath.get(0);
                    Toast.makeText(context, "image is set", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, filepath.get(0));
                    Log.d(TAG, "files path array size :" + filepath.size());
                }
                break;
        }
    }

    private void setBitMapAdapter(List<String> bitmaps) {
        iv_add_images.setVisibility(View.GONE);
        this.bitmapsList = bitmaps;
        plotFormData.setImagesSelectedPath(bitmaps);
        rv_images_list.setLayoutManager(new GridLayoutManager(context, 3));
        adapter = new SelectedImagesAdapter(context, new SelectedImagesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int index, int action) {

                if (action == SelectedImagesAdapter.DELETE_IMAGE) {
//                    bitmaps.remove(index);
//                    bitmapsList = bitmaps;
//                    adapter.removeData(index);
//                    filepath.remove(index);
                }

                if (action == SelectedImagesAdapter.LIST_EMPTY) {
//                    bitmaps.clear();
//                    filepath.clear();
//                    bitmapsList = bitmaps;
//                    adapter.setData(null);
//                    iv_add_images.setVisibility(View.VISIBLE);
                }
            }
        });
        adapter.setData(bitmaps);
        rv_images_list.setAdapter(adapter);
    }

    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    CODE_FOR_READ_PERMISSION);
            return false;
        } else {
            return true;
        }
    }

    private void openGallery(int count) {
        if (this != null) {
            FilePickerBuilder.getInstance().setMaxCount(count)
                    .setSelectedFiles(filepath)
                    .setActivityTheme(R.style.LibAppTheme)
                    .pickPhoto(this);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add_image:
                if (checkPermissions()) {
                    openGallery(6);
                }
                break;
            case R.id.submit_tV:
                Toast.makeText(context, "Submit", Toast.LENGTH_SHORT).show();
                break;

            case R.id.previous_tV:
                navController.navigateUp();
                break;

        }
    }
}
