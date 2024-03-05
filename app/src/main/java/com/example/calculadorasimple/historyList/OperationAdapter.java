package com.example.calculadorasimple.historyList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculadorasimple.R;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<OperationViewHolder> {

    private List<Operation> operationList;

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("lista", "OnCreateViewHolder");
        View operationItemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.operation_item, parent, false);
        return new OperationViewHolder(operationItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        Log.i("lista", "onBindViewHolder");
        holder.bind(operationList.get(position));
    }

    @Override
    public int getItemCount() {
        return operationList.size();
    }

    public void setList(List<Operation> list) {
        this.operationList = list;
    }

    public void agregarCalculoNuevo(Operation calculoNuevo) {
        operationList.add(calculoNuevo);
    }
}
