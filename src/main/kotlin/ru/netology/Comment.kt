package ru.netology

data class Comment(
    val commentId: Int,
    val commentOwnerId: Int,
    val noteId: Int,
    val noteOwnerId: Int,
    val date: Long,
    val message: String,
    var isDelete: Boolean = false
)

//id — идентификатор комментария;
//uid — идентификатор автора комментария;
//nid — идентификатор заметки;
//oid — идентификатор владельца заметки;
//date — дата добавления комментария в формате unixtime;
//message — текст комментария;
//reply_to — идентификатор пользователя, в ответ на комментарий которого был оставлен текущий комментарий (если доступно).