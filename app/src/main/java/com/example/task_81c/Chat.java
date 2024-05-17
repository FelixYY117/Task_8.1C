package com.example.task_81c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    private EditText editTextUserInput;
    private ImageButton sendButton;
    private RecyclerView chatMessagesRecyclerView;
    private Adapter adapter;
    List<Entry> chatHistory = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        editTextUserInput = findViewById(R.id.UserInput);
        chatMessagesRecyclerView = findViewById(R.id.RecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        chatMessagesRecyclerView.setLayoutManager(layoutManager);

        // Initialize the adapter
        adapter = new Adapter(this, chatHistory);
        // Set the adapter to the RecyclerView
        chatMessagesRecyclerView.setAdapter(adapter);

        sendButton = findViewById(R.id.Send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextUserInput.getText().toString().trim();
                if (!TextUtils.isEmpty(userInput)) {
                    sendMessageToApi(userInput);

                    editTextUserInput.setText(""); // Clear the input field
                }
            }
        });
    }
    private void sendMessageToApi(String userMessage) {
       Request request = new Request(userMessage, chatHistory);
        Service apiService =RetrofitApi.getClient();
        Call<Response> call = apiService.sendMessage(request);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.isSuccessful()) {
                    Response apiResponse = response.body();
                    String message = apiResponse.getMessage();
                    chatHistory.add(new Entry(userMessage, message));
                    adapter.notifyDataSetChanged();
                } else {

                    try {
                        String errorBody = response.errorBody().string();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(Chat.this, "Error !.", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}
