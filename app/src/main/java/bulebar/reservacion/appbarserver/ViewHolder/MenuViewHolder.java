package bulebar.reservacion.appbarserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import bulebar.reservacion.appbarserver.Interface.ItemClickListener;
import bulebar.reservacion.appbarserver.R;

/**
 * Created by MDJ16 on 12/02/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder (View itemView){
        super(itemView);

        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

    }
}
