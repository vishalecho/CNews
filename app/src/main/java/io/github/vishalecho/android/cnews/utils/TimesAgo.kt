package io.github.vishalecho.android.cnews.utils

object TimesAgo {

    fun get(timeStamp: Long): String {
        //difference between current time and given timestamp in seconds
        val diff = (System.currentTimeMillis()/1000) - timeStamp

        // Convert time difference in minutes
        val min = diff / 60

        // Convert time difference in hours
        val hours = diff / 3600

        // Convert time difference in days
        val days = diff / 86400

        // Convert time difference in months
        val months = diff / 2592000

        // Convert time difference in years
        val years = diff / 31104000

        // Check for seconds
        when {
            diff <= 60 -> {
                return if (diff == 1.toLong()) "1 second ago"
                else "$diff seconds ago"
            }
            // Check for minutes
            min <= 60 -> {
                return if (min == 1.toLong()) "1 minute ago"
                else "$min minutes ago"
            }
            // Check for hours
            hours <= 24 -> {
                return if (hours == 1.toLong()) "1 hour ago"
                else "$hours hours ago"
            }
            // Check for days
            days <= 7 -> {
                return if (days == 1.toLong()) "1 day ago"
                else "$days days ago"
            }
            // Check for months
            months <= 12 -> {
                return if (months == 1.toLong()) "1 month ago"
                else "$months months ago"
            }
            // Check for years
            else -> {
                return if (years == 1.toLong()) "1 year ago"
                else "$years years ago"
            }
        }
    }
}