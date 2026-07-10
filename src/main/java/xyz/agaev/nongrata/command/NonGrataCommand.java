package xyz.agaev.nongrata.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NonGrataCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (!(sender instanceof Player player)) {

            sender.sendMessage("§cКоманда доступна только игроку.");
            return true;

        }

        player.sendMessage("§aNonGrata успешно загружен.");
        player.sendMessage("§7GUI будет подключён в следующих коммитах.");

        return true;

    }

}
