import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.expenses.expenses.tracking.Card
import com.example.expenses.expenses.tracking.fragment.AddCardAdapterFragment
import com.example.expenses.expenses.tracking.fragment.CardAdapterFragment

class CardPagerAdapter(
    fragmentManager: FragmentManager,
    private val cardsList: List<Card>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var listIsEmpty = false

    override fun getCount(): Int {
        if (cardsList.isEmpty()) {
            listIsEmpty = true
            return cardsList.size + 1
        }
        return cardsList.size
    }

    override fun getItem(position: Int): Fragment {
        return if (listIsEmpty or cardsList[position].isValuesNull()) {
            AddCardAdapterFragment.newInstance()
        } else {
            CardAdapterFragment.newInstance(cardsList[position])


        }
    }
}