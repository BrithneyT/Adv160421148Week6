import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek6160421148.databinding.CarListItemBinding
import com.example.advweek6160421148.model.Car

class CarListAdapter(private val carList: ArrayList<Car>) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    class CarViewHolder(val binding: CarListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]

        holder.binding.txtModel.text = carList[position].id
        holder.binding.txtColor.text = carList[position].color
        holder.binding.txtPrice.text = carList[position].price

//        holder.binding.btnDetail.setOnClickListener {
//            // Handle click event for detail button
//            // Example navigation using Safe Args:
//            // val action = CarListFragmentDirections.actionCarDetail(carId = car.id)
//            // Navigation.findNavController(it).navigate(action)
//        }
    }

    fun updateCarList(newCarList: ArrayList<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }
}
