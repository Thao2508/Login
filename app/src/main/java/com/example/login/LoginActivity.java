package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Thiết lập lắng nghe sự kiện WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lấy các view từ layout
        EditText usernameInput = findViewById(R.id.inputUserName);
        EditText passwordInput = findViewById(R.id.inputPassword);
        Button loginButton = findViewById(R.id.btn_login);
        TextView displayInfo = findViewById(R.id.login_display_info);

        // Xử lý sự kiện khi nhấn vào TextView "alreadyHaveAccount"
        TextView signupButton = findViewById(R.id.text_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển màn hình qua RegisterLayout khi người dùng nhấn vào nút
                Intent intent = new Intent(LoginActivity.this, RegisterLayout.class);
                startActivity(intent);
            }
        });

        // Lắng nghe sự kiện click của nút login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin username và password từ các trường nhập liệu
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Hiển thị thông tin trong TextView
                displayInfo.setText("Username: " + username + "\nPassword: " + password);
            }
        });
    }
}
