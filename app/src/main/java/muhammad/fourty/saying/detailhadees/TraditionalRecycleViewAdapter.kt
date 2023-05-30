package muhammad.fourty.saying.detailhadees

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import muhammad.fourty.saying.databinding.HadeesDetailHolderBinding
import muhammad.fourty.saying.util.StringPatternMatching


class TraditionalRecycleViewAdapter (val context:Context) : RecyclerView.Adapter<TraditionalRecycleViewAdapter.ViewHolder>() {

    // Array of images
    // Adding images from drawable folder



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            HadeesDetailHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

     // The ViewHolder class holds the view
    class ViewHolder(binding: HadeesDetailHolderBinding) :RecyclerView.ViewHolder(binding.root) {
        var sayingTextView: TextView = binding.sayingTextView
    }







    // This method returns our layout
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.images_holder, parent, false)
        return ViewHolder(view)
    }*/

    // This method binds the screen with the view
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val textGiven = passedList[position]
        //val viewWidthToBitmapWidthRatio = image.getWidth() as Double / bitmap.getWidth() as Double
       // image.getLayoutParams().height = (bitmap.getHeight() * viewWidthToBitmapWidthRatio)

        //val screenWidth = DeviceDimensionsHelper.getDisplayWidth(this)
        // Resize a Bitmap maintaining aspect ratio based on screen width

        //val icon: Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_resource)
        //BitmapScaler.scaleToFitWidth(bitmap, screenWidth)
        //if(passedIndex == 0)
         //   viewHolder.imageHolder.scaleType = ImageView.ScaleType.FIT_XY
        //else
        //viewHolder.imageHolder.scaleType = ImageView.ScaleType.FIT_XY
        viewHolder.sayingTextView.text = StringPatternMatching.returnAllMatchingNameOfProphet(textGiven, context )
    }



    private var passedList:ArrayList<String> = arrayListOf()
    private var scrollType:Int  = 0

    @SuppressLint("NotifyDataSetChanged")
    fun updateInsideAdapter(itemList: ArrayList<String> , typeScroll:Int){
        this.passedList = itemList
        this.scrollType = typeScroll
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