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
    //Declaration of variables
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
//Prompts to find the relative inputs by their assigned IDs
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

        //setOnClickListener to execute the balancing function
        btnCalcBal.setOnClickListener{Balance()}
    }
private fun Balance()//executes Calculate Balance Function
{

    val incomeInput = incomeAmount.text.toString()

    if (incomeInput.isEmpty() || incomeInput.toFloatOrNull() == null) {

        tvIncome.text = "Invalid input"//error handling for mis-input information
    }
    val TotalIncome = incomeInput.toFloat()


val Expense1 = Expense1.text.toString()
    if(Expense1.isEmpty()){
        tvExpense.text = "Insert missing Input"
    }
    val Expense2 = Expense2.text.toString()
    if(Expense2.isEmpty()){
        tvExpense.text = "Insert missing Input"
    }
    val Expense3 = Expense3.text.toString()
    if(Expense3.isEmpty()){
        tvExpense.text = "Insert missing Input"
    }
    val Expense4 = Expense4.text.toString()
    if(Expense4.isEmpty()){
        tvExpense.text = "Insert missing Input"
    }
    val ExpenseAmount1 = ExpenseAmount1.text.toString().toFloat()
    val ExpenseAmount2 = ExpenseAmount2.text.toString().toFloat()
    val ExpenseAmount3 = ExpenseAmount3.text.toString().toFloat()
    val ExpenseAmount4 = ExpenseAmount4.text.toString().toFloat()

    //sum of the Expense to obtain the total expense
    val TotalExpense = ExpenseAmount1 + ExpenseAmount2 + ExpenseAmount3 + ExpenseAmount4

    tvIncome.text = "Total Income: $TotalIncome"

    //compiles the list Expenses and their amounts under one value to be projected as a string
    val ExpensesList= StringBuilder("$Expense1 : $ExpenseAmount1 \n $Expense2 : $ExpenseAmount2 \n $Expense3 : $ExpenseAmount3 \n $Expense4 : $ExpenseAmount4 " )

//Checks the Expense percentage and displays a message depending on its range
    val expensePercentage = (TotalExpense / TotalIncome) * 100
    if (expensePercentage > 60) {
        tvExpense.text = "$ExpensesList \n Total:Expenses: $TotalExpense \n Warning: Your expenses are too high! Consider cutting back."
         tvExpense.setTextColor(Color.RED)  // Changes the text color to red
    } else if (expensePercentage < 10) {
        tvExpense.text = "$ExpensesList \n Total:Expenses: $TotalExpense \n Great! You're keeping expenses low."
        tvExpense.setTextColor(Color.GREEN)  // Change the text color to green
    } else {
        tvExpense.text = " $ExpensesList \n Total:Expenses: $TotalExpense \n Your expenses are within a reasonable range."
        tvExpense.setTextColor(Color.BLACK)  // Default text color
    }


    //calculates balance amount by the difference of the total income and the total expense
val BalanceAmount = TotalIncome - TotalExpense

    BalanceDisplay.text = "Balance: $BalanceAmount"

    //Checks if the Balance is a positive or negative value
    if(BalanceAmount >=  0.00 )
    {
        BalanceDisplay.text = "You are saving, congratulations!"
    }else
        BalanceDisplay.text = "You are in debt"

}

}