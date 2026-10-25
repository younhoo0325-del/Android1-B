
package com.example.project;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialog extends Dialog {

    public interface OnConfirmListener {
        void onConfirm(String enteredText);
    }

    private final String dialogTitle;
    private final String dialogMessage;
    private final OnConfirmListener confirmListener;

    public CustomDialog(
            Context context,
            String title,
            String message,
            OnConfirmListener listener
    ) {
        super(context);

        this.dialogTitle = title;
        this.dialogMessage = message;
        this.confirmListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);

        TextView titleView = findViewById(R.id.customTitle);
        TextView messageView = findViewById(R.id.customMessage);
        EditText inputView = findViewById(R.id.customInput);

        Button cancelButton = findViewById(R.id.customCancel);
        Button confirmButton = findViewById(R.id.customConfirm);

        titleView.setText(dialogTitle);
        messageView.setText(dialogMessage);

        cancelButton.setOnClickListener(v -> dismiss());

        confirmButton.setOnClickListener(v -> {
            if (confirmListener != null) {
                confirmListener.onConfirm(
                        inputView.getText().toString()
                );
            }

            dismiss();
        });
    }
}
