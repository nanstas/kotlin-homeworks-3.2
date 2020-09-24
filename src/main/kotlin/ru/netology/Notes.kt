package ru.netology

class Notes {
    private val notes = mutableMapOf<Note, MutableList<Comment>>()
    private var noteId = 0
    private var commentId = 0

    fun add(title: String, text: String): Int {
        noteId += 1
        val note = Note(title = title, text = text, noteId = noteId)
        notes.put(note, mutableListOf())
        return note.noteId
    }

    fun createComment(noteId: Int, message: String): Int {
        for (note in notes.keys) {
            if (note.noteId == noteId) {
                commentId += 1
                val comment = Comment(commentId = commentId, noteId = noteId, message = message)
                notes.get(note)?.add(comment)
                return comment.noteId
            }
        }
        return 0
    }

    fun delete(noteId: Int): Boolean {
        for (note in notes.keys) {
            if (note.noteId == noteId) {
                note.isDelete = true
                return true
            }
        }
        return false
    }

    fun deleteComment(commentId: Int): Boolean {
        for (note in notes) {
            for (comment in note.value) {
                if (comment.commentId == commentId) {
                    comment.isDelete = true
                    return true
                }
            }
        }
        return false
    }

    fun edit(noteId: Int, title: String, text: String): Boolean {
        for (note in notes.keys) {
            if (note.noteId == noteId) {
                val editNote = note.copy(title = title, text = text)
                val comments = notes.get(note)
                notes.remove(note)
                if (comments != null) {
                    notes.put(editNote, comments)
                } else {
                    notes.put(editNote, mutableListOf())
                }
                return true
            }
        }
        return true
    }

    fun editComment(commentId: Int, message: String): Boolean {
        for (note in notes) {
            for (comment in note.value) {
                if (comment.commentId == commentId) {
                    val editComment = comment.copy(message = message)
                    note.value.remove(comment)
                    note.value.add(editComment)
                    return true
                }
            }
        }
        return false
    }

//    fun get(noteIds: List<Int>?, userId: Int, count: Int = 20, sort: Int = 0) {
//
//    }
//
//    fun getById(noteId: Int, needWiki: Int = 0): Note {
//
//    }
//
//    fun getComments(noteId: Int, sort: Int = 0, count: Int = 20): List<Comment> {
//
//    }
//
//    fun restoreComment(commentId: Int): Boolean {
//
//    }

    val time: Long = System.currentTimeMillis()

    fun printNotes() {
        for (note in notes) {
            println(note.key)
            for (comment in note.value) {
                println(comment)
            }
            println()
        }
    }
}