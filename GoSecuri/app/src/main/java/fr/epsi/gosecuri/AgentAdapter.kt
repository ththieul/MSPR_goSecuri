package fr.epsi.gosecuri

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AgentAdapter(val agents: ArrayList<Agent>):RecyclerView.Adapter<AgentAdapter.ViewHolder>() {

    class ViewHolder(private val context: Context, view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener{
        val imageViewAgent = view.findViewById<ImageView>(R.id.imageViewAgent)
        val nameAgent = view.findViewById<TextView>(R.id.textViewName)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)

        var agent: Agent? = null

        init {
            contentLayout.setOnClickListener(this)
        }

        fun getResources(): Resources {
            return context.resources
        }

        fun getPackageName(): String {
            return context.packageName
        }

        override fun onClick(text: View?) {
            val newIntent = Intent(Intent.ACTION_VIEW, Uri.parse(agent?.accountUrl))
            startActivity(context, newIntent, null)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_agent, viewGroup, false)
        return ViewHolder(viewGroup.context, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val agent = agents[position]
        val resources = holder.getResources()
        val resourceId: Int = resources.getIdentifier(agent.userName, "drawable", holder.getPackageName())
        holder.nameAgent.text = agent.fullName
        holder.imageViewAgent.setImageResource(resourceId)
        holder.agent = agent
    }

    override fun getItemCount(): Int {
        return agents.size
    }
}