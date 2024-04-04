import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.advweek6160421148.model.Car
import androidx.lifecycle.AndroidViewModel



class CarViewModel(application: Application) : AndroidViewModel(application) {

    private var queue: RequestQueue? = null
    val carsLD = MutableLiveData<ArrayList<Car>>()
    val carLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/cars/cars.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val sType = object : TypeToken<List<Car>>() {}.type
                val result = Gson().fromJson<List<Car>>(response, sType)
                carsLD.value = result as ArrayList<Car>?
                Log.d("showvolley", result.toString())
            },
            Response.ErrorListener { error ->
                Log.d("showvolley" , error.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}
