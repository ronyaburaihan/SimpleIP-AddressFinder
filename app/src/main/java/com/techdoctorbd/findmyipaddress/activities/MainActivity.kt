package com.techdoctorbd.findmyipaddress.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techdoctorbd.findmyipaddress.R
import com.techdoctorbd.findmyipaddress.models.ServerResponse
import com.techdoctorbd.findmyipaddress.network.ApiInterface
import com.techdoctorbd.findmyipaddress.network.RetrofitApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMyIp()
    }

    private fun showMyIp() {
        progressBar.visibility = View.VISIBLE //network call will start. So, show progress bar
        val apiInterface: ApiInterface =
            RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
        val call: Call<ServerResponse?>? = apiInterface.getMyIp()
        call!!.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>,
                response: Response<ServerResponse?>
            ) {
                progressBar.visibility = View.GONE //network call success. So hide progress bar
                val serverResponse: ServerResponse = response.body()!!
                if (response.code() == 200) { //response code 200 means server call successful
                    //data found. So place the data into TextView
                    tv_ip_address.text = serverResponse.ip
                    tv_city.text = serverResponse.city
                    tv_zip_code.text = serverResponse.zipCode
                    tv_country_name.text = serverResponse.country
                    tv_country_code.text = serverResponse.countryIso
                    tv_time_zone.text = serverResponse.timeZone
                    tv_isp_name.text = serverResponse.asnOrg
                } else {
                    //somehow data not found. So error message showing in first TextView
                    Toast.makeText(this@MainActivity, response.message(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                progressBar.visibility = View.GONE //network call failed. So hide progress bar

                //network call failed due to disconnect internet connection or server error
                Toast.makeText(this@MainActivity,"${t.message}",Toast.LENGTH_LONG).show()
            }
        })
    }
}