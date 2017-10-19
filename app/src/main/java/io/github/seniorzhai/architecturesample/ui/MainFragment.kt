package io.github.seniorzhai.architecturesample.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.github.seniorzhai.architecturesample.App
import io.github.seniorzhai.architecturesample.R
import io.github.seniorzhai.architecturesample.getRandomTime
import io.github.seniorzhai.architecturesample.network.ApiService
import io.github.seniorzhai.architecturesample.network.Story
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_story.view.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    protected lateinit var apiService: ApiService

    private var mAdapter: DataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainFragmentCompoent.builder().appComponent(App[activity].appComponent).build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            layoutInflater.inflate(R.layout.fragment_main, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadBn.setOnClickListener({ load() })
        load()
    }

    private fun load() {
        var time = getRandomTime()
        dateTv.text = time
        apiService.getNewsBefore(time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    if (mAdapter == null) {
                        mAdapter = DataAdapter(result.stories)
                        recyclerView.adapter = mAdapter
                    } else {
                        mAdapter!!.repos = result.stories
                        mAdapter!!.notifyDataSetChanged()
                    }
                }, { e ->
                    dateTv.text = e.message
                })
    }


    class DataAdapter constructor(var repos: List<Story>?) : RecyclerView.Adapter<RepoViewHolder>() {

        override fun onBindViewHolder(holder: RepoViewHolder?, position: Int) {
            if (repos != null) {
                holder?.bind(repos!![position])
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder =
                RepoViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_story, parent, false))

        override fun getItemCount(): Int {
            return if (repos != null) {
                repos!!.size
            } else {
                0
            }
        }

    }

    class RepoViewHolder constructor(containerView: View) : RecyclerView.ViewHolder(containerView) {
        fun bind(story: Story) {
            itemView.full_name.text = story.title
            if (story.images.isNotEmpty())
                Glide.with(itemView.image).load(story.images[0]).into(itemView.image)
        }
    }
}