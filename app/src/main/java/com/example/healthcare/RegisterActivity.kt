package com.example.healthcare

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.healthcare.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupRealTimeValidation()
        setupRegisterButton()
    }

    private fun setupSpinner() {
        // 4. Spinner for Blood Type
        val bloodTypes = arrayOf("A", "B", "AB", "O")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bloodTypes)
        binding.spinnerBloodType.adapter = adapter
    }

    private fun setupRealTimeValidation() {
        // 2. Real-time validation
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateForm(false)
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        binding.etName.addTextChangedListener(textWatcher)
        binding.etEmail.addTextChangedListener(textWatcher)
        binding.etPassword.addTextChangedListener(textWatcher)
        binding.etConfirmPassword.addTextChangedListener(textWatcher)
    }

    private fun setupRegisterButton() {
        // 5. Gesture Interaction - Long Press to Clear Form
        binding.btnRegister.setOnLongClickListener {
            clearForm()
            true
        }

        binding.btnRegister.setOnClickListener {
            if (validateForm(true)) {
                showConfirmationDialog()
            }
        }
    }

    private fun clearForm() {
        // 1. Clear EditTexts
        binding.etName.text?.clear()
        binding.etEmail.text?.clear()
        binding.etPassword.text?.clear()
        binding.etConfirmPassword.text?.clear()

        // 2. Clear TextInputLayout Errors
        binding.tilName.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilConfirmPassword.error = null

        // 3. Clear RadioGroup (Gender)
        binding.rgGender.clearCheck()

        // 4. Clear CheckBoxes (Hobbies)
        binding.cbRunning.isChecked = false
        binding.cbCycling.isChecked = false
        binding.cbYoga.isChecked = false
        binding.cbGym.isChecked = false
        binding.cbCooking.isChecked = false

        // 5. Reset Spinner
        binding.spinnerBloodType.setSelection(0)

        // 6. Visual/Haptic Feedback
        binding.btnRegister.performHapticFeedback(android.view.HapticFeedbackConstants.LONG_PRESS)
        Toast.makeText(this, "Form telah dibersihkan", Toast.LENGTH_SHORT).show()
        
        // Focus back to name
        binding.etName.requestFocus()
    }

    private fun validateForm(showAllErrors: Boolean): Boolean {
        var isValid = true

        // Name Validation
        val name = binding.etName.text.toString().trim()
        if (name.isEmpty()) {
            if (showAllErrors) binding.tilName.error = getString(R.string.error_empty)
            isValid = false
        } else {
            binding.tilName.error = null
        }

        // Email Validation
        val email = binding.etEmail.text.toString().trim()
        if (email.isEmpty()) {
            if (showAllErrors) binding.tilEmail.error = getString(R.string.error_empty)
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = getString(R.string.error_email)
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        // Password Validation
        val password = binding.etPassword.text.toString()
        if (password.isEmpty()) {
            if (showAllErrors) binding.tilPassword.error = getString(R.string.error_empty)
            isValid = false
        } else if (password.length < 6) {
            binding.tilPassword.error = getString(R.string.error_password_length)
            isValid = false
        } else {
            binding.tilPassword.error = null
        }

        // Confirm Password Validation
        val confirmPassword = binding.etConfirmPassword.text.toString()
        if (confirmPassword != password) {
            binding.tilConfirmPassword.error = getString(R.string.error_password_match)
            isValid = false
        } else {
            binding.tilConfirmPassword.error = null
        }

        if (!showAllErrors) return isValid

        // 3. Selection Controls Validation (Gender)
        if (binding.rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, getString(R.string.error_gender), Toast.LENGTH_SHORT).show()
            isValid = false
        }

        // 3. Selection Controls Validation (Hobbies min 3)
        val selectedHobbiesCount = listOf(
            binding.cbRunning, binding.cbCycling, binding.cbYoga,
            binding.cbGym, binding.cbCooking
        ).count { it.isChecked }

        if (selectedHobbiesCount < 3) {
            Toast.makeText(this, getString(R.string.error_hobbies), Toast.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }

    private fun showConfirmationDialog() {
        // 4. Spinner & Dialog
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.reg_confirm_title))
            .setMessage(getString(R.string.reg_confirm_msg))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                Toast.makeText(this, getString(R.string.reg_success), Toast.LENGTH_SHORT).show()
                finish()
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }
}