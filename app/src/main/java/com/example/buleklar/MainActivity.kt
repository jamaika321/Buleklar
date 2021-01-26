package com.example.buleklar

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ItemContent>()

        list.addAll(fillArrays(resources.getStringArray(R.array.popular),
            resources.getStringArray(R.array.popular_price),
            resources.getStringArray(R.array.popular_structure),
            getImageId(R.array.popular_image)))
        rc_view?.hasFixedSize()
        rc_view?.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rc_view?.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.man ->
            {
                Toast.makeText(this, "Man", Toast.LENGTH_SHORT).show()
                adapter?.update(fillArrays(resources.getStringArray(R.array.man),
                    resources.getStringArray(R.array.man_price),
                    resources.getStringArray(R.array.man_structure),
                    getImageId(R.array.popular_image)))
            }
            R.id.woman -> {
                Toast.makeText(this, "Woman", Toast.LENGTH_SHORT).show()
                adapter?.update(fillArrays(resources.getStringArray(R.array.woman),
                    resources.getStringArray(R.array.woman_price),
                    resources.getStringArray(R.array.woman_structure),
                    getImageId(R.array.popular_image)))
            }
            R.id.child -> {
                Toast.makeText(this, "Child", Toast.LENGTH_SHORT).show()
                adapter?.update(fillArrays(resources.getStringArray(R.array.child),
                    resources.getStringArray(R.array.child_price),
                    resources.getStringArray(R.array.child_structure),
                    getImageId(R.array.popular_image)))
            }
            R.id.popular -> {
                Toast.makeText(this, "Popular", Toast.LENGTH_SHORT).show()
                adapter?.update(fillArrays(resources.getStringArray(R.array.popular),
                    resources.getStringArray(R.array.popular_price),
                    resources.getStringArray(R.array.popular_structure),
                    getImageId(R.array.popular_image)))
            }
        }
        return true
    }

    fun fillArrays(titleArray: Array<String>, contentArray: Array<String>,
                   structureArray: Array<String>, imageArray:IntArray):ArrayList<ItemContent> {
        val listItemArray = ArrayList<ItemContent>()
        for(n in 0..titleArray.size - 1)
        {
            var listItem = ItemContent(imageArray[n],titleArray[n], contentArray[n], structureArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray
    {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }


}