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
import cybearsoftt.assignment.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

        binding.signUpButton.setOnClickListener {
            if (binding.signUpEmail.text.toString().isEmpty() || binding.signUpPassword.text.toString().isEmpty()) {
                Toast.makeText(it.context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.signUpEmail.text.toString(), binding.signUpPassword.text.toString())
                    .addOnCompleteListener(fun(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            findNavController().popBackStack()
                        } else {
                            Toast.makeText(it.context, "User with this email is exist", Toast.LENGTH_SHORT).show()
                        }
                    })
            }

        }
        binding.signUpBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}