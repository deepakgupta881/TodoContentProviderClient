package com.example.deepak.contentproviderclient;

import android.net.Uri;

public interface ToDoProviderClient {

    Uri CONTENT_URI_1 = Uri.parse
            ("content://com.example.deepak.contentprovider/TODO_LIST");
    Uri CONTENT_URI_2 = Uri.parse
            ("content://com.example.deepak.contentprovider/TODO_LIST_FROM_PLACE");
    Uri CONTENT_URI_3 = Uri.parse
            ("content://com.example.deepak.contentprovider/TODOS_COUNT");

    String COLUMN_TODO_ID = "task_id";
    String COLUMN_TODO = "todo";
    String COLUMN_PLACE = "place";
}
