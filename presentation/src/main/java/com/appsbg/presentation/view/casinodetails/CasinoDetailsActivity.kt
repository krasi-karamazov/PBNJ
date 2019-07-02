package com.appsbg.presentation.view.casinodetails

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.presentation.R
import com.appsbg.presentation.base.BaseActivity
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.utils.PermissionsHandler
import com.appsbg.presentation.viewmodel.casinodetails.CasinoDetailsViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.content_casino_profile.*
import javax.inject.Inject
import android.location.Location
import android.content.Intent
import android.net.Uri
import android.view.View


class CasinoDetailsActivity: BaseActivity() {

    companion object{
        const val CASINO_EXTRAS_KEY = "extra:casino"
        const val PERMISSION_REQUEST_CODE = 666
    }

    @Inject
    internal lateinit var vmFactory: ViewModelFactory

    @Inject
    internal lateinit var permissionsHandler: PermissionsHandler

    private lateinit var viewModel: CasinoDetailsViewModel
    private var casino: Casino? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = vmFactory.get()
        initView()

    }

    @SuppressLint("MissingPermission")
    private fun checkPermission() {
        if(permissionsHandler.checkHasPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) &&  permissionsHandler.checkHasPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationClient.lastLocation.addOnSuccessListener {
                if(it != null) {
                    val casinoLocation = Location("casino")
                    casinoLocation.latitude = casino!!.lat
                    casinoLocation.longitude = casino!!.lng
                    distance.text = String.format("%.1f км.", it.distanceTo(casinoLocation) / 1000)
                }
            }
        }else {
            permissionsHandler.requestPermission(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_CODE)
        }
    }

    private fun initView() {
        casino?.let { casinoObj ->
            h_name.text = casinoObj.name
            description.loadDataWithBaseURL("", casinoObj.description, "text/html", "UTF-8", "")
            casino_address.apply {
                text = String.format("%s, %s", casinoObj.cityName, casinoObj.address)
                setOnClickListener{
                    val latitude = casinoObj.lat
                    val longitude = casinoObj.lng
                    val labelLocation = casinoObj.name
                    val gmmIntentUri = Uri.parse("geo:<$latitude>,<$longitude>?q=<$latitude>,<$longitude>($labelLocation)")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    if (mapIntent.resolveActivity(packageManager) != null) {
                        startActivity(mapIntent)
                    }
                }
            }
            casino_phone.text = casinoObj.phone
            slider_arrow_right.visibility = if (casinoObj.images.size > 1) View.VISIBLE else View.GONE
            slider_arrow_left.visibility = if (casinoObj.images.size > 1) View.VISIBLE else View.GONE
        }

        setupGallery()
    }

    private fun setupGallery() {
        pager
    }

    override fun getLayoutId(): Int = R.layout.activity_casino_profile

}