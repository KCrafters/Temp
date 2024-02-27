package me.skymc.temp

import org.bukkit.Sound
import org.bukkit.entity.Player
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(name = "temp", aliases = ["t"])
object TempCommands {

    @CommandBody
    val main = mainCommand {
        createHelper()
    }

    @CommandBody
    val playSound = subCommand {
        dynamic(comment = "sound") {
            suggest { Sound.values().map { it.name } }
            dynamic(comment = "volume") {
                dynamic(comment = "pitch") {
                    execute<Player> { sender, context, argument ->
                        sender.playSound(
                            sender.location,
                            Sound.values().first { it.name == context["sound"] },
                            context["volume"].toFloat(),
                            context["pitch"].toFloat()
                        )
                        sender.sendMessage("&c[System] &7播放声音 ${context["sound"]} ${context["volume"]} ${context["pitch"]}".colored())
                    }
                }
            }
        }
    }
}