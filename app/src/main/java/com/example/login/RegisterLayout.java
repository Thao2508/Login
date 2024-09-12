package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);

        // Lấy các view từ layout
        EditText usernameInput = findViewById(R.id.inputUserName);
        EditText passwordInput = findViewById(R.id.editTextText3);
        Button registerButton = findViewById(R.id.btn_register);
        TextView displayInfo = findViewById(R.id.display_info);
        TextView alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);

        // Lắng nghe sự kiện click của nút register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin username và password từ các trường nhập liệu
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Hiển thị thông tin trong TextView
                displayInfo.setText("Username: " + username + "\nPassword: " + password);
            }
        });

        // Lắng nghe sự kiện click của alreadyHaveAccount
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển màn hình qua LoginActivity khi người dùng nhấn vào nút alreadyHaveAccount
                Intent intent = new Intent(RegisterLayout.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
