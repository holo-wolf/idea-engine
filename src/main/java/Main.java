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
import ideaengine.database.DBMS;
import ideaengine.discord.Bot;
import ideaengine.logging.Logger;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, LoginException {
        // Establish that a logging system can be achieved on this operating system.
        Logger log = new Logger();

        // Establish a connection to the Idea Network.
        final DBMS database = new DBMS();

        // Establish a connection to Discord.
        final Bot bot = new Bot();
    }
}
