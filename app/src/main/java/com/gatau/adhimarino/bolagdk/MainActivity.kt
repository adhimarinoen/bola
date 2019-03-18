package com.gatau.adhimarino.bolagdk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.gatau.adhimarino.bolagdk.R.array.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = buatadapterR(this, items) {itemClicked(it)}

    }

    private fun initData(){
        val name = resources.getStringArray(namaklub)
        val image = resources.obtainTypedArray(logos)
        val description = resources.getStringArray(deskrip)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
    private fun itemClicked(items: Item){
        startActivity<tampilklub>(tampilklub.JUDUL to items.name, tampilklub.GAMBAR to items.image, tampilklub.DESKRIPSI to items.desc)
    }
}