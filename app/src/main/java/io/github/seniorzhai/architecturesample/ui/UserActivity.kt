package io.github.seniorzhai.architecturesample.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.github.seniorzhai.architecturesample.Injection
import io.github.seniorzhai.architecturesample.Obj
import io.github.seniorzhai.architecturesample.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : AppCompatActivity() {
    // lateinit 延迟初始化
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: UserViewModel

    @Inject
    protected lateinit var obj: Obj

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        // 注入
        DaggerUserActivityCompoent.builder().build().inject(this)

        viewModelFactory = Injection.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        button.setOnClickListener({updateUserName()})
    }

    override fun onStart() {
        super.onStart()
        disposable.add(viewModel.userName().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ this.user_name.text = it }, { error ->
                    Log.e("Tag", "error")
                })
        )
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    private fun updateUserName() {
        val userName = user_name_input.text.toString()
        button.isEnabled = false
        disposable.add(viewModel.updateUserName(userName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ button.isEnabled = true }, { Log.e("Tag", "error") }
                ))
    }
}
