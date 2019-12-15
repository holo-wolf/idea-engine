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

import javax.security.auth.login.LoginException;

/**
 * The BotADT interface provides an abstraction of the different types of variables and methods one may use to connect
 * their bot to Discord. Utilizing environment variables for sensitive information is strongly recommended.
 *
 * <d>
 *     <dt><span class="strong">TOKEN</span></dt><dd>Secret Discord token in order to connect to the Discord bot.</dd>
 * </d>
 */
interface BotADT {
    String TOKEN = System.getenv("DISCORD_IDEA_TOKEN");  // https://discordapp.com/developers/applications/

    /**
     * This method initializes the Discord bot via JDA.
     *
     * @throws LoginException secret Discord token is incorrect or invalid
     */
    void setup() throws LoginException;

    /**
     * This method returns the secret Discord token for the IDEA Discord bot.
     *
     * @return secret Discord token
     */
    String getToken();
}
