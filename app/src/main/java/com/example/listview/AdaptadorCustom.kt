package com.example.listview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AdaptadorCustom(var context:Context, items:ArrayList<Fruta>):BaseAdapter() {
    var items:ArrayList<Fruta>? = null
    init {
        this.items = items
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var holder: ViewHolder? = null

        var vista: View? = p1
        if ( vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template,null)
            holder = ViewHolder(vista)
            vista.tag = holder

        }
        else{
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(p0) as Fruta
        var color:Int = 0;
        if (p0%2 == 0) color = Color.parseColor("#ffffff") else color = Color.parseColor("#aaaaaa")
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)
        holder?.linearLayout?.setBackgroundColor(color)
        holder?.boton?.setOnClickListener {view ->
            Toast.makeText(context, item.nombre, Toast.LENGTH_LONG).show()
        }

        return vista!!
    }

    override fun getItem(p0: Int): Any {
        return items?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(vista:View){
        var nombre:TextView? = null
        var imagen:ImageView? = null
        var linearLayout:LinearLayout? = null
        var boton:Button? = null
        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
            linearLayout = vista.findViewById(R.id.linearLayout)
            boton = vista.findViewById(R.id.button)
        }
    }
}