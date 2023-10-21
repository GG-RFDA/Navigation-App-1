package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Объявляем четыре объекта класса EditText
    private EditText editName, editEmail, editPassword, editSecondPassword;
    // Объявляем четыре строковых переменных
    private String name, email, password, secondPassword;

    // Переопределяем метод onCreate() класса AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Осуществляем вызов метода onCreate() родительского класса
        super.onCreate(savedInstanceState);
        // Производим установку макета activity_main для данной активности
        setContentView(R.layout.activity_main);
        // Производим инициализацию объектов, найденных по идентификаторам R.id.
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editSecondPassword = findViewById(R.id.editSecondPassword);
        // Инициализируем объект buttonRegister, найденный по идентификатору R.id.buttonRegister
        Button buttonRegister = findViewById(R.id.buttonRegister);
        // Устанавливаем слушатель события на кнопку buttonRegister
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            // Переопределяем метод onClick() интерфейса OnClickListener
            @Override
            public void onClick(View view) {
                // Получаем текст из объектов и присваиваем их переменным
                name = editName.getText().toString();
                email = editEmail.getText().toString();
                password = editPassword.getText().toString();
                secondPassword = editSecondPassword.getText().toString();
                // Производим проверку на заполненность всех полей
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || secondPassword.isEmpty()) {
                    // Выводим сообщение с предупреждениями в виде всплывающего уведомления
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                // Производим проверку на совпадение паролей
                } else if (!password.equals(secondPassword)) {
                    // Выводим сообщение об ошибке в виде всплывающего уведомления
                    Toast.makeText(MainActivity.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                } else {
                    // Создаём объект Intent для перехода на активность CatalogActivity
                    Intent intent = new Intent(MainActivity.this, CatalogActivity.class);
                    // Запускаем активность CatalogActivity
                    startActivity(intent);
                }
            }
        });
    }
}