package com.example.calculadorasimple.historyList;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculadorasimple.R;

public class OperationViewHolder extends RecyclerView.ViewHolder {

    private TextView TvOperator1, TvOperator2, TvResult;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);

        TvOperator1 = itemView.findViewById(R.id.operator_1);
        TvOperator2 = itemView.findViewById(R.id.operator_2);
        TvResult = itemView.findViewById(R.id.result);
    }

    public void bind(Operation itemOperacion) {
        TvOperator1.setText(itemOperacion.getOperator1());
        TvOperator2.setText(itemOperacion.getOperator2());
        TvResult.setText(itemOperacion.getResult());
    }
}
