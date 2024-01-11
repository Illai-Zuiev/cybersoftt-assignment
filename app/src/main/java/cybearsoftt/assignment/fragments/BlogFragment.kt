package cybearsoftt.assignment.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cybearsoftt.assignment.App
import cybearsoftt.assignment.R
import cybearsoftt.assignment.databinding.FragmentBlogBinding
import cybearsoftt.assignment.posts.Post
import cybearsoftt.assignment.posts.PostAction
import cybearsoftt.assignment.posts.PostAdapter
import cybearsoftt.assignment.posts.PostService

class BlogFragment : Fragment(R.layout.fragment_blog) {

    private lateinit var binding: FragmentBlogBinding
    private lateinit var adapter: PostAdapter

    private val postService: PostService
        get() = (context?.applicationContext as App).postService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlogBinding.bind(view)

        adapter = PostAdapter(object : PostAction {
            override fun onPostDetail(post: Post){
                findNavController().navigate(R.id.action_blogFragment_to_detailFragment)
            }

            override fun onAddToFavorite(post: Post){
                postService.addFavoritePost(post)
            }
        })
        adapter.posts = postService.getPosts()

        val layoutManager = LinearLayoutManager(this.context)
        binding.postsViewer.layoutManager = layoutManager
        binding.postsViewer.adapter = adapter
    }


}