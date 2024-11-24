import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.EmployeeRegistationFragment
import com.example.app.OilManagementFragmant
import com.example.app.OtherExFragment
import com.example.app.SalaryCalFragment
import com.example.fuelstation.R
import com.example.fuelstation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the default fragment on launch
        loadFragment(SalaryCalFragment())

        // Set up the BottomNavigationView
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.SalaryCal -> {
                    loadFragment(SalaryCalFragment())
                    true
                }
                R.id.otherexpensess -> {
                    loadFragment(OtherExFragment())
                    true
                }
                R.id.oilmanagement -> {
                    loadFragment(OilManagementFragmant())
                    true
                }
                R.id.employeeregistation -> {
                    loadFragment(EmployeeRegistationFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right,  // Enter animation
            R.anim.exit_to_left,      // Exit animation
            R.anim.enter_from_left,   // Pop Enter animation
            R.anim.exit_to_right      // Pop Exit animation
        )
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
