package vcmsa.ci.personalfinancetracker

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var incomeAmount:EditText
    lateinit var Expense1:EditText
    lateinit var Expense2: EditText
    lateinit var Expense3:EditText
    lateinit var Expense4:EditText
    lateinit var ExpenseAmount1:EditText
    lateinit var ExpenseAmount2:EditText
    lateinit var ExpenseAmount3:EditText
    lateinit var ExpenseAmount4:EditText
    lateinit var btnCalcBal:Button
    lateinit var tvIncome:TextView
    lateinit var tvExpense:TextView
    lateinit var BalanceDisplay:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

      incomeAmount = findViewById(R.id.IncomeAmount)
        Expense1 = findViewById(R.id.Expense1)
        Expense2 = findViewById(R.id.Expense2)
        Expense3 = findViewById(R.id.Expense3)
        Expense4 = findViewById(R.id.Expense4)
        ExpenseAmount1 = findViewById(R.id.ExpenseAmount1)
        ExpenseAmount2 = findViewById(R.id.ExpenseAmount2)
        ExpenseAmount3 = findViewById(R.id.ExpenseAmount3)
        ExpenseAmount4 = findViewById(R.id.ExpenseAmount4)
        btnCalcBal = findViewById(R.id.btnCalcBal)
        tvIncome = findViewById(R.id.tvIncome)
        tvExpense = findViewById(R.id.tvExpenses)
        BalanceDisplay = findViewById(R.id.BalanceDisplay)

        btnCalcBal.setOnClickListener{Balance()}
    }
private fun Balance()
{
    val TotalIncome = incomeAmount.text.toString().toFloat()

val Expense1 = Expense1.text.toString()
    val Expense2 = Expense2.text.toString()
    val Expense3 = Expense3.text.toString()
    val Expense4 = Expense4.text.toString()
    val ExpenseAmount1 = ExpenseAmount1.text.toString().toFloat()
    val ExpenseAmount2 = ExpenseAmount2.text.toString().toFloat()
    val ExpenseAmount3 = ExpenseAmount3.text.toString().toFloat()
    val ExpenseAmount4 = ExpenseAmount4.text.toString().toFloat()

    val TotalExpense = ExpenseAmount1 + ExpenseAmount2 + ExpenseAmount3 + ExpenseAmount4

    tvIncome.text = "Total Income: $TotalIncome"

    tvExpense.text = ("$Expense1, : $ExpenseAmount1,\n $Expense2, : $ExpenseAmount2, \n $Expense3 : $ExpenseAmount3, \n $Expense4, : $ExpenseAmount4 " )



    val expensePercentage = (TotalExpense / TotalIncome) * 100
    if (expensePercentage > 30) {
        tvExpense.text = "Warning: Your expenses are too high! Consider cutting back."
         tvExpense.setTextColor(Color.RED)  // Change the text color to red
    } else if (expensePercentage < 5) {
        tvExpense.text = "Great! You're keeping expenses low."
        tvExpense.setTextColor(Color.GREEN)  // Change the text color to green
    } else {
        tvExpense.text = "Your expenses are within a reasonable range."
        tvExpense.setTextColor(Color.BLACK)  // Default text color
    }

val BalanceAmount = TotalIncome - TotalExpense

    BalanceDisplay.text = "Balance: $BalanceAmount"

    if(BalanceAmount > 0.00 )
    {
        BalanceDisplay.text = "You are saving, congratulations!"
    }else
        BalanceDisplay.text = "You are in Debt"

}

}