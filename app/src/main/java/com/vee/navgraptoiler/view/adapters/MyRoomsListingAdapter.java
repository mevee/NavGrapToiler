package com.vee.navgraptoiler.view.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vee.navgraptoiler.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyRoomsListingAdapter extends RecyclerView.Adapter<MyRoomsListingAdapter.ViewHolder> {
    public static final int EDIT_PROPERTY=100,REMOVE_PROPERTY=102;
    private Context context;
    ItemClickListener listener;
    public MyRoomsListingAdapter(Context context, ItemClickListener listener) {
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_listing_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder)viewHolder;

//        holder.iv_edit.setOnClickListener(v->{
//            Intent intent = new Intent(context, SellMyPropertyActivity.class);
//            intent.putExtra("header","Edit your property");
//            context.startActivity(intent);
//        });

        holder.tb_btn_remove.setOnClickListener(v->{
            showCallDialog(context);
        });
        holder.tb_btn_enable.setOnClickListener(v->{
            if (holder.isEnabled){
                holder.isEnabled=false;
                holder.tb_btn_enable.setText("Disabled");
                holder.tb_btn_enable.setBackgroundColor(context.getResources().getColor(R.color.tvbtnDisableColor));
                Toast.makeText(context, "This property will not visible to others ", Toast.LENGTH_SHORT).show();
            }else {
                holder.isEnabled=true;
                holder.tb_btn_enable.setText("Enabled");
                holder.tb_btn_enable.setBackgroundColor(context.getResources().getColor(R.color.tvbtnEnableColor));
                Toast.makeText(context, "This property is visible to others ", Toast.LENGTH_SHORT).show();
            }
        });
//        holder.visitLatestCounter_tV.setText("# "+(position+1)+"");
        holder.bind(position,listener);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_edit;
        private TextView tb_btn_remove;
        private TextView tb_btn_enable;

        boolean isEnabled=true;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_edit =itemView.findViewById(R.id.iv_edit);
            tb_btn_remove =itemView.findViewById(R.id.tb_btn_remove);
            tb_btn_enable =itemView.findViewById(R.id.tb_btn_enable);
        }
        public void bind(final int index,final ItemClickListener listener){

            iv_edit.setOnClickListener(v -> {
                listener.onItemClick(index,EDIT_PROPERTY);
            });

        }
    }

    private void showCallDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to remove this room from listing?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show();
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
