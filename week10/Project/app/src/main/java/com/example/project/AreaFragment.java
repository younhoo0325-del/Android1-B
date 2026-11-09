
package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AreaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_area,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        EditText editText =
                view.findViewById(R.id.editText21);

        TextView textView =
                view.findViewById(R.id.textView21);

        Button button1 =
                view.findViewById(R.id.button21);

        Button button2 =
                view.findViewById(R.id.button22);

        MyMethod method = new MyMethod(requireContext());

        button1.setOnClickListener(v ->
                method.changeToMeter(editText, textView)
        );

        button2.setOnClickListener(v ->
                method.changeToPyeong(editText, textView)
        );
    }
}
