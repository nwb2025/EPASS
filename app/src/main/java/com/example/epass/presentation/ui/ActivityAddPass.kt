package com.example.epass.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.epass.data.db.AppDataBase
import com.example.epass.data.db.DAO
import com.example.epass.data.db.PassDataSource
import com.example.epass.data.db.Repo
import com.example.epass.databinding.ActivityNewPassBinding
import com.example.epass.frameworks.RoomDataSource
import com.example.epass.interactors.GetPasses
import com.example.epass.interactors.InsertPass
import com.example.epass.presentation.adapters.MyRecAdapter
import com.example.epass.presentation.viewmodels.AddViewModel
import com.example.epass.presentation.viewmodels.ViewModelFactory

class ActivityAddPass : AppCompatActivity() {
    private lateinit var binding : ActivityNewPassBinding
    private lateinit var adapter: MyRecAdapter
    private var db:AppDataBase?= null
    private var dao:DAO? = null
    private var dataSource: PassDataSource? = null
    private var sharedViewModel: AddViewModel? = null
    private var repo: Repo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = AppDataBase.getAppDB(this@ActivityAddPass)
        dao = db?.passDao()
        dataSource = RoomDataSource(dao)
        repo =
            Repo(dataSource as PassDataSource)

        val factory = ViewModelFactory(
            GetPasses(repo as Repo),
            InsertPass(repo as Repo)
        )

        sharedViewModel = ViewModelProvider(  this@ActivityAddPass, factory).get(AddViewModel::class.java)

        binding = ActivityNewPassBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnReady.setOnClickListener{
            // TODO: should be fixed with the vm
            sharedViewModel?.insertPass(binding.etName.text.toString())
            finish()
        }

        binding.btnBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


        sharedViewModel?.n?.observe(this, Observer {
            Log.i("name", it.toString())
        })

    }
}