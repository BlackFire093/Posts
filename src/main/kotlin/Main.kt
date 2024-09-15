package ru.netology

fun main () {
    val likes = Likes (100)
    WallService.add(Post(1, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, likes))
    WallService.printPosts()
}

data class Post ( val id: Int = 0, val Text: String, val can_pin: Boolean, val can_delete: Boolean, val can_edit: Boolean, val post_type: String, val is_pinned: Int, val is_favorite: Boolean, val likes: Likes = Likes())
data class Likes (val count: Int = 0)

object WallService {

    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun printPosts() {
        for (post in posts) {
            print (post)
            print(" ")
        }
        println()
    }
}