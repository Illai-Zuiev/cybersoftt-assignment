package cybearsoftt.assignment.posts

import cybearsoftt.assignment.R

class PostService {
    private var posts = mutableListOf<Post>()
    private var favoritePosts = mutableListOf<Post>()

    init {
        posts = listOf(
            Post(1, "https://images.unsplash.com/photo-1600267185393-e158a98703de?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NjQ0&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800", "Information technology", "PROMO PROMO PROMO PROMO PROMO PROMO 1", "it", "description description description description description description description description 1"),
            Post(2, "https://imag.com/photo-1600267185393-e158a98703de?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NjQ0&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800", "Healthy diet", "PROMO PROMO PROMO PROMO PROMO PROMO 2", "health", "description description description description description description description description 2"),
            Post(3,  "https://images.unsplash.com/photo-1600267185393-e158a98703de?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NjQ0&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800", "Sport and health", "PROMO PROMO PROMO PROMO PROMO PROMO 3", "health", "description description description description description description description description 3")
        ).toMutableList()
    }

    fun getPosts(): List<Post> {
        return posts
    }

    fun getFavoritePosts(): List<Post> {
        return favoritePosts
    }

    fun addFavoritePost(post: Post){
        favoritePosts.add(post)
    }

    fun removeFavoritePost(post: Post){
        favoritePosts.removeIf { it.id == post.id }
    }
}