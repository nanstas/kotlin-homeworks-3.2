package ru.netology

data class Note(
    val noteId: Int,
    val ownerId: Int,
    val comments: MutableList<Comment>,
    val date: Long,
    val title: String,
    val text: String,
    var isDelete: Boolean = false
)