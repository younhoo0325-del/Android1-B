package com.example.project;

import android.animation.ObjectAnimator;import android.graphics.Color;import androidx.recyclerview.widget.DefaultItemAnimator;import androidx.recyclerview.widget.RecyclerView;
public class FadeInAnimator extends DefaultItemAnimator{@Override public boolean animateAdd(RecyclerView.ViewHolder holder){android.view.View v=holder.itemView;v.setAlpha(0f);v.setBackgroundColor(Color.YELLOW);v.animate().alpha(1f).setDuration(500).start();ObjectAnimator animator=ObjectAnimator.ofArgb(v,"backgroundColor",Color.YELLOW,Color.CYAN);animator.setDuration(800);animator.setStartDelay(100);animator.start();return super.animateAdd(holder);}}
