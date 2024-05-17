package com.example.task_81c;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.MessageViewHolder> {
    private List<Entry> chatHistory;
    private Context context;

    public Adapter(Context context, List<Entry> chatHistory) {
        this.context = context;
        this.chatHistory = chatHistory;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Entry Entry = chatHistory.get(position);
        holder.bind(Entry);
    }

    @Override
    public int getItemCount() {
        return chatHistory.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewU;
        private TextView textViewUserQuestion;
        private ImageView imageViewAi2;
        private TextView textViewWAiRespond;
        private LinearLayout messageContainer;

    }
    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        User = itemView.findViewById(R.id.User);
        textViewUserQuestion = itemView.findViewById(R.id.UserQuestion);
        imageViewAi2 = itemView.findViewById(R.id.imageViewAi2);
        textViewWAiRespond = itemView.findViewById(R.id.AiRespond);
    }
    public void bind(Entry chatEntry) {
        textViewUserQuestion.setText(chatEntry.getUser());
        textViewWAiRespond.setText(chatEntry.getLlama());
    }
}


