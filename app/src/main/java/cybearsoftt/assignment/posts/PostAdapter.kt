package cybearsoftt.assignment.posts;

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cybearsoftt.assignment.R
import cybearsoftt.assignment.databinding.PostViewBinding;

interface PostAction {

    fun onPostDetail(post: Post)

    fun onAddToFavorite(post: Post)

}

class PostAdapter(
    private val postAction: PostAction
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    var posts: List<Post> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostViewBinding.inflate(inflater, parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        with(holder.binding) {
            pTitle.text = post.title
            pPromo.text = post.promo
            Glide.with(pImage.context)
                .load(post.image)
                .error(R.drawable.ic_blog)
                .into(pImage)

            pAddToFavoriteButton.setOnClickListener{
                postAction.onPostDetail(post)
            }

            root.setOnClickListener{
                postAction.onAddToFavorite(post)
            }
        }
    }

    class PostViewHolder(
        val binding: PostViewBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
