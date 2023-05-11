package com.vrem.wifianalyzer.permission

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import com.vrem.annotation.OpenClass
import com.vrem.util.buildMinVersionP
import com.vrem.wifianalyzer.R

@OpenClass
class PermissionDialog(private val activity: Activity) {
    fun show() {
        val view = activity.layoutInflater.inflate(R.layout.info_permission, null)
        val visibility = if (buildMinVersionP()) View.VISIBLE else View.GONE
        view.findViewById<View>(R.id.throttling)?.visibility = visibility
        AlertDialog.Builder(activity)
                .setView(view)
                .setTitle(R.string.app_full_name)
                .setIcon(R.drawable.ic_app)
                .setPositiveButton(android.R.string.ok, OkClick(activity))
                .setNegativeButton(android.R.string.cancel, CancelClick(activity))
                .create()
                .show()
    }

    internal class OkClick(private val activity: Activity) : DialogInterface.OnClickListener {
        override fun onClick(alertDialog: DialogInterface, which: Int) {
            alertDialog.dismiss()
            activity.requestPermissions(ApplicationPermission.PERMISSIONS, ApplicationPermission.REQUEST_CODE)
        }

    }

    internal class CancelClick(private val activity: Activity) : DialogInterface.OnClickListener {
        override fun onClick(alertDialog: DialogInterface, which: Int) {
            alertDialog.dismiss()
            activity.finish()
        }

    }

}