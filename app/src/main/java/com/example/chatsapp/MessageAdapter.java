package com.example.chatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Message> messages;
    private static final int SENT_MESSAGE = 0;
    private static final int RECEIVED_MESSAGE = 1;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    public static class SentMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView messageBody;

        public SentMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageBody = itemView.findViewById(R.id.text_message_body);
        }

        public void bind(Message message) {
            messageBody.setText(message.getText());
        }
    }

    public static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView messageBody;

        public ReceivedMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageBody = itemView.findViewById(R.id.text_message_body);
        }

        public void bind(Message message) {
            messageBody.setText(message.getText());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SENT_MESSAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_sent, parent, false);
            return new SentMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_received, parent, false);
            return new ReceivedMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if (getItemViewType(position) == SENT_MESSAGE) {
            ((SentMessageViewHolder) holder).bind(message);
        } else {
            ((ReceivedMessageViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).isSent()) {
            return SENT_MESSAGE;
        } else {
            return RECEIVED_MESSAGE;
        }
    }
}
