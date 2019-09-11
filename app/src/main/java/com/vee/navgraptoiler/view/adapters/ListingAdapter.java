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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.vee.navgraptoiler.R;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {
    public static final int VIEW_PROPERTY_DETAIL =100,REMOVE_PROPERTY=102;

    private Context context;
    private boolean isFav;
    ItemClickListener listener;
    public ListingAdapter(Context context, boolean isFav,ItemClickListener listener) {
        this.context = context;
        this.isFav = isFav;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list2, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder) viewHolder;

//        holder.rl_bg.setOnClickListener(v -> {
//            context.startActivity(new Intent(context, ProductDetailActivity.class));
//        });

        holder.ll_call.setOnClickListener(v -> {
            showCallDialog(context, "1234567890");
        });

        holder.ll_directions.setOnClickListener(v -> {
            Double lat = 28.5355;
            Double longi = 77.3910;
            goToMapaApp(lat,longi);
        });


        holder.ll_message.setOnClickListener(v -> {
            goToMessageApp("1234567890");
        });

        if (!holder.isBookmark) {
            holder.isBookmark = false;
            //for vector tint
            holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.bg_grey), android.graphics.PorterDuff.Mode.SRC_IN);
            //for png tint
//            holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.cp_grey), android.graphics.PorterDuff.Mode.MULTIPLY);
        } else {
            holder.isBookmark = true;
            //for vector tint
            holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);

            //for png tint
//            holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
        }


        holder.ll_Add_to_fav.setOnClickListener(v -> {
            if (holder.isBookmark) {
                holder.isBookmark = false;
                holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.cp_grey), android.graphics.PorterDuff.Mode.SRC_IN);
//                holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.cp_grey), android.graphics.PorterDuff.Mode.MULTIPLY);
//                holder.tv_add_to_my_list.setText("Add to favourite");
                Toast.makeText(context, "Removed from favourite", Toast.LENGTH_SHORT).show();
            } else {
                holder.isBookmark = true;
//                holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
            holder.iv_bookmark.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
//            holder.tv_add_to_my_list.setText("My favourite");
                Toast.makeText(context, "Added to favourite", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ll_share.setOnClickListener(v -> {
            shareTheApp("Room Id");
        });
        holder.bind(position,listener);
    }

    private void shareTheApp(String s) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.webkype.toiler");
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    private void goToMessageApp(String number) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address",number);
        smsIntent.putExtra("sms_body","Hey there , i am interested in your property.");
        context.startActivity(smsIntent);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {


        private RelativeLayout rl_bg;
        private ImageView iv_call;
        private ImageView iv_directions;
        private ImageView iv_bookmark;
        private LinearLayout ll_call;

        private LinearLayout ll_directions;
        private LinearLayout ll_message;

        private LinearLayout ll_Add_to_fav;

        private LinearLayout ll_share;

//        @BindView(R.id.tv_add_to_my_list)
//        TextView tv_add_to_my_list;


        Boolean isBookmark = isFav;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_bg =itemView.findViewById(R.id.rl_bg);
            iv_call =itemView.findViewById(R.id.iv_call);
            ll_call =itemView.findViewById(R.id.ll_call);
            iv_bookmark =itemView.findViewById(R.id.iv_bookmark);
            ll_directions =itemView.findViewById(R.id.ll_direction);
            ll_message =itemView.findViewById(R.id.ll_message);
            ll_Add_to_fav =itemView.findViewById(R.id.ll_Add_to_fav);
            ll_share =itemView.findViewById(R.id.ll_share);
        }

        public void bind(final int index,final ItemClickListener listener){

            rl_bg.setOnClickListener(v -> {
                listener.onItemClick(index, VIEW_PROPERTY_DETAIL);
            });

        }

    }

    private void goToMapaApp(Double lat,Double longi) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
//            Uri.parse("http://maps.google.com/maps?saddr="+lat+","+longi+"&daddr="+lat+","+longi)); //sddr starting address and dasddr end adress
                Uri.parse("http://maps.google.com/maps?daddr=" + lat + "," + longi));//locate from current address
        context.startActivity(intent);
    }
    private void showCallDialog(final Context context, String number) {
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
