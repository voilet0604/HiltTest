package com.violet.testdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class RectView(context: Context, attrs: AttributeSet?, style: Int): View(context, attrs, style) {

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context): this(context, null)

    private val mRectF = RectF()
    private val mRadius = 300f
    private val mCenterPointF = PointF()

    private val mPaint = Paint()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCenterPointF.x = w * 0.5f
        mCenterPointF.y = h * 0.5f
        mRectF.right = mRadius
        mRectF.bottom = mRadius
        mRectF.left = -mRadius
        mRectF.top = -mRadius

        mPaint.shader = LinearGradient(0f, -mRadius, mRadius * 2, mRadius * 2, intArrayOf(
            ContextCompat.getColor(context, android.R.color.transparent),
            ContextCompat.getColor(context, android.R.color.system_accent1_100),
            ContextCompat.getColor(context, android.R.color.system_accent1_200),
        ), null, Shader.TileMode.CLAMP)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate(mCenterPointF.x, mCenterPointF.y)

//        canvas.drawRect(mRectF, mPaint)

        canvas.drawArc(mRectF, -90f, 53f, true, mPaint)
    }
}