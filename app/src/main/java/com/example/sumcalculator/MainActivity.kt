package com.example.sumcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sumcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentInput = "" // başlangıç sayısı
    private var storedValue = 0.0 // Önceki değer.
    private var operation: String? = null // İşlem tipi (+, -, vs.)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            val alinan0 = binding.button0.text.toString()
            binding.textViewSonuc.text = alinan0
            appendNumberToInput("0")
        }
        binding.button1.setOnClickListener {
            val alinan1 = binding.button1.text.toString()
            binding.textViewSonuc.text = alinan1
            appendNumberToInput("1")
        }
        binding.button2.setOnClickListener {
            val alinan2 = binding.button2.text.toString()
            binding.textViewSonuc.text = alinan2
            appendNumberToInput("2")
        }
        binding.button3.setOnClickListener {
            val alinan3 = binding.button3.text.toString()
            binding.textViewSonuc.text = alinan3
            appendNumberToInput("3")
        }
        binding.button4.setOnClickListener {
            val alinan4 = binding.button4.text.toString()
            binding.textViewSonuc.text = alinan4
            appendNumberToInput("4")
        }
        binding.button5.setOnClickListener {
            val alinan5 = binding.button5.text.toString()
            binding.textViewSonuc.text = alinan5
            appendNumberToInput("5")
        }
        binding.button6.setOnClickListener {
            val alinan6 = binding.button6.text.toString()
            binding.textViewSonuc.text = alinan6
            appendNumberToInput("6")
        }
        binding.button7.setOnClickListener {
            val alinan7 = binding.button7.text.toString()
            binding.textViewSonuc.text = alinan7
            appendNumberToInput("7")
        }
        binding.button8.setOnClickListener {
            val alinan8 = binding.button8.text.toString()
            binding.textViewSonuc.text = alinan8
            appendNumberToInput("8")
        }
        binding.button9.setOnClickListener {
            val alinan9 = binding.button9.text.toString()
            binding.textViewSonuc.text = alinan9
            appendNumberToInput("9")
        }

        binding.buttonAC.setOnClickListener {
            currentInput = ""
            storedValue = 0.0
            operation = null
            binding.textViewSonuc.text = "0"
        }

        binding.buttonPlus.setOnClickListener {
            performOperation("+")
        }

        binding.buttonEquals.setOnClickListener {
            if (operation != null && currentInput.isNotEmpty()) {
                val currentNumber = currentInput.toDouble()
                storedValue = when (operation) {
                    "+" -> storedValue + currentNumber
                    else -> storedValue
                }
                binding.textViewSonuc.text = storedValue.toString()
                currentInput = "" // Yeni işlem için input sıfırlanır.
                operation = null
            }
        }
    }

    private fun performOperation(selectedOperation: String) {
        if (currentInput.isNotEmpty()) {
            val currentNumber = currentInput.toDouble()
            storedValue = if (operation == null) {
                currentNumber
            } else {
                when (operation) {
                    "+" -> storedValue + currentNumber
                    "*" -> storedValue * currentNumber
                    else -> storedValue
                }
            }
            operation = selectedOperation
            currentInput = "" // Yeni sayı girişi için sıfırlanır.
            binding.textViewSonuc.text = storedValue.toString()
        }
    }

    private fun appendNumberToInput(number: String) {
        currentInput += number // Yeni rakamı mevcut girişe ekle
        binding.textViewSonuc.text = currentInput // Güncellenen sayıyı göster
    }


}