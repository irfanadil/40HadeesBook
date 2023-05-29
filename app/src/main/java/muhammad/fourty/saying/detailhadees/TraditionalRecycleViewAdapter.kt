package muhammad.fourty.saying.detailhadees

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import muhammad.fourty.saying.databinding.ImagesHolderBinding


class TraditionalRecycleViewAdapter  : RecyclerView.Adapter<TraditionalRecycleViewAdapter.ViewHolder>() {

    // Array of images
    // Adding images from drawable folder



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ImagesHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

     // The ViewHolder class holds the view
    class ViewHolder(binding: ImagesHolderBinding) :RecyclerView.ViewHolder(binding.root) {
        var imageHolder: ImageView = binding.images
    }







    // This method returns our layout
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.images_holder, parent, false)
        return ViewHolder(view)
    }*/

    // This method binds the screen with the view
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val image = passedList[position]
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
        viewHolder.imageHolder.setImageResource(image)
    }



    private var passedList:IntArray = intArrayOf()
    private var scrollType:Int  = 0

    @SuppressLint("NotifyDataSetChanged")
    fun updateInsideAdapter(itemList: IntArray , typeScroll:Int){
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