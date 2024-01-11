package cybearsoftt.assignment

import android.app.Application
import cybearsoftt.assignment.posts.PostService

class App : Application() {

    val postService = PostService()
}