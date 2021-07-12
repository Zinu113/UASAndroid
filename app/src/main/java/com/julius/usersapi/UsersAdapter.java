package com.julius.usersapi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.julius.usersapi.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {
    private List<User> dataList;
    private Context context;

    public UsersAdapter(Context context, List<User> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        private TextView id;
        private TextView email;
        private TextView first_name;
        private TextView last_name;
        private ImageView avatar;

        private Button btnEdit;
        private Button btnHapus;

        private LinearLayout userContainer;
        private TextView firstNameHeader;
        private TextView lastNameHeader;

        CustomViewHolder(View itemView){
            super(itemView);
            mView       = itemView;
            id          = mView.findViewById(R.id.id);
            email       = mView.findViewById(R.id.email);
            first_name  = mView.findViewById(R.id.firstName);
            last_name   = mView.findViewById(R.id.lastName);
            avatar      = mView.findViewById(R.id.avatar);

            btnEdit     = mView.findViewById(R.id.btnEdit);
            btnHapus    = mView.findViewById(R.id.btnHapus);

            userContainer = mView.findViewById(R.id.userContainer);
            firstNameHeader = mView.findViewById(R.id.firstNameHeader);
            lastNameHeader = mView.findViewById(R.id.lastNameHeader);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.users_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.CustomViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getId());
        holder.email.setText(dataList.get(position).getEmail());
        holder.first_name.setText(dataList.get(position).getFirst_name());
        holder.last_name.setText(dataList.get(position).getLast_name());

        Picasso.with(context).load(dataList.get(position).getAvatar()).into(holder.avatar);

        holder.userContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visible = holder.first_name.getVisibility();
                if(visible == View.GONE){
                    holder.firstNameHeader.setVisibility(View.VISIBLE);
                    holder.lastNameHeader.setVisibility(View.VISIBLE);
                    holder.first_name.setVisibility(View.VISIBLE);
                    holder.last_name.setVisibility(View.VISIBLE);
                    holder.last_name.setVisibility(View.VISIBLE);
                    holder.btnEdit.setVisibility(View.VISIBLE);
                    holder.btnHapus.setVisibility(View.VISIBLE);
                }
                else{
                    holder.firstNameHeader.setVisibility(View.GONE);
                    holder.lastNameHeader.setVisibility(View.GONE);
                    holder.first_name.setVisibility(View.GONE);
                    holder.last_name.setVisibility(View.GONE);
                    holder.btnEdit.setVisibility(View.GONE);
                    holder.btnHapus.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
