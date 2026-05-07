package com.lapisdev.vanillacraft.link;

import com.lapisdev.vanillacraft.database.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Linker {
    public static void link(String discordUuid, UUID minecraftUuid) {
        try {
            PreparedStatement statement = Database.conn.prepareStatement("insert or replace into player" +
                    "(player_id, discord_uuid, minecraft_uuid) " +
                    "values ((select player_id from player where discord_uuid = " + discordUuid + "), ?, ?)");
            statement.setString(1, discordUuid);
            statement.setString(2, minecraftUuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
