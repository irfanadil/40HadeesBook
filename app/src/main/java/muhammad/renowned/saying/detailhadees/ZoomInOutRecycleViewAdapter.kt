package muhammad.renowned.saying.detailhadees

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ortiz.touchview.TouchImageView


class ZoomInOutRecycleViewAdapter  : RecyclerView.Adapter<ZoomInOutRecycleViewAdapter.ViewHolder>() {

    // Array of images
    // Adding images from drawable folder


    /*
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ImagesHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

     // The ViewHolder class holds the view
    class ViewHolder(binding: TouchImageView) :RecyclerView.ViewHolder(binding.root) {
        var imageHolder: ImageView = binding.images
    }

     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TouchImageView(parent.context).apply {

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )


            setOnTouchListener { view, event ->
                var result = true
                //can scroll horizontally checks if there's still a part of the image
                //that can be scrolled until you reach the edge
                if (event.pointerCount >= 2 || view.canScrollHorizontally(1) && canScrollHorizontally(
                        -1
                    )
                ) {
                    //multi-touch event
                    result = when (event.action) {
                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                            // Disallow RecyclerView to intercept touch events.
                            parent.requestDisallowInterceptTouchEvent(true)
                            // Disable touch on view
                            false
                        }

                        MotionEvent.ACTION_UP -> {
                            // Allow RecyclerView to intercept touch events.
                            parent.requestDisallowInterceptTouchEvent(false)
                            true
                        }

                        else -> true
                    }
                }
                result
            }
        })
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

        viewHolder.imageHolder.scaleType = ImageView.ScaleType.CENTER_INSIDE
        viewHolder.imageHolder.setImageResource(image)
    }






    class ViewHolder(view: TouchImageView) : RecyclerView.ViewHolder(view) {
        val imageHolder = view
    }


    private var passedList:IntArray = intArrayOf()


    @SuppressLint("NotifyDataSetChanged")
    fun updateZoomAdapter(itemList: IntArray){
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