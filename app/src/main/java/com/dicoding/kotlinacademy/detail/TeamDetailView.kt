package com.dicoding.kotlinacademy.detail

import com.dicoding.kotlinacademy.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}