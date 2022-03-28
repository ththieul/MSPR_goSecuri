package fr.epsi.gosecuri

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.app_name))

        val agents = arrayListOf<Agent>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAgents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val agentAdapter = AgentAdapter(agents)
        recyclerView.adapter = agentAdapter

        Thread(Runnable {
            try {
                val doc: Document = Jsoup.connect("https://4cca-2001-861-52-e230-a00-27ff-fed6-37ed.ngrok.io/gosecuri.fr/").get()
                val articles: Elements = doc.select("article.leaderboard__profile")

                for (article in articles) {
                    val agentUsername = article.select("img").attr("alt")
                    val fullName = article.select("a[href]").text()
                    val agent = Agent(agentUsername, fullName,
                        "https://4cca-2001-861-52-e230-a00-27ff-fed6-37ed.ngrok.io/gosecuri.fr/users/$agentUsername.html"
                    )
                    agents.add(agent)
                }
            } catch (e: IOException) {
                Toast.makeText(application, e.message, Toast.LENGTH_LONG).show()
            }
            runOnUiThread {
                agentAdapter.notifyDataSetChanged()
            }
        }).start()
    }
}