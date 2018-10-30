/**
 * Copyright (c) 2017 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.alltherages

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.raywenderlich.alltherages.databinding.RecyclerItemRageComicBinding


class RageComicListFragment : Fragment() {

  private lateinit var imageResIds: IntArray
  private lateinit var names: Array<String>
  private lateinit var descriptions: Array<String>
  private lateinit var urls: Array<String>

  companion object {

    fun newInstance(): RageComicListFragment {
      return RageComicListFragment()
    }
  }

  internal inner class RageComicAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private val layoutInflater: LayoutInflater

    init {
      layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
      val recyclerItemRageComicBinding = RecyclerItemRageComicBinding.inflate(layoutInflater,
          viewGroup, false)
      return ViewHolder(recyclerItemRageComicBinding.root, recyclerItemRageComicBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
      val comic = Comic(imageResIds[position], names[position],
          descriptions[position], urls[position])
      viewHolder.setData(comic)
    }

    override fun getItemCount(): Int {
      return names.size
    }
  }

  internal inner class ViewHolder constructor(itemView: View,
                                              val recyclerItemRageComicBinding:
                                              RecyclerItemRageComicBinding) :
      RecyclerView.ViewHolder(itemView) {

    fun setData(comic: Comic) {
      recyclerItemRageComicBinding.comic = comic
    }
  }

}
