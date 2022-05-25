package com.tayo.checkoutsample.util

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.MimeTypeMap
import androidx.annotation.RequiresApi
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.ISODateTimeFormat
import timber.log.Timber
import java.io.*
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

const val AMOUNT_FORMAT_TEXTFIELD = "#,##0.##"
const val AMOUNT_FORMAT_TWO_DECIMALS = "#,##0.00"
const val AMOUNT_FORMAT_THREE_DECIMALS = "#,##0.000"
const val ZEROS_DATETIME = "0000-00-00 00:00:00"
const val TEN = 10

object Helper {

    fun formatDate(inputDate: String): String? {
        try {
            val format = DateTimeFormat.forPattern("MMM d, yyyy, h:mm aa")
            val parser = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
            val dateTime = parser.parseDateTime(inputDate)
            return format.print(dateTime)
        } catch (e: ParseException) {
            Timber.d(e)
        }
        return ""
    }

    fun formatDateSimple(inputDate:String):String?{
        try{
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val date =  sdf.parse(inputDate)
            val newSdf = SimpleDateFormat("MMM d, yyyy")
            date?.let{
                return   newSdf.format(it)
            }
        }catch (e:ParseException){
            Timber.d(e)
        }
        return ""
    }

    fun formatToDollar(amount: Double): String {
        val locale = Locale("en", "US")
        return NumberFormat.getCurrencyInstance(locale).format(amount)
    }

    fun formatAmount(amount: Double, format: String): String {
        return run {
            val df = DecimalFormat(format)
            df.roundingMode = RoundingMode.CEILING
            df.format(amount)
        }
    }

    fun formatAmount(amount: Double): String {
        return run {
            var df = DecimalFormat(AMOUNT_FORMAT_TWO_DECIMALS)
            df.roundingMode = RoundingMode.CEILING
            df.format(amount)
        }
    }

    fun pesoCurrency(amount: String): String {
        return "₱ $amount"
    }

    fun getCurrentDateTime(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        .format(Calendar.getInstance().time).toString()

    fun getCurrentTimeInMillis(): Long {
        return System.currentTimeMillis()
    }

    fun formatDatePicker(s: Long): String? {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val netDate = Date(s)
            sdf.format(netDate)
        } catch (e: ParseException) {
            e.toString()
        }
    }

    val monthsOfTheYear = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    fun formatTo2Digit(num: Int):String = if (num< TEN) "0${num}" else num.toString()

    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    /**
     * Converts ISO 8601 date String to its millisecond equivalent
     */
    fun convertISOStringToMilli(inputDate: String): Long? {
        try {
            val df = SimpleDateFormat(ISO_8601_FORMAT)
            df.timeZone = TimeZone.getTimeZone("UTC")
            val date = df.parse(inputDate)
            return date?.time
        } catch (e: ParseException) {
            Timber.d(e)
        }
        return null
    }

    fun getEmailIntent(emailAddresses: Array<String>, subject: String): Intent {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = (Uri.parse("mailto:"))
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        return intent
    }
}
