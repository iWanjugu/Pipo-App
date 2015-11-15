package com.miniprojects.pipo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iWanjugu on 13/11/2015.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PeopleDataViewHolder> {

    public static class PeopleDataViewHolder extends RecyclerView.ViewHolder {

        CardView cv;

        TextView idText;
        TextView first_nameText;
        TextView last_nameText;
        TextView emailText;
        TextView countryText;
        TextView company_nameText;
        TextView credit_cardText;

        public PeopleDataViewHolder(View itemView) {
            super(itemView);
            idText = (TextView) itemView.findViewById(R.id.person_id);
            first_nameText = (TextView) itemView.findViewById(R.id.first_name);
            last_nameText = (TextView) itemView.findViewById(R.id.last_name);
            emailText = (TextView) itemView.findViewById(R.id.email);
            countryText = (TextView) itemView.findViewById(R.id.country);
            company_nameText = (TextView) itemView.findViewById(R.id.company_name);
            credit_cardText = (TextView) itemView.findViewById(R.id.credit_card);

        }
    }
    List<PeopleData> dataObj;
    RVAdapter(List<PeopleData> dataObj){
        this.dataObj = dataObj;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PeopleDataViewHolder  onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.inner_card_layout, viewGroup, false);
        PeopleDataViewHolder svh = new PeopleDataViewHolder (v);
        return svh;
    }

    @Override
    public void onBindViewHolder(PeopleDataViewHolder dataObjectViewHolder, int i) {

        dataObjectViewHolder.first_nameText.setText(dataObj.get(i).first_name+" "+dataObj.get(i).last_name);
        dataObjectViewHolder.last_nameText.setText(dataObj.get(i).last_name);
        dataObjectViewHolder.company_nameText.setText(dataObj.get(i).company_name);
        dataObjectViewHolder.countryText.setText(dataObj.get(i).country);
        dataObjectViewHolder.emailText.setText(dataObj.get(i).email);
        dataObjectViewHolder.credit_cardText.setText(String.valueOf(dataObj.get(i).credit_card));
    }

    @Override
    public int getItemCount() {
        return dataObj.size();
    }
}
