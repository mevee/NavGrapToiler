package com.vee.navgraptoiler.view.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vee.navgraptoiler.R;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectedImagesAdapter extends RecyclerView.Adapter<SelectedImagesAdapter.ViewHolder> {

public static final int DELETE_IMAGE=100,LIST_EMPTY=102;
    private Context context;

    ItemClickListener listener;
    List<String> bitmapList;

    public SelectedImagesAdapter(Context context, ItemClickListener listener) {
        this.listener = listener;
        this.context = context;
    }

    public void setData(List<String> bitmaps) {
        this.bitmapList = bitmaps;
        notifyDataSetChanged();
    }

    public void removeData(int position) {
//        position--;
        if (bitmapList.size()<=1){
            listener.onItemClick(position,LIST_EMPTY);
        }

        this.bitmapList.remove(position);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_selected_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        String bitmap = bitmapList.get(position);
        final int index = bitmapList.indexOf(bitmap);
        Glide.with(Objects.requireNonNull(context)).load(bitmap).into(holder.iv_selected_image);
//        holder.iv_selected_image.setImageBitmap(bitmap);
        holder.bind(index,listener);
    }

    @Override
    public int getItemCount() {
        return bitmapList != null ? bitmapList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_selected_image;
        private ImageView iv_delet_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_selected_image = itemView.findViewById(R.id.iv_selected_image);
            iv_delet_item = itemView.findViewById(R.id.iv_delet_item);
        }
        public void bind(final int index,final ItemClickListener listener){

            iv_delet_item.setOnClickListener(v -> {
                listener.onItemClick(index,DELETE_IMAGE);
            });

        }
    }

    private void showCallDialog(Context context, String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to call the owner?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                context.startActivity(intent);
                dialog.dismiss();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    public interface ItemClickListener {
        void onItemClick(int positin, int action);
    }
}
