package com.learn.dimdimasdim.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoosen, btnClose;

    private EditText edtPesanDialog;

    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(
        OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoosen = view.findViewById(R.id.btn_chosen);
        btnClose = view.findViewById(R.id.btn_close);
        edtPesanDialog = view.findViewById(R.id.edt_pesan_dialog);

        btnClose.setOnClickListener(this);
        btnChoosen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_chosen:
                if (edtPesanDialog != null){
                    String pesan = edtPesanDialog.getText().toString();
                    getOnOptionDialogListener().onOptionSend(pesan);
                    dismiss();
                }
                break;
            case R.id.btn_close:
                getDialog().cancel();
                break;
        }
    }

    public interface OnOptionDialogListener {

        void onOptionSend(String text);
    }
}
