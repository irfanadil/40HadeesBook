package muhammad.renowned.saying.listinghadees.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import muhammad.renowned.saying.listinghadees.model.SayingIndexModel
import muhammad.renowned.saying.databinding.ItemListContentBinding

class IndexListAdapter
internal constructor(
    onAdapterClickListener: DuaClickAdapter
) : RecyclerView.Adapter<IndexListAdapter.SimpleQuoteViewHolder>() {

    private var classScopedItemClickListener: DuaClickAdapter = onAdapterClickListener
    private var passedList: List<SayingIndexModel> = listOf()

    init {
        this.classScopedItemClickListener = onAdapterClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleQuoteViewHolder {
        val binding =
            ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpleQuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimpleQuoteViewHolder, position: Int) {
        val currentItem = passedList[position]
        holder.duaLevel.text = currentItem.hadeesTitle
        holder.duaDay.text = currentItem.duaDayCount
        holder.itemLayout.setOnClickListener {
            classScopedItemClickListener.duaItemClicked(currentItem)
        }
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
    fun updateInsideAdapter(itemList: List<SayingIndexModel>) {
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
    fun duaItemClicked(duaTitleModel: SayingIndexModel)
    fun deleteUrlEvent(duaTitleModel: SayingIndexModel)
}