package com.example.deepak.contentproviderclient;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = SecondActivity.class.getSimpleName();

    ContentResolver contentResolver;

    private EditText editTextNewToDoString, editTextPlace, editTextToDoId, editTextNewToDo, editTextDeleteToDoId;
    private Button buttonAddToDo, buttonModifyToDo, buttonDeleteToDo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTextNewToDo = (EditText) findViewById(R.id.editTextNewToDo);
        editTextNewToDoString = (EditText) findViewById(R.id.editTextNewToDoString);
        editTextPlace = (EditText) findViewById(R.id.editTextPlace);
        editTextToDoId = (EditText) findViewById(R.id.editTextToDoId);
        editTextDeleteToDoId = (EditText) findViewById(R.id.editTextDeleteToDoId);

        buttonAddToDo = (Button) findViewById(R.id.buttonAddToDo);
        buttonModifyToDo = (Button) findViewById(R.id.buttonModifyToDo);
        buttonDeleteToDo = (Button) findViewById(R.id.buttonDeleteToDo);

        buttonAddToDo.setOnClickListener(this);
        buttonModifyToDo.setOnClickListener(this);
        buttonDeleteToDo.setOnClickListener(this);

        contentResolver = getContentResolver();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddToDo:
                addToDo();
                break;
            case R.id.buttonModifyToDo:
                updateToDo();
                break;
            case R.id.buttonDeleteToDo:
                deleteToDo();
                break;
            default:
                break;
        }
    }

    private void deleteToDo() {
        String todoId = editTextDeleteToDoId.getText().toString();
        contentResolver.delete(ToDoProviderClient.CONTENT_URI_1, ToDoProviderClient.COLUMN_TODO_ID + " = ?", new String[]{todoId});
        finish();
    }

    private void addToDo() {
        String todo = editTextNewToDoString.getText().toString();
        String place = editTextPlace.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoProviderClient.COLUMN_TODO, todo);
        contentValues.put(ToDoProviderClient.COLUMN_PLACE, place);

        contentResolver.insert(ToDoProviderClient.CONTENT_URI_1, contentValues);
        finish();
    }

    private void updateToDo() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDoProviderClient.COLUMN_TODO, editTextNewToDo.getText().toString());
        String whereClause = ToDoProviderClient.COLUMN_TODO_ID + " = ?";
        String[] whereValues = new String[]{editTextToDoId.getText().toString()};

        contentResolver.update(ToDoProviderClient.CONTENT_URI_1, contentValues, whereClause, whereValues);
        finish();
    }

}
