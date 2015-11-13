
package com.miniprojects.pipo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by iWanjugu on 13/11/2015.
 */
public class PeopleDataViewHolder extends RecyclerView.ViewHolder {
    TextView idText;
    TextView first_nameText;
    TextView last_nameText;
    TextView emailText;
    TextView countryText;
    TextView company_nameText;
    TextView credit_cardText;


    public PeopleDataViewHolder(View itemView) {
        super(itemView);
        idText = (TextView)itemView.findViewById(R.id.person_id);
        first_nameText = (TextView) itemView.findViewById(R.id.first_name);
        last_nameText = (TextView)itemView.findViewById(R.id.last_name);
        emailText = (TextView)itemView.findViewById(R.id.email);
        countryText = (TextView)itemView.findViewById(R.id.country);
        company_nameText = (TextView)itemView.findViewById(R.id.company_name);
        credit_cardText = (TextView)itemView.findViewById(R.id.credit_card);

    }

}

