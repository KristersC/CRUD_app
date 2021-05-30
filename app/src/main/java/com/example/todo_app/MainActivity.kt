package com.example.todo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*

/*Darbu veica Žanis Lācis un Kristers Celmiņš*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)
        val editText: EditText = findViewById(R.id.editText)
        val listView: ListView = findViewById(R.id.listView)
        val add: Button = findViewById(R.id.add)
        val delete: Button = findViewById(R.id.delete)
        val update: Button = findViewById(R.id.update)

        add.setOnClickListener {
            itemlist.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val counter = listView.count
            var task = counter - 1
            while (task >= 0) {
                if (position.get(task))
                {
                    adapter.remove(itemlist.get(task))
                }
                task--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }

        update.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val counter = listView.count
            var task = counter - 1
            while (task >= 0) {
                if (position.get(task))
                {
                    itemlist[task] = editText.text.toString()
                }
                task--
            }
            editText.text.clear()
            position.clear()
            adapter.notifyDataSetChanged()
        }

    }
}
