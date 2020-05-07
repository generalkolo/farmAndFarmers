package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.Manifest
import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentFarmersDetailsBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import com.example.cleanWithCoRoutine.statistics.utils.*
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import com.tbruyelle.rxpermissions2.RxPermissions

class FarmerDetailsFragment : Fragment(), Step {

    private var _binding: FragmentFarmersDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var rxPermissions: RxPermissions
    private lateinit var statsActivityViewModel: StatisticActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Fresco.initialize(activity!!)
        _binding = FragmentFarmersDetailsBinding.inflate(inflater, container, false)
        statsActivityViewModel =
            ViewModelProvider(activity!!).get(StatisticActivityViewModel::class.java)
        binding.statsViewModel = statsActivityViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        rxPermissions = RxPermissions(this)
        (activity as AppCompatActivity).supportActionBar?.hide()
        initSpinnerItems()
        initClickListeners()
    }

    private fun initSpinnerItems() {
        with(binding.stateSpinner) {
            val states = resources.getStringArray(R.array.nigeria_state).toList()
            attachDataSource(states)
            statsActivityViewModel.initFarmersStateOfOrigin(states[0])
            setOnSpinnerItemSelectedListener { parent, _, position, _ ->
                val clickedState = parent.getItemAtPosition(position)
                statsActivityViewModel.initFarmersStateOfOrigin(clickedState.toString())
            }
        }
    }

    private fun initClickListeners() {
        with(binding) {
            dateOfBirthPicker.container.setOnClickListener {
                val today = MaterialDatePicker.todayInUtcMilliseconds()
                val constraintsBuilder = CalendarConstraints.Builder().apply {
                    setEnd(today)
                    setValidator(DateValidatorPointBackward.now())
                }

                val builder = MaterialDatePicker.Builder.datePicker().apply {
                    setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                    setCalendarConstraints(constraintsBuilder.build())
                    setTitleText("Enter date of birth")
                }
                val picker = builder.build()
                picker.show(activity!!.supportFragmentManager, picker.toString())
                picker.addOnPositiveButtonClickListener {
                    val dateSelected = picker.headerText
                    val yearDifference = it.differenceInYears()
                    with(binding) {
                        dateOfBirthPicker.dateText.text = dateSelected
                        farmersAge.text = yearDifference
                    }
                    with(statsActivityViewModel) {
                        initFarmersAge(yearDifference)
                        initDateOfBirth(dateSelected)
                    }
                }
            }
            nextButton.setOnClickListener {
                statsActivityViewModel.revealContents()
            }
            uploadProfileImage.setOnClickListener {
                val chooseDisplayImageDialog = AlertDialog.Builder(activity!!)
                chooseDisplayImageDialog.setTitle("Choose your profile picture")
                val chooseDisplayImageDialogItems =
                    arrayOf("Take Photo", "Choose from Gallery", "Cancel")
                chooseDisplayImageDialog.setItems(
                    chooseDisplayImageDialogItems
                ) { dialog, which ->
                    when (which) {
                        0 -> takePhotoFromCamera()
                        1 -> choosePhotoFromGallery()
                        3 -> dialog.dismiss()
                    }
                }
                chooseDisplayImageDialog.show()
            }
        }
    }

    private fun takePhotoFromCamera() {
        rxPermissions.request(Manifest.permission.CAMERA)
            .subscribe { granted ->
                if (granted!!) {
                    val takePicture =
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(takePicture, CAMERA_REQUEST_CODE)
                } else {
                    showToast("Operation Failed")
                }
            }
    }

    private fun choosePhotoFromGallery() {
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted!!) {
                    val pickPhoto = Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                    startActivityForResult(pickPhoto, GALLERY_REQUEST_CODE)
                } else {
                    showToast("Operation Failed")
                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            GALLERY_REQUEST_CODE -> {
                if (data != null) {
                    val bitmap = data.data.let {
                        MediaStore.Images.Media.getBitmap(activity!!.contentResolver, it)
                    }
                    displayImageUsingGlide(bitmap, binding.profileImage)
                }
            }
            CAMERA_REQUEST_CODE -> {
                val thumbnail = data!!.extras!!.get("data") as Bitmap
                displayImageUsingGlide(thumbnail, binding.profileImage)
            }
            RESULT_CANCELED -> {
                showToast("Process Cancelled")
            }
        }
    }

    override fun onSelected() {}

    override fun verifyStep(): VerificationError? {
        return null
    }

    override fun onError(error: VerificationError) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}