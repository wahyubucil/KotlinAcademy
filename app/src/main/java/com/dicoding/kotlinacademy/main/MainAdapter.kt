package com.dicoding.kotlinacademy.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.dicoding.kotlinacademy.R
import com.dicoding.kotlinacademy.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class MainAdapter(private val teams: List<Team>) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }

}

class TeamUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.HORIZONTAL
                padding = dip(16)

                imageView {
                    id = R.id.team_badge
                }.lparams {
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }
            }
        }
    }

}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    fun bindItem(team: Team) {
        Picasso.get().load(team.teamBadge).into(teamBadge)
        teamName.text = team.teamName
    }
}