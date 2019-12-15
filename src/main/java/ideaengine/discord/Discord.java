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
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 * The PostgreSQL abstract class implements the DatabaseADT interface. This class loosely provides a working skeleton
 * of how one should connect Java to PostgreSQL (version 12.1 or later) in order to achieve embedded SQL functionality.
 *
 * <dl>
 *     <dt><span class="strong">void setup()</span></dt><dd>Sets up the Discord bot to connect to Discord via JDA.</dd>
 *     <dt><span class="strong">String getToken()</span></dt><dd>Returns the secret Discord token.</dd>
 * </dl>
 */
abstract class Discord implements BotADT {
    /**
     * This method initializes the Discord bot via JDA.
     *
     * @throws LoginException secret Discord token is incorrect or invalid
     */
    public void setup() throws LoginException {
        JDA client = new JDABuilder(getToken()).build();
    }

    /**
     * This method returns the secret Discord token for the IDEA Discord bot.
     *
     * @return secret Discord token
     */
    public String getToken() {
        return TOKEN;
    }
}
