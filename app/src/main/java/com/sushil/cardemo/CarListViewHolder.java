package com.sushil.cardemo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sushil.cardemo.databinding.CarItemBinding;


public class CarListViewHolder extends RecyclerView.ViewHolder {
    CarItemBinding b;

    public CarListViewHolder(@NonNull View itemView, CarItemBinding binding) {
        super(itemView);
        this.b = binding;
    }

    public void bind(CarModel model, int position, CarActionListener carActionListener) {

        b.tvName.setText(model.name);
        b.tvType.setText(model.type);
        b.tvColor.setText(model.color);
        b.tvModel.setText(model.model);
        b.tvPrice.setText(model.price);

        b.ivImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carActionListener.onDelete(position);
            }
        });

       /* b.tvModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoveAddressFragment.newInstance(model.id, "").show(
                        ((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(), "remove_address_fragment");
            }
        });*/
       /* b.ivAddressRowUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send data to another activity
                Intent intent = new Intent(itemView.getContext(), UpdateAddressActivity.class);
                intent.putExtra("data", new Gson().toJson(model));
                itemView.getContext().startActivity(intent);

            }
        });*/
    }
    public static CarListViewHolder create(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CarItemBinding b = CarItemBinding.inflate(inflater, parent, false);
        return new CarListViewHolder(b.getRoot(), b);
    }
}

