import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hashinology.tg_quran.OnItemClick
import com.hashinology.tg_quran.adapter.SuraDetailsAdapter
import com.hashinology.tg_quran.adapter.SurahAdapter
import com.hashinology.tg_quran.constants.SurahData
import com.hashinology.tg_quran.constants.SurahNames
import com.hashinology.tg_quran.databinding.FragmentSurahBinding
import com.hashinology.tg_quran.ui.SurahDetailsActivity

class SurahFragment : Fragment() {
    lateinit var viewBinding: FragmentSurahBinding
    lateinit var surahAdapter: SurahAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSurahBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        surahAdapter = SurahAdapter(SurahNames.ArSuras.mapIndexed { position, name ->
            SurahData(name, position + 1)
        })
        /* val list = SurahAdapter(SurahNames.ArSuras.mapIndexed{ position, name ->
             SurahData(name,position +1)
         })
         Log.d("TAG", list.toString())*/
        viewBinding.rvSurahList.adapter = surahAdapter
        surahAdapter.onItemClick = object : OnItemClick {
            override fun onItemClickListner(surahData: SurahData) {
                val intent = Intent(requireActivity(), SurahDetailsActivity::class.java)
                intent.putExtra("sura_name", surahData)
                intent.putExtra("sura_number", surahData)
                startActivity(intent)
            }
        }
    }
}