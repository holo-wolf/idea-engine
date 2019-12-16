/* *********************************************************************************************************************
 * Copyright (c) 2019 Allan D. Boswell
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 * ****************************************************************************************************************** */
package ideaengine.discord;

import ideaengine.database.DBMS;

import java.io.IOException;
import java.util.HashSet;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/* TODO: Check if a user's ID exists in a database. I'm thinking about maybe retrieving a list of all stored userID's
*   and storing them in a data structure for quick access. If no match, then store the new userID into the database. */
public class KnownUsers extends ListenerAdapter {
    private HashSet<String> users = new HashSet<>();  // list of all users
    private HashSet<String> servers = new HashSet<>();  // list of all servers

    /**
     * This method determines if a user in any given server is currently "known" (e.g. his or her information is stored
     * within the Idea Network database. If yes, then nothing happens. If no, then the user's information will be stored
     * appropriately. This will ALSO check for a known or unknown Discord server (guild) and apply the same logic
     * towards that.
     *
     * @param event a message was sent in any given Discord server by either a known or unknown user
     */
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        // Determines if the user is known...
        if (!isKnownUser(event.getAuthor().getId())) {
            try {
                DBMS database = new DBMS(false);

                database.insertDiscordUser(event.getAuthor().getId());
                users.add(event.getAuthor().getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Determines if the server is known...
        if (!isKnownServer(event.getGuild().getId())) {
            try {
                DBMS database = new DBMS(false);

                database.insertDiscordServer(event.getGuild().getId());
                servers.add(event.getGuild().getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method determines whether or not a user has been encountered before or not. This is to prevent IDEA from
     * having to access the database needlessly.
     *
     * @param userID Discord user identification string
     * @return true if userID exists in HashSet data structure
     */
    private boolean isKnownUser(String userID) {
        return users.contains(userID);
    }

    /**
     * This method determines whether or not a server has been encountered before or not. This is to prevent IDEA from
     * having to access the database needlessly.
     *
     * @param serverID Discord server identification string
     * @return true if serverID exists in HashSet data structure
     */
    private boolean isKnownServer(String serverID) {
        return servers.contains(serverID);
    }
}
