package me.skymc.temp

import taboolib.common.platform.Plugin
import taboolib.common.util.unsafeLazy
import taboolib.platform.BukkitPlugin

object Temp : Plugin() {

    val plugin by unsafeLazy {
        BukkitPlugin.getInstance()
    }
}