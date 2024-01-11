package cybearsoftt.assignment.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import cybearsoftt.assignment.R
import cybearsoftt.assignment.databinding.FragmentSignInBinding


class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)

        binding.signInButton.setOnClickListener {
            if (binding.signInEmail.text.toString().isEmpty() || binding.signInPassword.text.toString().isEmpty()) {
                Toast.makeText(it.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.signInEmail.text.toString(), binding.signInPassword.text.toString())
                    .addOnCompleteListener(fun(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            findNavController().navigate(R.id.action_signInFragment_to_tabsFragment)
                        } else {
                            Toast.makeText(it.context, "Password or Email is wrong", Toast.LENGTH_SHORT).show()
                        }
                    })
            }

        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
}