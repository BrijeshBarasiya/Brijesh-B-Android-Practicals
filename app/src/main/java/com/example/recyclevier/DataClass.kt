package com.example.recyclevier

import androidx.annotation.DrawableRes
import com.example.basicofkotlin.R

class ExpandableListViewValues (
    val headingList: String,
    val subList: List<String>
)

class ExpandableRecyclerViewValues(
    @DrawableRes val image: Int,
    val title: String,
    val subData: String
)

class GridRecyclerViewValues(
    val title: String,
    @DrawableRes val img: Int
)

class PlayStoreValues(
    val title: String,
    val apps: ArrayList<PlayStoreAppValues>
)

class PlayStoreAppValues(
    val title: String,
    @DrawableRes val img: Int
)

class CustomListViewValue(
    val heading: String,
    val dscp: String
)

class DataClass {

    companion object {
        val expandableRecyclerViewValues = arrayListOf(
            ExpandableRecyclerViewValues(
                R.drawable.ic_android_icon,
                "Android",
                "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets."
            ),
            ExpandableRecyclerViewValues(
                R.drawable.ic_ios,
                "iOS",
                "Apple (AAPL) iOS is the operating system for iPhone, iPad, and other Apple mobile devices. Based on Mac OS, the operating system which runs Apple’s line of Mac desktop and laptop computers, Apple iOS is designed for easy, seamless networking between a range of Apple products."
            ),
            ExpandableRecyclerViewValues(
                R.drawable.ic_window,
                "Windows",
                "Windows is an operating system designed by Microsoft. The operating system is what allows you to use a computer. Windows comes preloaded on most new personal computers (PCs), which helps to make it the most popular operating system in the world."
            ),
            ExpandableRecyclerViewValues(
                R.drawable.ic_mac,
                "Mac",
                "MacOS, formerly (1984–2001) Mac OS and (2001–2016) Mac OS X, operating system (OS) developed by the American computer company Apple Inc. The OS was introduced in 1984 to run the company’s Macintosh line of personal computers (PCs). The Macintosh heralded the era of graphical user interface (GUI) systems, and it inspired Microsoft Corporation to develop its own GUI, the Windows OS."
            )
        )

        val expandableListViewValues = arrayListOf(
            ExpandableListViewValues("Item 1", listOf("A", "B", "C", "D", "E")),
            ExpandableListViewValues("Item 2", listOf("A", "B")),
            ExpandableListViewValues("Item 3", listOf("A")),
            ExpandableListViewValues("Item 4", listOf("A", "B", "C"))
        )

        val gridRecyclerViewValues = arrayListOf(
            GridRecyclerViewValues("Home", R.drawable.ic_home),
            GridRecyclerViewValues("Call", R.drawable.ic_call),
            GridRecyclerViewValues("Profile", R.drawable.ic_profile),
            GridRecyclerViewValues("Setting", R.drawable.ic_setting),
            GridRecyclerViewValues("Done", R.drawable.ic_done),
            GridRecyclerViewValues("Android", R.drawable.ic_android_icon),
            GridRecyclerViewValues("iOS", R.drawable.ic_ios),
            GridRecyclerViewValues("Windows", R.drawable.ic_window),
            GridRecyclerViewValues("Mac", R.drawable.ic_mac),
        )

        val playStoreValues = arrayListOf(
            PlayStoreValues("Google",
                arrayListOf(
                    PlayStoreAppValues("Chrome", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Map", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Photo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GPay", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Message", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Google", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Translate", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gmail", R.drawable.ic_android_icon),
                    PlayStoreAppValues("File", R.drawable.ic_android_icon),
                    PlayStoreAppValues("TV", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GBoard", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Meet", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Play", R.drawable.ic_android_icon)
                )
            ),
            PlayStoreValues("Game",
                arrayListOf(
                    PlayStoreAppValues("Chrome", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Map", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Photo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GPay", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Message", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Google", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Translate", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gmail", R.drawable.ic_android_icon),
                    PlayStoreAppValues("File", R.drawable.ic_android_icon),
                    PlayStoreAppValues("TV", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GBoard", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Meet", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Play", R.drawable.ic_android_icon)
                )
            ),
            PlayStoreValues("Books",
                arrayListOf(
                    PlayStoreAppValues("Chrome", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Map", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Photo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GPay", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Message", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Google", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Translate", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gmail", R.drawable.ic_android_icon),
                    PlayStoreAppValues("File", R.drawable.ic_android_icon),
                    PlayStoreAppValues("TV", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GBoard", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Meet", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Play", R.drawable.ic_android_icon)
                )
            ),
            PlayStoreValues("Trading Apps",
                arrayListOf(
                    PlayStoreAppValues("Chrome", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Map", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Photo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GPay", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Message", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Google", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Translate", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gmail", R.drawable.ic_android_icon),
                    PlayStoreAppValues("File", R.drawable.ic_android_icon),
                    PlayStoreAppValues("TV", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GBoard", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Meet", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Play", R.drawable.ic_android_icon)
                )
            ),
            PlayStoreValues("Popular Apps",
                arrayListOf(
                    PlayStoreAppValues("Chrome", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Map", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Photo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GPay", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Message", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Google", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Translate", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gmail", R.drawable.ic_android_icon),
                    PlayStoreAppValues("File", R.drawable.ic_android_icon),
                    PlayStoreAppValues("TV", R.drawable.ic_android_icon),
                    PlayStoreAppValues("GBoard", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Meet", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Play", R.drawable.ic_android_icon)
                )
            ),
            PlayStoreValues("Single Player Game",
                arrayListOf(
                    PlayStoreAppValues("Candy Crush", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Roblox", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Subway Surfers", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Ludo", R.drawable.ic_android_icon),
                    PlayStoreAppValues("8 Ball Pool", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Homescapes", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Hunter Assassin", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Mini Militia", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Brain Out", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Gradenscapes", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Twonship", R.drawable.ic_android_icon),
                    PlayStoreAppValues("Frag", R.drawable.ic_android_icon),
                    PlayStoreAppValues("My Talking Tom", R.drawable.ic_android_icon)
                )
            )
        )

        val customListViewValue = arrayListOf(
            CustomListViewValue("Heading1", "Item1"),
            CustomListViewValue("Heading2", "Item2"),
            CustomListViewValue("Heading3", "Item3"),
            CustomListViewValue("Heading4", "Item4"),
            CustomListViewValue("Heading5", "Item5"),
            CustomListViewValue("Heading6", "Item6")
        )

        val simpleListValues = arrayListOf("Item1", "Item2", "Item3", "Item4")
    }

}
