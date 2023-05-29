package muhammad.fourty.saying.listinghadees.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import muhammad.fourty.saying.databinding.ItemListContentBinding
import muhammad.fourty.saying.listinghadees.model.DuaModel


class BookListAdapter
internal constructor(
    onAdapterClickListener: DuaClickAdapter
) : RecyclerView.Adapter<BookListAdapter.SimpleQuoteViewHolder>() {

    private var classScopedItemClickListener: DuaClickAdapter = onAdapterClickListener
    private var passedList:List<DuaModel> = listOf()
    init {
        this.classScopedItemClickListener = onAdapterClickListener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleQuoteViewHolder {
        val binding =
            ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpleQuoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: SimpleQuoteViewHolder, position: Int) {

        //val currentItem = differ.currentList[position]
        val currentItem = passedList[position]

        val str  = "پہلی منزل  محمدﷺ" //currentItem.duaTitle //  "پہلی منزل  محمد ﷺ"
        val wordToSpan: Spannable = SpannableString(str)
        wordToSpan.setSpan(
            ForegroundColorSpan(Color.GREEN),
            10,
            str.length-1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        holder.duaLevel.text = wordToSpan


        holder.duaDay.text = currentItem.duaDayCount

        holder.itemLayout.setOnClickListener {
            classScopedItemClickListener.duaItemClicked(currentItem)
        }

        //holder.deleteBtn.setOnClickListener {
           // classScopedItemClickListener.deleteUrlEvent(currentItem)
        //}
    }



    inner class SimpleQuoteViewHolder(binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemLayout: ConstraintLayout = binding.itemLayout
        val duaLevel: TextView = binding.authorNameText
        val duaDay: TextView = binding.authorQuote
        //val deleteBtn: ImageView = binding.delIcon
        //val editBtn: ImageView = binding.editIcon


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateInsideAdapter(itemList: List<DuaModel>){
        this.passedList = itemList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        //return differ.currentList.size
        return passedList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}

interface DuaClickAdapter {
    fun duaItemClicked(duaTitleModel: DuaModel)
    fun deleteUrlEvent(duaTitleModel: DuaModel)
}