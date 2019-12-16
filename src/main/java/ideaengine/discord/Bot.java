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

import java.io.IOException;
import javax.security.auth.login.LoginException;

/**
 * The Bot class handles the connection to Discord along with all other capabilities related to Discord. If you prefer
 * to use something other than JDA (which is what handles the actual connection between the bot and Discord), these
 * settings can be modified in the Discord.java source file within this package.
 *
 * <dl>
 *     <dt><span class="strong">Bot()</span></dt><dd>Constructor that initializes the Discord bot.</dd>
 * </dl>
 */
public class Bot extends Discord {
    /**
     * The Bot constructor initializes the Discord bot to connect with Discord via JDA and a secret Discord token (which
     * should be retrievable via an environment variable).
     *
     * @throws IOException logging system is not properly configured
     * @throws LoginException secret Discord token is incorrect or invalid
     */
    public Bot() throws IOException, LoginException {
        KnownUsers.setupUsers();  // setup the user list
        KnownUsers.setupServers();  // setup the server list

        setup();
    }
}
