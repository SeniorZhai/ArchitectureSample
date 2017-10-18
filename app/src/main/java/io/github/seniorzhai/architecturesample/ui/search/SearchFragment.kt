package io.github.seniorzhai.architecturesample.ui.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.seniorzhai.architecturesample.App
import io.github.seniorzhai.architecturesample.R
import io.github.seniorzhai.architecturesample.network.ApiService
import io.github.seniorzhai.architecturesample.network.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.item_repo.view.*
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    protected lateinit var apiService: ApiService

    private var mAdapter: DataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSearchFragmentCompoent.builder().appComponent(App[activity].appComponent).build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            layoutInflater.inflate(R.layout.fragment_search, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchBn.setOnClickListener({
            if (searchEdit.text.isEmpty()) {
                return@setOnClickListener
            }

            apiService.searchRepos(searchEdit.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        if (mAdapter == null) {
                            mAdapter = DataAdapter(result.items)
                            recyclerView.adapter = mAdapter
                        } else {
                            mAdapter!!.repos = result.items
                            mAdapter!!.notifyDataSetChanged()
                        }
                    })
        })
    }

    class DataAdapter constructor(var repos: List<Repo>?) : RecyclerView.Adapter<RepoViewHolder>() {

        override fun onBindViewHolder(holder: RepoViewHolder?, position: Int) {
            if (repos != null) {
                holder?.bind(repos!![position])
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder =
                RepoViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_repo, parent, false))

        override fun getItemCount(): Int {
            return if (repos != null) {
                repos!!.size
            } else {
                0
            }
        }

    }

    class RepoViewHolder constructor(containerView: View) : RecyclerView.ViewHolder(containerView) {
        fun bind(repo: Repo) {
            itemView.full_name.text = repo.fullName
            itemView.description.text = repo.description
        }
    }
}
